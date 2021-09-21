package handle.data;

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


public class userinfo extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id"); 
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    //String time=df.format(new Date());
		//System.out.print(time);
		String name=request.getParameter("buyername");
		String pwd=request.getParameter("buyerphone");
		if(name!=null&&pwd!=null)
		{
			try {
				Connection conn=null;
				Statement  state=null;
				ResultSet rs=null;
				Class.forName("com.mysql.jdbc.Driver");
				String jdbc="jdbc:mysql://127.0.0.1:3306/onlineshopping?characterEncoding=UTF-8&serverTimezone=UTC";
				conn=DriverManager.getConnection(jdbc, "root", "001124");
				state =conn.createStatement();
				String sql="insert into  purchase (PDate,GNo,Username,Phone) values ('"+df.format(new Date())+"',"+id+",'"+name+"','"+pwd+"')";
			
				state.executeUpdate(sql);
			}catch (Exception e) {
				e.printStackTrace();
				}
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
