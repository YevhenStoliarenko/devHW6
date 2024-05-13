import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class ClientDAO {
//    public static final String SELECT_FROM_CLIENTS = """
//            SELECT * from client;""";



//    String init = readSql();
    public String CREATE_DATABASE = """
            CREATE TABLE megasoft.worker (
                                    ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                                    NAME VARCHAR(1000) NOT NULL,
                                    BIRTHDAY DATE NOT NULL,
                                    LEVEL ENUM('Trainee','Junior','Middle','Senior')NOT NULL,
                                    SALARY INT NOT NULL,
                        
                        
                                    CONSTRAINT name_check CHECK(LENGTH(NAME) >= 2),
                                    CONSTRAINT birthday_check CHECK(BIRTHDAY >= '1900-01-01'),
                                    CONSTRAINT salary_check CHECK(SALARY > 100 and SALARY < 100000)
            );""";
    public ClientDAO() throws IOException {
    }


//    public void getAllClients() throws IOException {
//        Connection connection;
//        try {
//            connection = Database.getInstance().getConnection();
//            Statement statement = connection.createStatement();
//            statement.execute(readSql());
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public static void initDb() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("sql/init_db.sql"));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        while ((line = bufferedReader.readLine())!= null){
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

    public static void setPopulate() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("sql/populate_db.sql"));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        while ((line = bufferedReader.readLine())!= null){
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




//    public void reader () throws IOException {
//        Path pathRead = Path.of("sql/neu.java");
//        BufferedReader bufferedReader = Files.newBufferedReader(pathRead);
//        String result = null;
//        StringBuilder stringBuilder = new StringBuilder();
//
//        while ((result = bufferedReader.readLine()) != null){
//            stringBuilder.append(result);
//        }
//        String end = stringBuilder.toString();
//        char[] chars = end.toCharArray();
//        System.out.println(end);
//        System.out.println(Arrays.toString(chars));
//        for (char ch : chars){
//            if(ch == '\t'){
//                System.out.println("Halii");
//            }
//        }
//    }






//    File file = new File("sql/Test.sql");
//    Scanner scanner = new Scanner(file);
//    String result = "";
//
//        while (scanner.hasNextLine()) {
//
//        //
//    }
//        return result;
//
//
}
