package com.tech;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewTable extends HttpServlet {
	public ViewTable() {
		System.out.println("I am in View Table Constructor Method");
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "jdbc:mysql://localhost:3306/fusion";
		String password = "1493";
		String username = "root";
		String query = "select * from employee1 ";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, username, password);
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			ArrayList<Employee> al=new ArrayList<Employee>();
			while(rs.next()) {
				int Id=rs.getInt("Empid");
				String fname=rs.getString("EmpFirstName");
				String lname=rs.getString("EmpLastName");
				String email=rs.getString("EmpEmail");
				String pass=rs.getString("EmpPassword");
				
				Employee s=new Employee(Id, fname, lname, email, pass);
				al.add(s);
			}
			req.setAttribute("GET_ALL", al);
			RequestDispatcher rd=req.getRequestDispatcher("showTable.jsp");
			rd.forward(req, resp);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
