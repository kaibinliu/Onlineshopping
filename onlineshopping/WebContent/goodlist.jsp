<%@page import="model.Good1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" >
<title>Insert title here</title>
</head>
<body>
 <header style="width:8cm; height: 1cm; line-height: 1cm; text-align: center; margin-left: auto;margin-right: auto;   background-color: sandybrown;">
        商品列表
    </header>
<%
Good1 g1=new Good1();
Connection conn=null;
Statement  state=null;
ResultSet rs=null;
Class.forName("com.mysql.jdbc.Driver");
String jdbc="jdbc:mysql://127.0.0.1:3306/onlineshopping?characterEncoding=UTF-8&serverTimezone=UTC";
conn=DriverManager.getConnection(jdbc, "root", "001124");
state =conn.createStatement();
String sql="select * from good where GState='销售中'";
rs=state.executeQuery(sql);	
while(rs.next()) {
g1.setGNo(rs.getInt(1));
g1.setGName(rs.getString(2)); 
g1.setGPicture(rs.getString(4));
g1.setGPrice(Double.parseDouble(rs.getString(5)));
g1.setGDescribe(rs.getString(3));
g1.setGState(rs.getString(7));
%>		
       <table id="main" border="1" style="width: 8cm;  height: fit-content; margin-left: auto; margin-right: auto;">
        <td><img src=<%=g1.getGPicture() %> width="150" height="100"> </td>
        <td>
            <p> <%=g1.getGName() %></p> <br> 
                      详细信息:<p> <%=g1.getGDescribe() %></p>
            	价格:<%=g1.getGPrice() %>
            	<%if (g1.getGState().equals("交易中")) {%>
            <form action="userinformation.jsp" method="post">
                <input style="float: right;"type="submit" value="购买" disabled="disabled">
            </form>
            <%} else{ %>
            <form action="userinformation.jsp" method="post">
                <input style="float: right;"type="submit" value="购买"  >
                <input type="hidden" name="id" value=<%=g1.getGNo()%>>
            </form>
            <% }%>
        </td>
    </table>
<% }conn.close();
   %>
</body>
</html>