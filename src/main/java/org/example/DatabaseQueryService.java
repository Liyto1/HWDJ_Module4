package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    public static void main(String[] args) {
        List<MaxProjectCountClient> maxProjectCountClients = findMaxProjectsClient();
        for (MaxProjectCountClient client : maxProjectCountClients) {
            System.out.println("Client Name: " + client.getName());
            System.out.println("Project Count: " + client.getProjectCount());
            System.out.println();
        }

        List<LongestProject> longestProjects = findLongestProject();
        for (LongestProject project : longestProjects) {
            System.out.println("Project ID: " + project.getId());
            System.out.println("Start Date: " + project.getStartDate());
            System.out.println("Finish Date: " + project.getFinishDate());
            System.out.println();
        }

        List<MaxSalaryCountWorker> maxSalaryWorkers = findMaxSalaryWorker();
        for (MaxSalaryCountWorker worker : maxSalaryWorkers) {
            System.out.println("Worker ID: " + worker.getId());
            System.out.println("Name: " + worker.getName());
            System.out.println("Salary: " + worker.getSalary());
            System.out.println();
        }

        List<YoungestEldestWorkersCount> youngestEldestWorkers = findYoungestEldestWorkers();
        for (YoungestEldestWorkersCount worker : youngestEldestWorkers) {
            System.out.println("Worker Type: " + worker.getType());
            System.out.println("Name: " + worker.getName());
            System.out.println("Birthday: " + worker.getBirthday());
            System.out.println();
        }
    }

    public static List<MaxProjectCountClient> findMaxProjectsClient() {
        List<MaxProjectCountClient> clients = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();
        String sqlFilePath = "sql/find_max_projects_client.sql";

        try {
            Statement statement = connection.createStatement();
            String sqlQuery = readSqlFile(sqlFilePath);
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                String name = resultSet.getString("Client_Name");
                int projectCount = resultSet.getInt("Project_Count");
                MaxProjectCountClient client = new MaxProjectCountClient(name, projectCount);
                clients.add(client);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        return clients;
    }

    public static List<LongestProject> findLongestProject() {
        List<LongestProject> projects = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();
        String sqlFilePath = "sql/find_longest_project.sql";

        try {
            Statement statement = connection.createStatement();
            String sqlQuery = readSqlFile(sqlFilePath);
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String startDate = resultSet.getString("START_DATE");
                String finishDate = resultSet.getString("FINISH_DATE");
                LongestProject project = new LongestProject(id, startDate, finishDate);
                projects.add(project);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        return projects;
    }

    public static List<MaxSalaryCountWorker> findMaxSalaryWorker() {
        List<MaxSalaryCountWorker> workers = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();
        String sqlFilePath = "sql/find_max_salary_worker.sql";

        try {
            Statement statement = connection.createStatement();
            String sqlQuery = readSqlFile(sqlFilePath);
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");
                int salary = resultSet.getInt("SALARY");
                MaxSalaryCountWorker worker = new MaxSalaryCountWorker(id, name, salary);
                workers.add(worker);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        return workers;
    }

    public static List<YoungestEldestWorkersCount> findYoungestEldestWorkers() {
        List<YoungestEldestWorkersCount> workers = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();
        String sqlFilePath = "sql/find_youngest_eldest_workers.sql";

        try {
            Statement statement = connection.createStatement();
            String sqlQuery = readSqlFile(sqlFilePath);
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                String type = resultSet.getString("TYPE");
                String name = resultSet.getString("NAME");
                String birthday = resultSet.getString("BIRTHDAY");
                YoungestEldestWorkersCount worker = new YoungestEldestWorkersCount(type, name, birthday);
                workers.add(worker);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        return workers;
    }

    private static String readSqlFile(String filePath) throws IOException {
        StringBuilder sqlQuery = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sqlQuery.append(line).append(" ");
            }
        }
        return sqlQuery.toString();
    }
}
