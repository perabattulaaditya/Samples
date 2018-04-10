package com.student;

import java.io.IOException;
import java.rmi.ServerException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
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
 
		//PrintWriter pw = response.getWriter();
		 try {
			Class.forName("com.mysql.jdbc.Driver");
		
         Connection con = (Connection) DriverManager.getConnection(
                 "jdbc:mysql://localhost:3306/world", "root", "iteam");

         PreparedStatement ps = (PreparedStatement) con
                 .prepareStatement("select * from USERDETAILS");
         ResultSet resultSet = ps.executeQuery();
         JSONArray array = null;
         if (resultSet.next()) {
        	 String studentName = resultSet.getString("studentName");
        	 String address= resultSet.getString("address");
        	 String phoneNumber = resultSet.getString("phoneNumber");
        	 JSONObject jsonObject = new JSONObject();
        	 jsonObject.put("studentName", studentName);
        	 jsonObject.put("address", address);
        	 jsonObject.put("phoneNumber", Integer.parseInt(phoneNumber));
        	 		
        	 array.add(jsonObject);
         }
         
 	    response.getWriter().write(array.);
        
         	
		 } catch (Exception e) {
				System.out.println(e);
			}
	}
}
