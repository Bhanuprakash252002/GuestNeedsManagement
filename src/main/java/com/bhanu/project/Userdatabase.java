package com.bhanu.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Userdatabase {
	public static ArrayList<Userbean> getlist() {
		ArrayList<Userbean> ub = new ArrayList<>();
		try {
			Connection con = Jdbc.getCon();
			String query="select * from user";
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Userbean bean=new Userbean(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getDouble(4),rs.getString(5),rs.getString(6));
				ub.add(bean);
			}
			

		} catch (Exception e) {
			System.out.println(e);
		}
		return ub;
	}
	

}
