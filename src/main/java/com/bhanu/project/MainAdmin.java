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
 * Servlet implementation class mainAdmin
 */
public class MainAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainAdmin() {
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
		int mainAdminId=Integer.parseInt(request.getParameter("mainid"));
		String mainAdminpass=request.getParameter("mainpass");
		PrintWriter pw=response.getWriter();
		try 
		{
			Connection con=Jdbc.getCon();
			String query="select adminId,adminPassword from mainadmin";
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			int success=0;
			while(rs.next())
			{
				if(rs.getInt(1)==mainAdminId&&rs.getString(2).equals(mainAdminpass))
				{
					success=1;
					response.setContentType("text/html");
					pw.println("<h1 style='text-align:center'>LOGIN SUCCESSFUL</h1>");
					RequestDispatcher rd=request.getRequestDispatcher("mainAminPage.html");
					rd.include(request, response);
				}
			}
			if(success==0)
			{
				response.setContentType("text/html");
				pw.println("<h1 style='text-align:center'>LOGIN NOT SUCCESSFUL</h1>");
				RequestDispatcher rd=request.getRequestDispatcher("mainAdmin.html");
				rd.include(request, response);
			}
			
		}catch(Exception e)
		{
			pw.println(e);
		}
	}

}
