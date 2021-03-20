package DatabaseTools;

import oracle.jdbc.pool.OracleDataSource;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.List;

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
        List<String> sqlRequests = SqlParser.parseSqlToString("C:\\Users\\ruily_g40rtk5\\IdeaProjects\\SQL_1\\src\\DatabaseTools\\InitAndTest.sql");

        for (String iter: sqlRequests) {
            //System.out.println(iter);
            PreparedStatement stmt = conn.prepareStatement(iter);
            ResultSet rslt = stmt.executeQuery();
        }
    }

    public void dropTables() throws FileNotFoundException, SQLException {
        List<String> sqlRequests = SqlParser.parseSqlToString("C:\\Users\\ruily_g40rtk5\\IdeaProjects\\SQL_1\\src\\DatabaseTools\\DropTables.sql");

        for (String iter: sqlRequests) {
            //System.out.println(iter);
            PreparedStatement stmt = conn.prepareStatement(iter);
            ResultSet rslt = stmt.executeQuery();
        }
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
