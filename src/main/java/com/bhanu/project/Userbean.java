package com.bhanu.project;

public class Userbean {
	String uname;
	int age;
	String email;
	double phno;
	String gender;
	String pass;
	public Userbean(String uname, int age, String email, double phno, String gender, String pass) {
		super();
		this.uname = uname;
		this.age = age;
		this.email = email;
		this.phno = phno;
		this.gender = gender;
		this.pass = pass;
	}
	public String toString() {
		return "userbean [uname=" + uname + ", age=" + age + ", email=" + email + ", phno=" + phno + ", gender="
				+ gender + ", pass=" + pass + "]";
	}
	
}
