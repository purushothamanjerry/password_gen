package password_genrator;
import java.util.*;
public class main {

public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	System.out.println("1.Login");
	System.out.println("2.Register");
	String auth=scan.nextLine();
	
	if(auth.equalsIgnoreCase("register")) {
		System.out.println("register process");
	}else {
		System.out.println("login process");
	}
}
}

