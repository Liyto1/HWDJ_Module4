package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args) {
        Database database = Database.getInstance();
        Connection connection = database.getConnection();

        String sqlFilePath = "sql/populate_db.sql";

        try {
            FileReader fileReader = new FileReader(sqlFilePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder sqlQuery = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                sqlQuery.append(line).append(" ");
                    if (line.trim().endsWith(";")) {
                    try (Statement statement = connection.createStatement()) {
                        statement.execute(sqlQuery.toString());
                    }
                    // Очищаємо буфер для наступного запиту
                    sqlQuery.setLength(0);
                }
            }

            bufferedReader.close();
            fileReader.close();
            connection.close();

            System.out.println("Базу даних успішно заповнено.");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
