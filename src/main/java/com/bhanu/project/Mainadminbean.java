package com.bhanu.project;

public class Mainadminbean {
	int id;
	String name;
	String email;
	double phno;
	String add;
	String pass;
	String gender;
	@Override
	public String toString() {
		return "Mainadminbean [id=" + id + ", name=" + name + ", email=" + email + ", phno=" + phno + ", add=" + add
				+ ", pass=" + pass + ", gender=" + gender + "]";
	}
	public Mainadminbean(int id, String name, String email, double phno, String add, String pass, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phno = phno;
		this.add = add;
		this.pass = pass;
		this.gender = gender;
	}
}
