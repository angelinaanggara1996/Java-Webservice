package org.Test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbTest {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {

        Connection conn=null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=erppd", "sa", "123");

            if(conn!=null) {
                System.out.println("Database Successfully connected");
                Statement statement = conn.createStatement();
                //String queryString = "select ID from dbo.PERSON AS A";
                ResultSet rs = statement.executeQuery("select * from dbo.PERSON");
                while (rs.next()) {
                   System.out.println(rs.getString(2));
                }

            }
            else
            	System.out.println("Database not connected");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
