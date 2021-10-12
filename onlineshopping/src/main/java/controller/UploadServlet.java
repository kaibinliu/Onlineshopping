package controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.GoodDao;

import model.Good;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UploadServlet
 */
@MultipartConfig(location = "E:/Eclipse/Eclipse_workplace/onlineshopping/onlineshopping/WebContent/img")
public class UploadServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Ϊ������������
		String ima_add=""; 
		Good good=new Good();
		request.setCharacterEncoding("utf-8");
		String basePath = "E:/Eclipse/Eclipse_workplace/onlineshopping/onlineshopping/WebContent/img";
		// ��ȡ�����ϴ��ļ���Ϣ����д�������
		Collection<Part> parts = request.getParts();
		for (Part part : parts) {
			if (part.getSize() > 0) {
				String fname = part.getSubmittedFileName();
				// �������һ��uuid��Ϊ�ļ�����
				String uuid = UUID.randomUUID().toString();
				// ��ȡ�ļ���׺
				if(fname!=null) {
					String suffix = fname.substring(fname.lastIndexOf("."));
					// ���uuid���ļ���׺��Ϊ�µ��ļ�����
					fname = uuid + suffix;
					part.write(basePath + "/"+ fname);
					ima_add+="/img/" + fname+";";
				}else
					continue;
			}
		}
		try {
			good.setG_name(request.getParameter("sname"));
			good.setG_des(request.getParameter("sintruction"));
			good.setG_img(ima_add);
			good.setG_price(Double.parseDouble(request.getParameter("sprice")));
			GoodDao gd=new GoodDao();
			gd.release(good);
		} catch (Exception e) {
			request.getRequestDispatcher("Release.jsp").forward(request, response);
			e.printStackTrace();
		}
		response.sendRedirect("Show.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
