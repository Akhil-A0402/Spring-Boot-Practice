package com.example.SpringBootPractice.jpaPractice.part1.withoutJpa;

import org.springframework.stereotype.Service;

import java.sql.*;

@Service
public class UserDAO {

    /*
    For creating a new table
     */
    public void createUserTable() {
        try {
            Connection conn = new DatabaseConnection().getConnection();
            Statement statementQuery = conn.createStatement();
            String sql = "CREATE TABLE users(user_id INT AUTO_INCREMENT PRIMARY KEY, user_name VARCHAR(100), age INT)";
            statementQuery.execute(sql);
//            statementQuery.close();
//            conn.close();
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // closing the statement query and db connection
        }
    }

    /*
    For adding users.
     */
    public void createUser(String username, int age) {
        try {
            Connection conn = new DatabaseConnection().getConnection();
            String sqlQuery = "INSERT INTO users(user_name, age) VALUES (?, ?)";
            PreparedStatement preparedQuery = conn.prepareStatement(sqlQuery);
            preparedQuery.setString(1, username);
            preparedQuery.setInt(2, age);
            preparedQuery.executeUpdate();
//            preparedQuery.close();
//            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // for closing the statement and connection
        }
    }

    /*
    For reading users.
     */
    public void readUsers () {
        try {
            Connection conn = new DatabaseConnection().getConnection();
            String sqlQuery = "SELECT * FROM users";
            PreparedStatement statement = conn.prepareStatement(sqlQuery);
            ResultSet output = statement.executeQuery();
            while (output.next()) {
                String userDetails = output.getInt("user_id") +
                        output.getString("user_name") +
                        output.getInt("age");
                System.out.println(userDetails);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // handling
        }
    }
}
