/**
 * 
 */
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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.scripting.xmltags.IfSqlNode;

import com.alibaba.fastjson.JSON;

import cn.yunhe.entity.Product;
import cn.yunhe.entity.UserInfo;
import cn.yunhe.util.DBUtils;

/**
 * @迪丽惹bug
 *
 * 2019年9月25日下午6:22:35
 */
public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String type = request.getParameter("type");
		if ("submit".equals(type)) {
			String name = request.getParameter("username");
			String pwd = request.getParameter("password");
			System.out.println(quert(name, pwd));
			System.out.println(name);
			System.out.println(pwd);
			quert(name, pwd);
			if (null!=quert(name, pwd)) {
				response.sendRedirect("show.jsp");				 
				System.out.println("成功");				
			}else {
				response.sendRedirect("login.jsp");	
				out.print("错误");
				System.out.println("错误");
			}
		} 
		if ("show".equals(type)) {
			Connection connection = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			List<Product> list = new ArrayList<Product>();
			try {
				connection = DBUtils.getConnection();
				String sql = "select proid,proname,proprice,proadress,proimage from product";
				ps = connection.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					Product product = new Product();
					product.setProid(rs.getInt(1));
					product.setProname(rs.getString(2));
					product.setProprice(rs.getString(3));
					product.setProaddress(rs.getString(4));
					product.setProimage(rs.getString(5));
					list.add(product);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtils.close(connection, ps, rs);
			}
			//通过Json对象返回集合数据 fastjson中的对象将集合转换成json字符串返回
			String jsonStr = JSON.toJSONString(list);
			out.print(jsonStr);
			out.close();
		}
	}
public UserInfo quert(String name,String pwd) {
	// 链接数据库
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	try {
		connection = DBUtils.getConnection();
		String sql = "select username,password from userinfo where username = ? and password = ?";
		ps = connection.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, pwd);
		rs = ps.executeQuery();
		while(rs.next()) {
			UserInfo user= new UserInfo();
			
			user.setUsername(rs.getString(1));
			user.setPassword(rs.getString(2));
			return user;
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		DBUtils.close(connection, ps, rs);
	}
	return null;
}


}
