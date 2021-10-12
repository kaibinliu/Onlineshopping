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
        try {  Class.forName("com.mysql.cj.jdbc.Driver");
	      }
	      catch(Exception e){} 
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://127.0.0.1:3306/onlineshopping?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8";
		String username="root";
		String password="001124";
		try {
				Connection con = DriverManager.getConnection(url,username,password);
				String insertSQL = "insert into seller values(?,?)";
				String querySQL = "select * from seller where SUsername=?";
				PreparedStatement pre = con.prepareStatement(querySQL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
				request.setCharacterEncoding("utf-8");
				String SUsername=request.getParameter("uname");
				String SPassword=request.getParameter("pwd");
				pre.setString(1, SUsername);
				ResultSet rs = pre.executeQuery();
				rs.last();
				int n = rs.getRow();
				if(n>0) {
					RequestDispatcher dispatcher=request.getRequestDispatcher("SellerRegister_fail.jsp");
        			dispatcher.forward(request,response);
					con.close();
				}else {
					pre = con.prepareStatement(insertSQL);
					pre.setString(1, SUsername);
					pre.setString(2, SPassword);
					int ok = pre.executeUpdate();
					con.close();
					RequestDispatcher dispatcher=request.getRequestDispatcher("SellerRegister_success.jsp");
        			dispatcher.forward(request,response);
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
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
