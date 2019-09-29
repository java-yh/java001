package cn.yunhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.alibaba.fastjson.JSON;

import cn.yunhe.entity.UserInfo;
import cn.yunhe.util.DBUtils;

/**
 * Servlet implementation class LoginServletAdd
 */
@WebServlet("/LoginServletAdd")
public class LoginServletAdd extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");	
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
				
				
	
		String sql = "insert into userinfo(username,password) values(?,?)";
		Object[] objects = {username,password};
		int result = DBUtils.cudPre(sql, objects);
		String jsonString = JSON.toJSONString(result);
		out.print(jsonString);
		out.close();
			
	}
		

	}
