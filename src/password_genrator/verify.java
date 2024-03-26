package password_genrator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class verify {
    public static void main(String[] args) {
    	
    	
  
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Your Username ");
            String username = scanner.nextLine();
            
            System.out.println("Enter Your Password ");
            String password = scanner.nextLine();
            
            System.out.println("Enter Confirm Password ");
            String confirmPassword = scanner.nextLine();
            System.out.println("Enter mobile number ");
            String number = scanner.nextLine();
            
            
            if (password.equals(confirmPassword)) {
                // Passwords match, proceed with database insertion
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pass_gen?characterEncoding=latin1", "root", "My@123sql321");
                Statement stmt = con.createStatement();
                String insertQuery = "INSERT INTO authentication (username, password,number) VALUES ('" + username + "', '" + password + "','" + number+"')";
                int rowsAffected = stmt.executeUpdate(insertQuery);
                System.out.println(rowsAffected + " row(s) affected.");
                
                // Closing the connection
                con.close();
                System.out.println("You are Successfully Registered.");
            } else {
                System.out.println("Passwords do not match.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.toString());
        }
    }
}
