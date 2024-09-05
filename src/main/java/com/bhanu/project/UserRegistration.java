package com.bhanu.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class userRegistration
 */
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname=request.getParameter("uname");
		int age=Integer.parseInt(request.getParameter("uage"));
		String email=request.getParameter("uemail");
		double phone_number=Double.parseDouble(request.getParameter("unumber"));
		String gender=request.getParameter("gender");
		String password=request.getParameter("upassword");
		PrintWriter pw=response.getWriter();
		try
		{
			Connection con=Jdbc.getCon();
			String query="insert into user values(?,?,?,?,?,?)";
			PreparedStatement ps= con.prepareStatement(query);
			ps.setString(1,uname);
			ps.setInt(2,age);
			ps.setString(3,email);
			ps.setDouble(4,phone_number);
			ps.setString(5,gender);
			ps.setString(6,password);
			int i=ps.executeUpdate();
			if(i>0)
			{
				response.setContentType("text/html");
				pw.println("<h1 style='text-align:center;'>REGISTERED SUCESSFULLY<h1>");
				RequestDispatcher rs=request.getRequestDispatcher("userLogin.html");
				rs.include(request, response);
			}
			else
			{
				response.setContentType("text/html");
				pw.println("<h1 style='text-align:center, color:red;'>REGISTERED NOT   SUCESSFULLY<h1>");
				RequestDispatcher rs=request.getRequestDispatcher("userRegistration.html");
				rs.include(request, response);
			}
			
			
			
		}
		catch(Exception e)
		{
			pw.println(e);
		}
		
		
		
		
		
	}

}
