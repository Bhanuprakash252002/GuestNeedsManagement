package com.bhanu.project;

import java.sql.Connection;
import java.sql.DriverManager;

public class Jdbc {


		static String Driver="com.mysql.cj.jdbc.Driver";
		static String url="jdbc:mysql://localhost:3306/safedrinkingwater";
		static String username="root";
		static String password="bhanu123";
		public static Connection getCon() throws Exception 
		{
			Class.forName(Driver);
			Connection con=DriverManager.getConnection(url, username, password);
			return con;
		}

}
