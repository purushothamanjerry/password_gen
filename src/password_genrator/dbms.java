package password_genrator;
import java.sql.*;
import java.util.Scanner;

public class dbms {

	    public static void main(String[] args) {
	        try {
	        	Scanner scanner = new Scanner(System.in);
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pass_gen?characterEncoding=latin1", "root", "My@123sql321");
	            Statement stmt = con.createStatement();
	            ResultSet rs = stmt.executeQuery("select * from authentication");
	            boolean userFound = false;
	            
	            System.out.println("Enter Your Username ");
	            String name = scanner.nextLine();
	            System.out.println("Enter Your Password ");
	            String pass = scanner.nextLine();
	              while (rs.next()) {
	                String username = rs.getString("username");
	                String password = rs.getString("password");
	                if (username.equals(name) && password.equals(pass)) {
	                    userFound = true;
	                    break;
	                }
	            }
	            if (userFound) {
	                System.out.println("User 'Jerry' with password '8901' exists.");
	            } else {
	                System.out.println("User 'Jerry' with password '8901' does not exist.");
	            }
	            con.close();
	        } catch (Exception e) {
	            System.out.println(e.toString());
	        }
	    }
	}
