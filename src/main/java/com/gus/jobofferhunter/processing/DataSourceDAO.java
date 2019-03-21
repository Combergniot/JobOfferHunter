package com.gus.jobofferhunter.processing;

import java.sql.*;

public abstract class DataSourceDAO {


    protected Connection connect = null;
    protected Statement statement = null;
    protected PreparedStatement preparedStatement = null;
    protected ResultSet resultSet = null;

    protected String url = "jdbc:mysql://localhost:3306/joboffers?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    protected String user = "root";
    protected String password = "root";


    public void readDataBase() throws Exception {
        try {
            connect = DriverManager.getConnection(url, user, password);
            statement = connect.createStatement();
            resultSet = statement
                    .executeQuery("select * from pracuj_pl");
        } catch (Exception e) {
            throw e;
        }
    }

    public void writeResultSet() throws SQLException {
        int querryNumber = 1;
        while (resultSet.next()) {
            String stanowisko = resultSet.getString("position");
            System.out.println("Stanowisko " + querryNumber + ": " + stanowisko);
            querryNumber++;
        }
    }


    public void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }
}



