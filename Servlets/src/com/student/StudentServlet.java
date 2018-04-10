package com.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public StudentServlet() {
		super();
	}

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
                    "jdbc:mysql://localhost:3306/world", "root", "iteam");
 
            PreparedStatement ps = (PreparedStatement) con
                    .prepareStatement("insert into USERDETAILS values(?,?,?,?)");
 
            ps.setInt(1, Integer.parseInt(n));
            ps.setString(2, p);
            ps.setInt(3, Integer.parseInt(e));
            ps.setString(4, c);
 
            int i = ps.executeUpdate();
            if (i > 0)
                out.print("You are successfully registered...");
            	out.println("Bye ");
            	RequestDispatcher rd2=request.getRequestDispatcher("/mainPage.html");
                rd2.include(request,response);
             
        } catch (Exception e2) {
            System.out.println(e2);
        }
 
        out.close();
	}
	
	public void init() throws  ServletException {
		System.out.println("servlet"+ this.getServletName()+"Started");
	}
	
	public void destroy() {
		System.out.println("Servler"+ this.getServletName()+"stopped");
	}
}
