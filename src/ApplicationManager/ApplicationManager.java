package ApplicationManager;

import DatabaseTools.OracleConnection;
import GUI.LoginWindow;
import GUI.MainWindow;

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

    public String getCountOfStrings() throws SQLException {
        return oracleConnection.showCountOfStrings();
    }

}
