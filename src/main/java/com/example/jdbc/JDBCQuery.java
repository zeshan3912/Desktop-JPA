package com.example.jdbc;

import java.sql.*;

public class JDBCQuery {

    private String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    private String DATABASE_URL = "jdbc:mysql://localhost:3306/test2?useSSL=false";

    private String USER = "root";

    private String PASSWORD = "root";


    public void readData() {

        Connection connection = null;

        Statement statement = null;


        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

            statement = connection.createStatement();

            String sqlQuery = "select * from test_user;";

            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {

                int id = resultSet.getInt("id");

                String email = resultSet.getString("email");

                String gender = resultSet.getString("gender");

                User user = new User(id, email, gender);


                System.out.println(user);

            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }


}
