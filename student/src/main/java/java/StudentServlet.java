/**
 * 
 */
package java;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * @author paditya
 *
 */
public class StudentServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException ,IOException {
		response.getWriter().print("Hiii");
		
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
 
        String n = request.getParameter("studentId");
        String p = request.getParameter("studentName");
        String e = request.getParameter("phoneNumber");
        String c = request.getParameter("address");
 
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/servlet", "root", "mukesh");
 
            PreparedStatement ps = (PreparedStatement) con
                    .prepareStatement("insert into USERDETAILS values(?,?,?,?)");
 
            ps.setString(1, n);
            ps.setString(2, p);
            ps.setString(3, e);
            ps.setString(4, c);
 
            int i = ps.executeUpdate();
            if (i > 0)
                out.print("You are successfully registered...");
 
        } catch (Exception e2) {
            System.out.println(e2);
        }
 
        out.close();
	}
	
	@Override
	public void init() throws  ServletException {
		System.out.println("servlet"+ this.getServletName()+"Started");
	}
	
	@Override
	public void destroy() {
		System.out.println("Servler"+ this.getServletName()+"stopped");
	}
	
}
