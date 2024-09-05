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
 * Servlet implementation class adminRegistration
 */
public class AdminRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRegistration() {
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
		int id=Integer.parseInt(request.getParameter("adminid"));
		String username=request.getParameter("adminname");
		int age=Integer.parseInt(request.getParameter("adminage"));
		String email=request.getParameter("adminemail");
		double phoneNumber=Double.parseDouble(request.getParameter("adminPhoneNumber"));
		String address=request.getParameter("adminaddress");
		String password=request.getParameter("adminpassword");
		String gender=request.getParameter("gender");
		PrintWriter pw=response.getWriter();
		try
		{
			Connection con=Jdbc.getCon();
			String query="insert into mainadmin value(?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1,id);
			ps.setString(2, username);
			ps.setInt(3, age);
			ps.setString(4, email);
			ps.setDouble(5, phoneNumber);
			ps.setString(6, address);
			ps.setString(7,password);
			ps.setString(8, gender);
			int i=ps.executeUpdate();
			if(i>0)
			{
				response.setContentType("text/html");
				pw.println("<a href='index.html'><input type='button' value='home'/></a>");
				pw.println("<h1 style='text-align:center'>REGISTERED SUCESSFULL</h1>");
				RequestDispatcher rd=request.getRequestDispatcher("mainAminPage.html");
				rd.include(request, response);
			}
			else
			{
				response.setContentType("text/html");
				pw.println("<a href='index.html'><input type='button' value='home'/></a>");
				pw.println("<h1 style='text-align:center'>REGISTERED NOT SUCESSFULL</h1>");
				RequestDispatcher rd=request.getRequestDispatcher("mainAdmin.html");
				rd.include(request, response);
			}
			
			
			
			
		}
		catch(Exception e)
		{
			pw.print(e);
		}
	}

}
