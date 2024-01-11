package com.tech;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginEmployee extends HttpServlet {
	public LoginEmployee() {
		System.out.println("I am in Login Constructor");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("uname");
		String password = req.getParameter("pass");

		String url = "jdbc:mysql://localhost:3306/fusion";
		String password1 = "1493";
		String username1 = "root";
		String query = "select * from user_demo where username=? and pssword=?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username1, password1);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs != null && rs.next()) {
				System.out.println("Successfully Login");
				RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
				rd.forward(req, resp);
			} else {
				System.out.println("Failed to Login");
				RequestDispatcher rd = req.getRequestDispatcher("failed.jsp");
				rd.forward(req, resp);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			RequestDispatcher rd = req.getRequestDispatcher("failed.jsp");
			rd.forward(req, resp);
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
