package DatabaseTools;

import oracle.jdbc.pool.OracleDataSource;

import javax.swing.table.DefaultTableModel;
import java.io.FileNotFoundException;
import java.sql.*;
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

    public ResultSet executeQuery(String query) throws SQLException {
        Statement statement = conn.createStatement();
        return statement.executeQuery(query);
    }

    public DefaultTableModel getTableModelByQuery(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery(query);

        return buildTableModel(resultSet);
    }

    public void commit() throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeQuery("commit");
    }

    public void rollback() throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeQuery("rollback");
    }

    private static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {

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
