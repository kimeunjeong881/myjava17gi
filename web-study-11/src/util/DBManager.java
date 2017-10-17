package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			// jdbc/myoracle�씠�� �씠由꾩쓣 媛앹껜瑜� 李얠븘�꽌 DataSource媛� 諛쏅뒗�떎.
			DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
			// ds媛� �깮�꽦�릺�뿀�쑝誘�濡� Connection�쓣 援ы빀�땲�떎.
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// select�쓣 �닔�뻾�븳 �썑 由ъ냼�뒪 �빐�젣瑜� �쐞�븳 硫붿냼�뱶
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// DML(insert, update, delete)�쓣 �닔�뻾�븳 �썑 由ъ냼�뒪 �빐�젣瑜� �쐞�븳 硫붿냼�뱶
	public static void close(Connection conn, Statement stmt) {
		try {
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
