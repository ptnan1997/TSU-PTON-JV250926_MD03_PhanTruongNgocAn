package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String url = "jdbc:mysql://localhost:3306/db_degree__management";
    private static final String user = "root";
    private static final String password = "123456";
    private static final String driver =  "com.mysql.cj.jdbc.Driver";

    public static Connection openConnection(){
        Connection  con;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,password);
            if (con == null){
                System.out.println("Connection fails");
            }
        } catch (ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }
        return con;
    }
    public static void closeConnection(Connection con){
        if (con != null){
            try {
                con.close();
            } catch (SQLException e){
                System.out.println("Connection close fails");
            }
        }
    }
}
