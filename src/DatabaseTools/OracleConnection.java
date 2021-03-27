package DatabaseTools;

import oracle.jdbc.pool.OracleDataSource;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class OracleConnection {
    private String connectionURL;
    private String username;
    private String password;

    private OracleDataSource ods;
    private Connection conn;

    public OracleConnection() throws SQLException {
        ods = new OracleDataSource();
    }

    public String showCountOfStrings() throws SQLException {
        String result = "";
        PreparedStatement stmt = conn.prepareStatement("select count(*) from dba_users");
        ResultSet rslt = stmt.executeQuery();

        while (rslt.next()) {
            result = rslt.getString(1);
        }

        return result;
    }

    public void connectToDatabase(String URL, String username, String password) throws SQLException {
        ods.setURL(URL);
        ods.setUser(username);
        ods.setPassword(password);
        conn = ods.getConnection();
    }

    public void initDatabaseAndTestData() throws SQLException, FileNotFoundException {
        List<String> sqlRequests = SqlParser.parseSqlToString("C:\\Users\\ruily_g40rtk5\\IdeaProjects\\SQL_1\\src\\DatabaseTools\\InitDatabase.sql");

        for (String iter: sqlRequests) {
            //System.out.println(iter);
            PreparedStatement stmt = conn.prepareStatement(iter);
            ResultSet rslt = stmt.executeQuery();
        }
    }

    public void dropTables() throws FileNotFoundException, SQLException {
        List<String> sqlRequests = SqlParser.parseSqlToString("C:\\Users\\ruily_g40rtk5\\IdeaProjects\\SQL_1\\src\\DatabaseTools\\DropDatabase.sql");

        for (String iter: sqlRequests) {
            //System.out.println(iter);
            PreparedStatement stmt = conn.prepareStatement(iter);
            ResultSet rslt = stmt.executeQuery();
        }
    }

    public ResultSet getQueryFromDatabase(String query) throws SQLException {
        Statement statement = conn.createStatement();
        return statement.executeQuery(query);
    }

    public DefaultTableModel getTableByName() throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery("select * from EMPLOYEES");

        return buildTableModel(resultSet);
    }

    public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();

        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();

            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }

            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);
    }

    public void setConnectionURL(String connectionURL) {
        this.connectionURL = connectionURL;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConnectionURL() {
        return connectionURL;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
