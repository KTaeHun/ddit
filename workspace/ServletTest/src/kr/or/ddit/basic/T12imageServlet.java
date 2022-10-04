package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class T12imageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	// resp.setCharacterEncoding("UTF-8");
	// binary로  보낼거라 필요가 없음.	
		
		resp.setContentType("image/jpg");
		
		ServletOutputStream out = resp.getOutputStream();
		FileInputStream fis = 
				new FileInputStream("C:\\xampp\\htdocs\\jsstudy\\images\\강아지.jpg");
		
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(out);
	
		int bytesCnt = 0;
		while((bytesCnt = bis.read()) != -1) {
			bos.write(bytesCnt);
		}
	
		bis.close();
		bos.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
