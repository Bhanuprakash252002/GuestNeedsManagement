package com.bhanu.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Admindatabase {
	public static ArrayList<Adminbean> getlist() {
		ArrayList<Adminbean> ab = new ArrayList<>();
		try {
			Connection con = Jdbc.getCon();
			String query = "select * from admin";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Adminbean bean = new Adminbean(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),
						rs.getDouble(5), rs.getString(6), rs.getString(7), rs.getString(8));
				ab.add(bean);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return ab;
	}

}
