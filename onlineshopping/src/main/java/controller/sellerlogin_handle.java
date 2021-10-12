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

/**
 * Servlet implementation class sellerlogin_handle
 */
public class sellerlogin_handle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public void init(ServletConfig config) throws ServletException{
    	super.init(config);
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    	}catch(Exception e) {}
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
		String url = "jdbc:mysql://127.0.0.1:3306/onlineshopping?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8";
		String username="root";
		String password="001124";
		try {
			Connection con = DriverManager.getConnection(url,username,password);
			String querySQL = "select * from seller where SUsername=? and SPassword=?";
			PreparedStatement pre = con.prepareStatement(querySQL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			pre.setString(1, uname);
			pre.setString(2, pwd);
			ResultSet rs = pre.executeQuery();
			rs.last();
			int n = rs.getRow();
			if(n<=0 || uname.length()==0 || pwd.length()==0) {
				RequestDispatcher dispatcher=request.getRequestDispatcher("sellerlogin_fail.jsp");
    			dispatcher.forward(request,response);
				con.close();
			}else {
				HttpSession session = request.getSession(true);
				Seller seller = new Seller(uname,pwd);
				session.setAttribute("seller", seller);
				RequestDispatcher dispatcher=request.getRequestDispatcher("Show.jsp");
    			dispatcher.forward(request,response);
				con.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
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
