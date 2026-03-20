import java.sql.*;

class Hai {
    public static void main(String args[]) throws Exception {
             Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sec2",
                "root",
                "ROHITH4477"
        );
        if (con != null)
            System.out.println("Connected Successfully");
        else
            System.out.println("Not Connected...");
    }
}
