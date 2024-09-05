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
 * Servlet implementation class adminLogin
 */
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
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
		int id=Integer.parseInt(request.getParameter("adminid"));
		String pass=request.getParameter("adminpass");
		PrintWriter pw=response.getWriter();
		try
		{
			if(id==0 &&pass==null)
			{
				response.setContentType("text/html");
				pw.print("<h1 style='text-align:center'>LOGIN NOT SUCCESSFULL<h1>");
				RequestDispatcher rd=request.getRequestDispatcher("adminLogin.html");
				rd.include(request, response);
			}
			Connection con=Jdbc.getCon();
			String query="select adminId,adminPassword from admin";
			PreparedStatement ps=con.prepareCall(query);
			ResultSet rs=ps.executeQuery();
			int success=0;
			while(rs.next())
			{
				if(rs.getInt(1)==id&&rs.getString(2).equals(pass))
				{
					success=1;
					pw.print("<h1 style='text-align:center'>LOGIN SUCCESSFULL<h1>");
				}
			}
			if(success==0)
			{
				response.setContentType("text/html");
				pw.print("<h1 style='text-align:center'>LOGIN NOT SUCCESSFULL<h1>");
				RequestDispatcher rd=request.getRequestDispatcher("adminLogin.html");
				rd.include(request, response);
			}
		}
		catch(Exception e)
		{
			pw.print(e);
		}
	}

}
