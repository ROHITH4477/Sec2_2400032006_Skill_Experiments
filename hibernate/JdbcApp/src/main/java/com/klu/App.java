package com.klu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
/**
 * Hello world!
 */
public class App 
{
    public static void main( String[] args )throws Exception
    {
      Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sec2","root","ROHITH4477");
    if(con != null)
      System.out.println("Connected successfully");
    else
      System.out.println("Not connected...");

    Statement stmt = con.createStatement();
    String vsql = "insert into student values(1001,'Rohith','rohith@gmail.com')";
    int n = stmt.executeUpdate(vsql);
    System.out.println("value of n:" + n);
    if( n > 0 )
      System.out.println("Record inserted successfully");
    else
      System.out.println("Not inserted");
    con.close();

    }
}
