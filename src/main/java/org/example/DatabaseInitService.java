package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitService {
    public static void main(String[] args) {

        Connection connection = Database.getInstance().getConnection();


        String sqlFilePath = "sql/init_db.sql";

        try (BufferedReader reader = new BufferedReader(new FileReader(sqlFilePath));
             Statement statement = connection.createStatement()) {
            String line;
            StringBuilder query = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty() || line.trim().startsWith("--")) {
                    continue;
                }

                query.append(line);

                if (line.trim().endsWith(";")) {
                    statement.execute(query.toString());
                    query.setLength(0);
                }
            }

            System.out.println("База даних ініціалізована успішно.");
        } catch (IOException | java.sql.SQLException e) {
            e.printStackTrace();
            System.err.println("Помилка при ініціалізації бази даних.");
        }
    }
}
