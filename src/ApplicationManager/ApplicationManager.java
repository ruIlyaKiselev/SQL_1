package ApplicationManager;

import DatabaseTools.OracleConnection;
import GUI.LoginWindow;
import GUI.MainWindow;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class ApplicationManager {
    private OracleConnection oracleConnection;

    private LoginWindow loginWindow;
    private MainWindow mainWindow;

    public ApplicationManager() {
        try {
            oracleConnection = new OracleConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        loginWindow = new LoginWindow(this);
        mainWindow = new MainWindow(this);

        loginWindow.setVisible(true);
    }

    public void login(String URL, String login, String password) throws SQLException {
        oracleConnection.connectToDatabase(URL, login, password);
        loginWindow.setVisible(false);
        mainWindow.setVisible(true);
    }

    public void initDatabase() {
        try {
            oracleConnection.initDatabaseAndTestData();
        } catch (SQLException throwables) {
            System.err.println("SQL request error: " + throwables.getMessage());
        } catch (FileNotFoundException e) {
            System.err.println("Problem in parsing SQL file");
        }
    }

    public void dropTables() {
        try {
            oracleConnection.dropTables();
        } catch (FileNotFoundException e) {
            System.err.println("Problem in parsing SQL file");
        } catch (SQLException throwables) {
            System.err.println("SQL request error: " + throwables.getMessage());
        }
    }

    public String getCountOfStrings() throws SQLException {
        return oracleConnection.showCountOfStrings();
    }
}
