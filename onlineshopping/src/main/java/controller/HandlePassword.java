package controller;
import java.sql.*;

import java.io.*;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.HandlePasswordBean;
import model.SetPassword;


public class HandlePassword extends HttpServlet 
{
	public void init(ServletConfig config) throws ServletException { 
		
	      super.init(config);
	   }
	   public String handleString(String s)
	   {
		   try{ byte bb[]=s.getBytes("UTF-8");
	            s=new String(bb);
	       }
	       catch(Exception ee){} 
	       return s;  
	   }
	   
	    public  void  doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	 	   this.doPost(request,response); 
	 	   }
	    
	   
	    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        
	    	request.setCharacterEncoding("utf-8");
	        String password = request.getParameter("password").trim();
	        String again_password=request.getParameter("again_password").trim();
	        SetPassword set = new SetPassword(password, again_password);
	        HandlePasswordBean hp=new HandlePasswordBean();
	      
	   	    HttpSession session=request.getSession(true);
	   	      	     	   	      	     	     	
	        //传入参数
	        if(!password.equals(again_password)){	       
	           RequestDispatcher dispatcher=request.getRequestDispatcher("change_fail.jsp");
	        	dispatcher.forward(request,response);
	        	return;
	        }
	        
	        boolean boo=password.length()>0;
	       
	        if(password.equals(again_password)){
	        	        boolean a = hp.change(set);
	        			RequestDispatcher dispatcher=request.getRequestDispatcher("change_sucess.jsp");//转发
	        			dispatcher.forward(request,response);
	        			}
	        		
	        else{	        		
	        		
		        	RequestDispatcher dispatcher=request.getRequestDispatcher("change_fail.jsp");
		        	dispatcher.forward(request,response);
		        	
		        	return;
	       }	        	        	  
	     	}	     
}			   
			   

