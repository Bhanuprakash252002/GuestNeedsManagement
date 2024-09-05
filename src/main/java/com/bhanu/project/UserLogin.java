package com.bhanu.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class userLogin
 */
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
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
		String email=request.getParameter("uemail");
		String password=request.getParameter("upass");
		PrintWriter pw=response.getWriter();
		try
		{
			Connection con =Jdbc.getCon();
			String query="select uemail,upassword from user";
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			int success=0;
			while(rs.next())
			{
				if(rs.getString(1).equals(email)&&rs.getString(2).equals(password))
				{
					success=1;
					response.setContentType("text/html");
					pw.print("<h1 style='text-align:center'>LOGIN SUCCESSFULL<h1>");
					
				}
				
			}
			if(success==0)
			{
				response.setContentType("text/html");
				pw.print("<h1 style='text-align:center ,color:red'>LOGIN NOT SUCCESSFULL<h1>");
				RequestDispatcher rd=request.getRequestDispatcher("userLogin.html");
				rd.include(request, response);
				
			}
			
			
			
		}
		catch(Exception e)
		{
			
		}
		
		
	}

}
