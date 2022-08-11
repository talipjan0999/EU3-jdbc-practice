package jdbctest;

import java.sql.*;

public class main {

    public static void main(String[] args) throws SQLException {
        String dburl="jdbc:oracle:thin:@18.212.178.130:1521:xe";
        String dbusername="hr";
        String dbpassword="hr";

        Connection connection= DriverManager.getConnection(dburl,dbusername,dbpassword);
        Statement statement=connection.createStatement();

        ResultSet resultSet=statement.executeQuery("Select * from regions");


        resultSet.close();
        statement.close();
        connection.close();
        
    }
}
