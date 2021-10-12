package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model.Seller;
import model.SellerRegisterDao;




/**
 * Servlet implementation class SellerRegisterServlet
 */
public class SellerRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public void init(ServletConfig config) throws ServletException{
    	super.init(config);
    }   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String SUsername=request.getParameter("uname");
		String SPassword=request.getParameter("pwd");
		Seller seller = new Seller(SUsername,SPassword);
		SellerRegisterDao sellerRD = new SellerRegisterDao();
		boolean a = sellerRD.register(seller);
		if(a) {
			RequestDispatcher dispatcher=request.getRequestDispatcher("SellerRegister_success.jsp");
			dispatcher.forward(request,response);
		}else {
			RequestDispatcher dispatcher=request.getRequestDispatcher("SellerRegister_fail.jsp");
			dispatcher.forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
