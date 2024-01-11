package com.tech;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditEmployee extends HttpServlet {
	public EditEmployee() {
		System.out.println("I am in EditEmployee Constructor");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fusion", "root", "1493");
			String sql = "Select * from employee1 where Empid=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id1 = rs.getInt("Empid");
				String fname = rs.getString("EmpFirstName");
				String lname = rs.getString("EmpLastName");
				String email = rs.getString("EmpEmail");
				String pass = rs.getString("EmpPassword");

				Employee e1 = new Employee(id1, fname, lname, email, pass);
				System.out.println(e1);

				req.setAttribute("EMPLOYEE_EXISTING_DATA", e1);
			}

			RequestDispatcher rd = req.getRequestDispatcher("edit-employee.jsp");
			rd.forward(req, resp);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
