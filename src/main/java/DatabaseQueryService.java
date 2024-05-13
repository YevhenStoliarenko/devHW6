import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatabaseQueryService {


    public static List<MaxSalaryWorker> findMaxSalaryWorker() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("sql/find_max_salary_worker.sql"));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        List<MaxSalaryWorker> maxSalaryWorkers = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line + " ");
        }

        String stringQuery = stringBuilder.toString();
        try {
            Connection connection = Database.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(stringQuery);
            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                long salary = resultSet.getObject("SALARY", Long.class);
                maxSalaryWorkers.add(new MaxSalaryWorker(name, salary));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        bufferedReader.close();
        return maxSalaryWorkers;
    }

    public static List<LongestProject> findLongestProject() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("sql/find_longest_project.sql"));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        List<LongestProject> longestProjects = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line + " ");
        }

        String stringQueri = stringBuilder.toString();
        try {
            Connection connection = Database.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(stringQueri);
            while (resultSet.next()) {
                int months = resultSet.getObject("months", Integer.class);
                int projectId = resultSet.getObject("ID", Integer.class);
                longestProjects.add(new LongestProject(projectId, months));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        bufferedReader.close();
        return longestProjects;
    }

    public static List<MaxProjectCountClient> findMaxProjectsClient() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("sql/find_max_projects_client.sql"));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        List<MaxProjectCountClient> maxProjectCountClientList = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line + " ");
        }

        String stringQueri = stringBuilder.toString();
        try {
            Connection connection = Database.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(stringQueri);
            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                long countproject = resultSet.getObject("countproject", Long.class);
                maxProjectCountClientList.add(new MaxProjectCountClient(name, countproject));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        bufferedReader.close();
        return maxProjectCountClientList;
    }


    public static List<YoungestEldestWorkers> findYoungestEldestWorkers() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("sql/find_youngest_eldest_workers.sql"));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        List<YoungestEldestWorkers> youngestEldestWorkers = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line + " ");
        }

        String stringQueri = stringBuilder.toString();
        try {
            Connection connection = Database.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(stringQueri);
            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                String birthday = resultSet.getString("BIRTHDAY");
                String type = resultSet.getString("TYPE");
                youngestEldestWorkers.add(new YoungestEldestWorkers(name, birthday, type));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        bufferedReader.close();
        return youngestEldestWorkers;
    }


    public static List<ProjectPrices> printProjectPrices() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("sql/print_project_prices.sql"));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        List<ProjectPrices> projectPrices = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line + " ");
        }

        String stringQueri = stringBuilder.toString();
        try {
            Connection connection = Database.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(stringQueri);
            while (resultSet.next()) {
                int projectid = resultSet.getObject("PROJECT_ID", Integer.class);
                int prices = resultSet.getObject("prices", Integer.class);
                projectPrices.add(new ProjectPrices(projectid, prices));
//                System.out.println("Project ID: " + resultSet.getString("PROJECT_ID"));
//                System.out.println("Prices: " + resultSet.getString("prices"));
//                System.out.println("----------------");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        bufferedReader.close();
        return projectPrices;
    }




}
