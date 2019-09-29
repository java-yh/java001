/**
 * 
 */
package cn.yunhe.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/**
 * @迪丽惹bug
 *
 * 2019年9月21日下午2:14:05
 */
public class DBUtils {
	private static final String DRIVER = "org.gjt.mm.mysql.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/java?serverTimezone=UTC";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "1314";
	
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取数据库链接对象
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 增删改通用
	 * @param sql
	 * @return
	 */
	public static int cud(String sql) {
		Connection conn = null;
		Statement statement = null;
		int result = 0;
		try {
			//获取数据库连接对象
			conn = getConnection();
			//获取执行SQL的对象
			statement = conn.createStatement();
			//执行SQL
			result = statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//关闭数据库链接对象
			close(conn,statement,null);
		}
		return result;
	}
	
	/**
	 * 预编译形式增删改功能封装
	 * @param sql
	 * @param objects
	 * @return
	 */
	public static int cudPre(String sql,Object...objects) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			//获取数据库连接对象
			conn = getConnection();
			//获取执行SQL的对象
			ps = conn.prepareStatement(sql);
			//设置传递过来的参数
			for(int i=0;i<objects.length;i++) {
				//数组的下标是从零开始,目的是为了取数组中的数据
				//占位符(?)从1开始,标识的是占位符的位置
				ps.setObject(i+1, objects[i]);
			}
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//关闭数据库链接对象
			close(conn,ps,null);
		}
		return result;
	}
	
	/**
	 * 关闭数据库链接
	 * @param conn
	 * @param statement
	 * @param rs
	 */
	public static void close(Connection conn,Statement statement,ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(statement != null) {
				statement.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
