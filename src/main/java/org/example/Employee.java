package org.example;
import java.net.CookieHandler;
import java.sql.*;
import java.util.Scanner;


public class Employee {
    public static void main(String[] args) {

        /*
            import package
            load jdbc class
            create connection
            create statement
            execute statement
            process the result
            close
        */

        String url = "jdbc:postgresql://localhost:5432/employeeDetails";
        String userName = "postgres";
        String pass = "aBC@1234";

//        Insert data using the variables
        int empId = 9;
        String empName = "Max";
        String empCity = "Earth";
        String empState = "Space";
        String empPhoneNo = "7856821595";
        int empSalary = 13000;


        String sql = "select * from employee";
//        String insert = "insert into employee values(5,'John', 'Bengaluru', 'Karnataka', '8795487645', 45000)";
        String insert = "insert into employee values(?,?,?,?,?,?)";
//        String update = "update employee set empPhoneNo=8264462946 where empid=1";
        String delete = "delete from employee where empid=9";


        try {
            Connection con = DriverManager.getConnection(url,userName,pass);
            Statement st = con.createStatement();
            System.out.println("Connection Establish");

//            Insert the data using the variables
            PreparedStatement pt = con.prepareStatement(insert);
            pt.setInt(1,empId);
            pt.setString(2,empName);
            pt.setString(3,empCity);
            pt.setString(4,empState);
            pt.setString(5,empPhoneNo);
            pt.setInt(6,empSalary);
//            pt.execute();

//            Update the data
//            PreparedStatement pt1 = con.prepareStatement(update);
//            pt1.execute();

//            Delete the data
            PreparedStatement pt2 = con.prepareStatement(delete);
            pt2.execute();

//            Fetch value from the Database
            ResultSet rs = st.executeQuery(sql);
//            Below is gives only first row
//            rs.next();
//            String str = rs.getString("empName");
//            System.out.println(str);
            System.out.println("All data is below -------");
            while (rs.next()){
                System.out.print(rs.getInt(1) + " - ");
                System.out.print(rs.getString(2) + " - ");
                System.out.print(rs.getString(3) + " - ");
                System.out.print(rs.getString(4) + " - ");
                System.out.print(rs.getString(5) + " - ");
                System.out.print(rs.getString(6));
                System.out.println();
            }
            con.close();
            System.out.println("Connection close");

        } catch (Exception e){
            System.out.println(e);
        }
    }
}
