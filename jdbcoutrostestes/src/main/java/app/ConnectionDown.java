import java.sql.*;

import org.postgresql.core.ConnectionFactory;

public class ConnectionDown {
    public void cleanup() {
        Connection con = ConnectionFactory.getConnection();
        Statement stmt = null;
        {
            try {
                stmt.executeUpdate("drop table tbl_basica");
            } catch (Exception ex) {
                // Ignorar todos os erros
            }
        }
    }
}
