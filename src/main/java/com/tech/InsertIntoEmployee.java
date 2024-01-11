package com.tech;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertIntoEmployee extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("eid");
		String fname = req.getParameter("efname");
		String lname = req.getParameter("elname");
		String email = req.getParameter("email");
		String pass = req.getParameter("pass1");

		String url = "jdbc:mysql://localhost:3306/fusion";
		String password = "1493";
		String username = "root";
		String query = "insert into employee1 values(?,?,?,?,?)";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, fname);
			ps.setString(3, lname);
			ps.setString(4, email);
			ps.setString(5, pass);

			int result = ps.executeUpdate();
			if (result > 0) {
				System.out.println("Successfully Inserted Data");
				RequestDispatcher rd = req.getRequestDispatcher("pass.jsp");
				rd.forward(req, resp);
			} else {
				System.out.println("Successfully Inserted Data");
				RequestDispatcher rd = req.getRequestDispatcher("fail.jsp");
				rd.forward(req, resp);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("inside catch block" + e);
			RequestDispatcher rd = req.getRequestDispatcher("fail.jsp");
			rd.forward(req, resp);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			System.out.println("inside catch block" + e);
			RequestDispatcher rd = req.getRequestDispatcher("fail.jsp");
			rd.forward(req, resp);
		}

	}
}
