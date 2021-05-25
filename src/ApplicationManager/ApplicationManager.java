package ApplicationManager;

import DatabaseTools.OracleConnection;
import GUI.*;
import GUI.MainMenu.DatabaseManagementWindow;
import GUI.MainMenu.ShopManagementWindow;
import GUI.MainMenu.UsersManagementWindow;
import GUI.ShopManagement.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import java.util.stream.Collectors;

import static DatabaseTools.SqlParser.getSqlQueryFromFile;

public class ApplicationManager {
    private OracleConnection oracleConnection;

    private LoginWindow loginWindow;
    private MainWindow mainWindow;
    private DatabaseManagementWindow databaseManagementWindow;
    private TableManageWindow tableManageWindow;
    private ManualModeWindow manualModeWindow;
    private CashboxWindow cashboxWindow;
    private WarehouseWindow warehouseWindow;
    private ApplicationsAndOrdersWindow applicationAndOrdersWindow;
    private ClientsWindow clientsWindow;
    private ProvidersAndManufacturersWindow providersAndManufacturersWindow;
    private ShopManagementWindow shopManagementWindow;
    private UsersManagementWindow usersManagementWindow;
    private RegistrationWindow registrationWindow;

    private ArrayList<JFrame> windowsList = new ArrayList<>();
    private List<String> currentUserRoles = new ArrayList<>();

    private String currentWindowName;

    public ApplicationManager() {
        try {
            oracleConnection = new OracleConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        loginWindow = new LoginWindow(this);
        mainWindow = new MainWindow(this);
        databaseManagementWindow = new DatabaseManagementWindow(this);
        tableManageWindow = new TableManageWindow(this);
        manualModeWindow = new ManualModeWindow(this);
        cashboxWindow = new CashboxWindow(this);
        warehouseWindow = new WarehouseWindow(this);
        applicationAndOrdersWindow = new ApplicationsAndOrdersWindow(this);
        clientsWindow = new ClientsWindow(this);
        providersAndManufacturersWindow = new ProvidersAndManufacturersWindow(this);
        shopManagementWindow = new ShopManagementWindow(this);
        usersManagementWindow = new UsersManagementWindow(this);
        registrationWindow = new RegistrationWindow(this);

        windowsList.add(loginWindow);
        windowsList.add(mainWindow);
        windowsList.add(databaseManagementWindow);
        windowsList.add(tableManageWindow);
        windowsList.add(manualModeWindow);
        windowsList.add(cashboxWindow);
        windowsList.add(warehouseWindow);
        windowsList.add(applicationAndOrdersWindow);
        windowsList.add(clientsWindow);
        windowsList.add(providersAndManufacturersWindow);
        windowsList.add(shopManagementWindow);
        windowsList.add(usersManagementWindow);
        windowsList.add(registrationWindow);

        loginWindow.setVisible(true);
    }

    public void login(String URL, String login, String password) throws SQLException {
        oracleConnection.connectToDatabase(URL, login, password);
        initUserRolesList(login);
        mainWindow.showAndHideButtons();
        showMainWindow();
        tableManageWindow.loadDataToTable();
        usersManagementWindow.loadDataToTable();
        cashboxWindow.updateTable();
        warehouseWindow.updateTable();
        applicationAndOrdersWindow.updateTable();
        clientsWindow.updateTable();
        providersAndManufacturersWindow.updateTable();
    }

    public void registration(String URL, String login, String password) throws SQLException {
        oracleConnection.connectToDatabase(URL, login, password);
        showMainWindow();
        tableManageWindow.loadDataToTable();
        usersManagementWindow.loadDataToTable();
        cashboxWindow.updateTable();
        warehouseWindow.updateTable();
        applicationAndOrdersWindow.updateTable();
        clientsWindow.updateTable();
        providersAndManufacturersWindow.updateTable();
    }

    public void logout() throws SQLException {
        oracleConnection.disconnect();
        showLoginWindow();
    }

    private void showWindowByName(String windowName) {
        for (JFrame iter: windowsList) {
            if (iter.getClass().getSimpleName().equals(windowName)) {
                for (JFrame iter1: windowsList) {
                    if (iter1.getClass().getSimpleName().equals(currentWindowName)) {
                        iter.setLocation(iter1.getX(), iter1.getY());
                    }
                }
                currentWindowName = iter.getClass().getSimpleName();
                iter.setVisible(true);
            } else {
                iter.setVisible(false);
            }
        }
    }

    public void showLoginWindow() {
        showWindowByName("LoginWindow");
    }

    public void showTableManageWindow() {
        showWindowByName("TableManageWindow");
    }

    public void showMainWindow() {
        showWindowByName("MainWindow");
    }

    public void showManualModeWindow() {
        showWindowByName("ManualModeWindow");
    }

    public void showDatabaseManagementWindow() {
        showWindowByName("DatabaseManagementWindow");
    }

    public void showCashboxWindow() {
        showWindowByName("CashboxWindow");
    }

    public void showWarehouseWindow() {
        showWindowByName("WarehouseWindow");
    }

    public void showApplicationsAndOrdersWindow() {
        showWindowByName("ApplicationsAndOrdersWindow");
    }

    public void showClientsWindow() {
        showWindowByName("ClientsWindow");
    }

    public void showProvidersAndManufacturersWindow() {
        showWindowByName("ProvidersAndManufacturersWindow");
    }

    public void showShopManagementWindow() {
        showWindowByName("ShopManagementWindow");
    }

    public void showUsersManagementWindow() {
        showWindowByName("UsersManagementWindow");
    }

    public void showRegistrationWindow() {
        showWindowByName("RegistrationWindow");
    }

    public void initDatabase() {
        String query = getSqlQueryFromFile("/InitDatabase.sql");
        System.out.println(query);
        if (query == null) {
            System.out.println("null");
        }

        try {
            oracleConnection.executeSqlScript(query);
        } catch (FileNotFoundException e) {
            System.err.println("Problem in parsing SQL file " + e.getMessage());
        }

        try {
            oracleConnection.commit();
        } catch (SQLException ignored) { }
    }

    public void fillDatabase() {
        String query = getSqlQueryFromFile("/FillDatabase.sql");
        System.out.println(query);
        if (query == null) {
            System.out.println("null");
        }

        try {
            oracleConnection.executeSqlScript(query);
        } catch (FileNotFoundException e) {
            System.err.println("Problem in parsing SQL file " + e.getMessage());
        }

        try {
            oracleConnection.commit();
        } catch (SQLException ignored) { }
    }

    public void dropTables() {
        String query = getSqlQueryFromFile("/DropDatabase.sql");
        System.out.println(query);
        if (query == null) {
            System.out.println("null");
        }

        try {
            oracleConnection.executeSqlScript(query);
        } catch (FileNotFoundException e) {
            System.err.println("Problem in parsing SQL file " + e.getMessage());
        }

        try {
            oracleConnection.commit();
        } catch (SQLException ignored) { }
    }

    public ResultSet executeQuery(String query) throws SQLException {
        ResultSet resultSet = oracleConnection.executeQuery(query);
        return resultSet;
    }

    public void createUser(String username, String password, String role) throws SQLException {
        oracleConnection.executeQuery("CREATE USER " + username + " IDENTIFIED BY " + password);
        oracleConnection.executeQuery("GRANT " + role + " TO " + username);
    }

    public void dropUser(String username) throws SQLException {
        oracleConnection.executeQuery("DROP USER " + username);
    }

    public DefaultTableModel getTableByName(String tableName) throws SQLException {
        return oracleConnection.getTableModelByQuery("SELECT * FROM  " + tableName);
    }

    public DefaultTableModel getUsersByRole(String roleName) throws SQLException {
        return oracleConnection.getTableModelByQuery("SELECT * FROM dba_role_privs WHERE granted_role=" + "'" + roleName + "'");
    }

    private void initUserRolesList(String username) throws SQLException {
        //ResultSet resultSet = oracleConnection.executeQuery("SELECT GRANTED_ROLE FROM DBA_ROLE_PRIVS WHERE GRANTEE=" + "'" + username.toUpperCase(Locale.ROOT) + "'");
        ResultSet resultSet = oracleConnection.executeQuery("select * from session_roles");
        while (resultSet.next()) {
            //currentUserRoles.add(resultSet.getString("GRANTED_ROLE"));
            currentUserRoles.add(resultSet.getString("ROLE"));
        }

        for (String iter: currentUserRoles) {
            System.out.println(iter);
        }
    }

    public List<String> getUserRolesList() {
        return currentUserRoles;
    }

    public DefaultTableModel getCashboxList() throws SQLException {
        String query = getSqlQueryFromFile("/CashboxList.sql");
        return oracleConnection.getTableModelByQuery(query);
    }

    public DefaultTableModel getWarehouseList() throws SQLException {
        String query = getSqlQueryFromFile("/WarehouseList.sql");
        return oracleConnection.getTableModelByQuery(query);
    }

    public DefaultTableModel getBrokenList() throws SQLException {
        String query = getSqlQueryFromFile("/BrokenList.sql");
        return oracleConnection.getTableModelByQuery(query);
    }

    public DefaultTableModel getSupplyList() throws SQLException {
        String query = getSqlQueryFromFile("/SupplyList.sql");
        return oracleConnection.getTableModelByQuery(query);
    }

    public DefaultTableModel getApplicationList() throws SQLException {
        String query = getSqlQueryFromFile("/ApplicationList.sql");
        return oracleConnection.getTableModelByQuery(query);
    }

    public DefaultTableModel getOrdersList() throws SQLException {
        String query = getSqlQueryFromFile("/OrdersList.sql");
        return oracleConnection.getTableModelByQuery(query);
    }

    public DefaultTableModel getApplicationSum() throws SQLException {
        String query = getSqlQueryFromFile("/ApplicationSum.sql");
        return oracleConnection.getTableModelByQuery(query);
    }

    public DefaultTableModel getClientsList() throws SQLException {
        String query = getSqlQueryFromFile("/ClientsList.sql");
        return oracleConnection.getTableModelByQuery(query);
    }

    public DefaultTableModel getProvidersList() throws SQLException {
        String query = getSqlQueryFromFile("/ProvidersList.sql");
        return oracleConnection.getTableModelByQuery(query);
    }

    public DefaultTableModel getManufacturersList() throws SQLException {
        String query = getSqlQueryFromFile("/ManufacturersList.sql");
        return oracleConnection.getTableModelByQuery(query);
    }

    public DefaultTableModel getSparePartsList() throws SQLException {
        String query = getSqlQueryFromFile("/SparePartsList.sql");
        return oracleConnection.getTableModelByQuery(query);
    }

    public String seeCells(int cellID) throws SQLException {

        InputStream inputStream = getClass().getResourceAsStream("/SeeCell.sql");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String contents = reader.lines().collect(Collectors.joining(System.lineSeparator()));
        contents = contents.replace(":CELL_ID", Integer.toString(cellID));
        ResultSet resultSet = oracleConnection.executeQuery(contents);

        resultSet.next();
        //int cellID  = resultSet.getInt("Номер_ячейки");
        int sparePartID = resultSet.getInt("ID_запчисти");
        String name = resultSet.getString("Запчасть");
        String autoModel = resultSet.getString("Модель");
        int quantity = resultSet.getInt("Количество");

        return "Номер ячейки: " + cellID + "\n" +
                "Номер запчасти: " + sparePartID + "\n" +
                "Запчасть: " + name + "\n" +
                "Модель авто: " + autoModel + "\n" +
                "Количество: " + quantity + "\n";
    }

    public void payOrderCahsbox(int orderID) {
        String query = "UPDATE orders SET status = 'Оплачено' WHERE orders_id = " + orderID;
        try {
            oracleConnection.executeSqlScript(query);
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    public void undoOrderCahsbox(int orderID) {
        String query = "UPDATE orders SET status = 'Отмена' WHERE orders_id = " + orderID;
        try {
            oracleConnection.executeSqlScript(query);
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    public void brokenOrderCahsbox(int orderID) {
        String query = "UPDATE orders SET status = 'Возврщен (брак)' WHERE orders_id = " + orderID;
        try {
            oracleConnection.executeSqlScript(query);
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
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

    public DefaultComboBoxModel getAllRoles() {
        try {
            ResultSet resultSet = oracleConnection.executeQuery("SELECT GRANTED_ROLE FROM USER_ROLE_PRIVS");
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
