import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("sql/populate_db.sql"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        while (true){
            try {
                if (!((line = bufferedReader.readLine()) != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            line = line.trim();
            stringBuilder.append(line);
            stringBuilder.append(";");
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }

        String[] inst = stringBuilder.toString().split(";");
        for (String stringQueri : inst) {
            try {
                Connection connection = Database.getInstance().getConnection();
                Statement statement = connection.createStatement();
                statement.execute(stringQueri + ";");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
