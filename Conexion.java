import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion
{
    public static Connection con = null;
    public static Connection getConexion() throws SQLException, ClassNotFoundException
    {
        String URL = "jdbc:postgresql://localhost:5432/postgres";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "clave123");
        Connection conn = DriverManager.getConnection(URL, props);
        return conn;
    }
}