package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Seller;
import model.SellerLoginDao;

/**
 * Servlet implementation class sellerlogin_handle
 */
public class sellerlogin_handle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public void init(ServletConfig config) throws ServletException{
    	super.init(config);
    	
    }   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sellerlogin_handle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		Seller seller = new Seller(uname,pwd);
		SellerLoginDao sellerLD = new SellerLoginDao();
		boolean a = sellerLD.Login(seller);
		if(a) {
			HttpSession session = request.getSession(true);
			session.setAttribute("seller", seller);
			RequestDispatcher dispatcher=request.getRequestDispatcher("Show.jsp");
			dispatcher.forward(request,response);
		}else {
			RequestDispatcher dispatcher=request.getRequestDispatcher("sellerlogin_fail.jsp");
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
