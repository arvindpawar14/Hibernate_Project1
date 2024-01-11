package com.tech;

public class Employee {
	private int id;
	private String fname;
	private String lname;
	private String email;
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public String getLname() {
		return lname;
	}
	public String getEmail() {
		return email;
	}
	public String getPass() {
		return pass;
	}
	public Employee(int id, String fname, String lname, String email, String pass) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", pass=" + pass
				+ "]";
	}
	private String pass;
	
}
