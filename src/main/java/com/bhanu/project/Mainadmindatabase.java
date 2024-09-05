package com.bhanu.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Mainadmindatabase {
	public static ArrayList<Mainadminbean> getlist() {
		ArrayList<Mainadminbean> mb = new ArrayList<>();
		try {
			Connection con = Jdbc.getCon();
			String query = "select * from mainadmin";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Mainadminbean bean = new Mainadminbean(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4),
						rs.getString(5), rs.getString(6), rs.getString(7));
				mb.add(bean);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return mb;
	}
}
