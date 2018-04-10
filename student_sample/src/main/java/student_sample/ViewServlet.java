package student_sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import net.sf.json.JSONObject;

public class ViewServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ViewServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServerException,IOException {
		
		response.setContentType("text/json");  // Set content type of the response so that jQuery knows what it can expect.
	    response.setCharacterEncoding("UTF-8"); 
	    response.getWriter().write(text); 
		//PrintWriter pw = response.getWriter();
		 try {
			Class.forName("com.mysql.jdbc.Driver");
		
         Connection con = (Connection) DriverManager.getConnection(
                 "jdbc:mysql://localhost:3306/world", "root", "iteam");

         PreparedStatement ps = (PreparedStatement) con
                 .prepareStatement("select * from USERDETAILS");
         ResultSet resultSet = ps.getResultSet();
         if (resultSet.next()) {
        	 JSONObject jsonObject = resultSet.getDate(columnIndex)
        	 response.getWriter() 
         }
        
         	RequestDispatcher rd2=request.getRequestDispatcher("/mainPage.html");
             rd2.include(request,response);
		 } catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
