import java.sql.DriverManager;

import javax.servlet.http.HttpServletRequest;
//import model.*;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * @author paditya
 *
 */
public class StudentDataBaseConnectin {
	
	public StudentDataBaseConnectin() {
		
	}
	HttpServletRequest httpServletRequest;
	public StudentDataBaseConnectin(HttpServletRequest request) {
		this.httpServletRequest = request;
	}
	
	public studentDBCOnnection() {
		 Class.forName("com.mysql.jdbc.Driver");
         Connection con = (Connection) DriverManager.getConnection(
                 "jdbc:mysql://localhost:3306/servlet", "root", "mukesh");

         PreparedStatement ps = con
                 .prepareStatement("insert into USERDETAILS values(?,?,?,?)");

         ps.setString(1, n);
         ps.setString(2, p);
         ps.setString(3, e);
         ps.setString(4, c);

         int i = ps.executeUpdate();
         if (i > 0)
             out.print("You are successfully registered...");
	}
}
