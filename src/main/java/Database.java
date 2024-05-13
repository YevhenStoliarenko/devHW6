import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String BD_URL = "jdbc:mysql://localhost:3306";
    private static final String BD_USER = "root";
    private static final String BD_PASSWORD = "password";

    private Database() {
    }

    private static Database database;

    public static Database getInstance() {
        if(database == null){
            database = new Database();
        }
        return database;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(BD_URL, BD_USER, BD_PASSWORD);
    }
}
