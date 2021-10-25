package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.userdao;
import model.Purchaser;


public class userinfo extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id"); 
		Purchaser u=new Purchaser();
		String name=request.getParameter("buyername");
		String phone=request.getParameter("buyerphone");
		u.setName(name);
		u.setPhone(phone);
		u.setId(id);
		userdao.login(u);
		if(name!=null&&phone!=null)
		{
			response.sendRedirect("success.jsp");
		}
		else {
			response.sendRedirect("fail.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
