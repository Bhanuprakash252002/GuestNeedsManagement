package com.bhanu.project;

public class Adminbean {
	int id;
	String name;
	int age;
	String email;
	double phno;
	String address;
	String pass;
	String gender;
	public Adminbean(int id, String name, int age, String email, double phno, String address, String pass,
			String gender) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.phno = phno;
		this.address = address;
		this.pass = pass;
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "adminbean [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + ", phno=" + phno
				+ ", address=" + address + ", pass=" + pass + ", gender=" + gender + "]";
	}

}