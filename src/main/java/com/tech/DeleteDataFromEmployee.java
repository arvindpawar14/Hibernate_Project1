package com.tech;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class DeleteDataFromEmployee extends HttpServlet {
	public DeleteDataFromEmployee() {
		System.out.println("I am in DeleteDataFromEmployee Constructor");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String query = "delete from employee1 where Empid=?";
		String query1 = "select * from employee1";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fusion", "root", "1493");
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, id);
			int records = ps.executeUpdate();
			System.out.println("record deleted---->" + records);
			PreparedStatement ps1 = con.prepareStatement(query1);
			ResultSet rs = ps1.executeQuery();
			ArrayList<Employee> al = new ArrayList<Employee>();
			while (rs.next()) {
				int id1 = rs.getInt("Empid");
				String fname = rs.getString("EmpFirstName");
				String lname = rs.getString("EmpLastName");
				String email = rs.getString("EmpEmail");
				String pass = rs.getString("EmpPassword");

				Employee e1 = new Employee(id1, fname, lname, email, pass);
				al.add(e1);

			}
			RequestDispatcher rd;
			req.setAttribute("GET_ALL", al);
			rd = req.getRequestDispatcher("showTable.jsp");
			rd.forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
