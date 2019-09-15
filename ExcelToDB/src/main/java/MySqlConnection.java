import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;



public class MySqlConnection
{
    public static ResultSet getConnection() throws SQLException, ClassNotFoundException {
        final Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop?useUnicode=yes&characterEncoding=UTF-8", "root", "admin");
        final Statement stmt = con.createStatement();
        final ResultSet rs = stmt.executeQuery("SELECT * FROM ebookshop.books");
        return rs;
    }
    
    public static void main(final String[] args) throws SQLException, ClassNotFoundException {
        getConnection();
    }
}
