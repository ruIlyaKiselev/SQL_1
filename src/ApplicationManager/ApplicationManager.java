package ApplicationManager;

import DatabaseTools.OracleConnection;
import GUI.LoginWindow;
import GUI.MainWindow;
import GUI.ManualModeWindow;
import GUI.TableManageWindow;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Locale;
import java.util.Vector;

public class ApplicationManager {
    private OracleConnection oracleConnection;

    private LoginWindow loginWindow;
    private MainWindow mainWindow;
    private TableManageWindow tableManageWindow;
    private ManualModeWindow manualModeWindow;

    public ApplicationManager() {
        try {
            oracleConnection = new OracleConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        loginWindow = new LoginWindow(this);
        mainWindow = new MainWindow(this);
        tableManageWindow = new TableManageWindow(this);
        manualModeWindow = new ManualModeWindow(this);

        loginWindow.setVisible(true);
    }

    public void login(String URL, String login, String password) throws SQLException {
        oracleConnection.connectToDatabase(URL, login, password);
        loginWindow.setVisible(false);
        mainWindow.setVisible(true);
        manualModeWindow.setVisible(false);
    }

    public void showTableManageWindow() {
        tableManageWindow.loadDataToTable();
        mainWindow.setVisible(false);
        tableManageWindow.setVisible(true);
        manualModeWindow.setVisible(false);
    }

    public void showMainWindow() {
        mainWindow.setVisible(true);
        tableManageWindow.setVisible(false);
        loginWindow.setVisible(false);
        manualModeWindow.setVisible(false);
    }

    public void showManualModeWindow() {
        mainWindow.setVisible(false);
        tableManageWindow.setVisible(false);
        loginWindow.setVisible(false);
        manualModeWindow.setVisible(true);
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

    public ResultSet executeQuery(String query) throws SQLException {
        ResultSet resultSet = oracleConnection.executeQuery(query);
        return resultSet;
    }

    public DefaultTableModel getTableByName(String tableName) throws SQLException {
        return oracleConnection.getTableModelByQuery("SELECT * FROM  " + tableName);
    }

    public DefaultComboBoxModel getAllTables() {
        try {
            ResultSet resultSet = oracleConnection.executeQuery("SELECT table_name FROM user_tables");
            Vector<String> result = new Vector<>();

            while (resultSet.next()) {
                result.add(resultSet.getString(1));
            }
            return new DefaultComboBoxModel(result);
        } catch (SQLException e) {
            return new DefaultComboBoxModel();
        }
    }

    public void oracleCommit() throws SQLException {
        oracleConnection.commit();
    }

    public void oracleRollback() throws SQLException {
        oracleConnection.rollback();
    }

    public void oracleAddRow(String tableName, Vector<String> cols, Vector<String> values) throws SQLException {
        ResultSetMetaData resultSetMetaData = oracleConnection.executeQuery("SELECT * FROM " + tableName).getMetaData();

        StringBuilder query = new StringBuilder("INSERT INTO " + tableName + " (");
        for (int i = 0; i != cols.size(); i++) {
            query.append(cols.get(i));
            if (i != cols.size() - 1) {
                query.append(", ");
            }
        }
        query.append(") VALUES (");

        for (int i = 0; i != values.size(); i++) {
            if (resultSetMetaData.getColumnTypeName(i + 1).toLowerCase(Locale.ROOT).contains("varchar")
                    || resultSetMetaData.getColumnTypeName(i + 1).toLowerCase(Locale.ROOT).contains("date")) {
                query.append("'");
            }
            query.append(values.get(i));
            if (resultSetMetaData.getColumnTypeName(i + 1).toLowerCase(Locale.ROOT).contains("varchar")
                    || resultSetMetaData.getColumnTypeName(i + 1).toLowerCase(Locale.ROOT).contains("date")) {
                query.append("'");
            }
            if (i != cols.size() - 1) {
                query.append(", ");
            }
        }
        query.append(")");

        //System.out.println(query);
        oracleConnection.executeQuery(query.toString());
    }

    public void oracleDeleteRow(String tableName, Vector<String> cols, Vector<String> values) throws SQLException {
        ResultSetMetaData resultSetMetaData = oracleConnection.executeQuery("SELECT * FROM " + tableName).getMetaData();

        StringBuilder query = new StringBuilder("DELETE FROM " + tableName + " WHERE ");
        for (int i = 0; i != cols.size(); i++) {
            query.append(cols.get(i));
            query.append(" = ");
            if (resultSetMetaData.getColumnTypeName(i + 1).toLowerCase(Locale.ROOT).contains("varchar")
                    || resultSetMetaData.getColumnTypeName(i + 1).toLowerCase(Locale.ROOT).contains("date")) {
                query.append("'");
            }
            query.append(values.get(i));
            if (resultSetMetaData.getColumnTypeName(i + 1).toLowerCase(Locale.ROOT).contains("varchar")
                    || resultSetMetaData.getColumnTypeName(i + 1).toLowerCase(Locale.ROOT).contains("date")) {
                query.append("'");
            }
            if (i != cols.size() - 1) {
                query.append(" AND ");
            }
        }

        //System.out.println(query);
        oracleConnection.executeQuery(query.toString());
    }

    public void oracleOverrideRow(String tableName, Vector<String> cols, Vector<String> oldValues,
                                  Vector<String> newValues) throws SQLException {

        ResultSetMetaData resultSetMetaData = oracleConnection.executeQuery("SELECT * FROM " + tableName).getMetaData();
        StringBuilder query = new StringBuilder("UPDATE " + tableName + " SET ");
        for (int i = 0; i != cols.size(); i++) {
            query.append(cols.get(i));
            query.append(" = ");
            if (resultSetMetaData.getColumnTypeName(i + 1).toLowerCase(Locale.ROOT).contains("varchar")
                    || resultSetMetaData.getColumnTypeName(i + 1).toLowerCase(Locale.ROOT).contains("date")) {
                query.append("'");
            }
            query.append(newValues.get(i));
            if (resultSetMetaData.getColumnTypeName(i + 1).toLowerCase(Locale.ROOT).contains("varchar")
                    || resultSetMetaData.getColumnTypeName(i + 1).toLowerCase(Locale.ROOT).contains("date")) {
                query.append("'");
            }
            if (i != cols.size() - 1) {
                query.append(", ");
            }
        }
        query.append(" WHERE ");

        for (int i = 0; i != cols.size(); i++) {
            query.append(cols.get(i));
            query.append(" = ");
            if (resultSetMetaData.getColumnTypeName(i + 1).toLowerCase(Locale.ROOT).contains("varchar")
                    || resultSetMetaData.getColumnTypeName(i + 1).toLowerCase(Locale.ROOT).contains("date")) {
                query.append("'");
            }
            query.append(oldValues.get(i));
            if (resultSetMetaData.getColumnTypeName(i + 1).toLowerCase(Locale.ROOT).contains("varchar")
                    || resultSetMetaData.getColumnTypeName(i + 1).toLowerCase(Locale.ROOT).contains("date")) {
                query.append("'");
            }
            if (i != cols.size() - 1) {
                query.append(" AND ");
            }
        }

        //System.out.println(query);
        oracleConnection.executeQuery(query.toString());
    }
}
