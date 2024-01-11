package com.tech;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateEmployee extends HttpServlet {
	public UpdateEmployee() {
		System.out.println("I am in UpdateEmployee Constructor");
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("eid1");
		String fname=req.getParameter("efname1");
		String lname=req.getParameter("elname1");
		String email=req.getParameter("email1");
		String pass=req.getParameter("epass1");
		
		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fusion", "root", "1493");
			String sql = "update employee1 set EmpFirstName=?, EmpLastName=?, EmpEmail=?, EmpPassword=? where Empid=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, email);
			ps.setString(4, pass);
			ps.setString(5, id);
			
			int records=ps.executeUpdate();
			System.out.println(records);
			
			RequestDispatcher rd = req.getRequestDispatcher("/table");
			rd.forward(req, resp);
	}
		catch (Exception e) {
			System.out.println(e);
		}
}
}