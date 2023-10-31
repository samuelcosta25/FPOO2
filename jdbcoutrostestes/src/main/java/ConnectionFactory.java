import java.sql.*;

//Connection Factory

public class ConnectionFactory {
    private static final String url = "jdbc:postgresql://localhost:5432/postgresql";
    private static final String user = "postgres";
    private static final String pass = "postgres";

    public static connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            ex.printStackTrace();
        }
    }

    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
             } 
             catch (SQLException ex) {
            ex.printStackTrace();
        }
    

    }

}
}
