package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Reci;
import util.BaseConnection;

public class Dao {
	public static Reci getDetail(int id) {
		String sql = "select * from reci2 where id = " + id;
		System.out.println(sql);
		Reci detail = null;
		Connection conn = BaseConnection.getConnection();
		Statement state = null;
		ResultSet rs = null;

		try {
			state = conn.createStatement();
			rs = state.executeQuery(sql);
			while (rs.next()) {
				String word = rs.getString("word");
				String jieshi = rs.getString("jieshi");
				String dizhi = rs.getString("dizhi");
				detail = new Reci(id,word,jieshi,dizhi);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BaseConnection.close(rs, state, conn);
		}
		
		return detail;
	}

	public static List<Reci> list(String keyword) {
		System.out.println("123");
		String sql = "select * from reci2 where type= '" + keyword + "'";
		System.out.println(sql);
		List<Reci> list = new ArrayList<>();
		Connection conn = BaseConnection.getConnection();
		Statement state = null;
		ResultSet rs = null;

		try {
			state = conn.createStatement();
			rs = state.executeQuery(sql);
			Reci course = null;
			while (rs.next()) {
				int id = rs.getInt("id");
				String word2 = rs.getString("word");
				String jieshi = rs.getString("jieshi");
				String dizhi = rs.getString("dizhi");
				course = new Reci(id,word2,jieshi,dizhi);
				list.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BaseConnection.close(rs, state, conn);
		}
		
		return list;
	}
	
	public static List<Reci> select(String value) {
		System.out.println("123");
		String sql = "select * from reci2 where word='" + value+ "'";
		System.out.println(sql);
		List<Reci> list1 = new ArrayList<>();
		Connection conn = BaseConnection.getConnection();
		Statement state = null;
		ResultSet rs = null;

		try {
			state = conn.createStatement();
			rs = state.executeQuery(sql);
			Reci course = null;
			while (rs.next()) {
				//int id = rs.getInt("id");
			//	String word2 = rs.getString("word");
				String jieshi = rs.getString("jieshi");
				String dizhi = rs.getString("dizhi");
				course = new Reci(jieshi,dizhi);
				list1.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BaseConnection.close(rs, state, conn);
		}
		
		return list1;
	}
	
	public static List<Reci> searchLike(String word) {
		String sql = "select * from reci2 where word like '%" + word + "%'";
		System.out.println("sql:"+sql);
		List<Reci> list1 = new ArrayList<>();
		Connection conn = BaseConnection.getConnection();
		Statement state = null;
		ResultSet rs = null;

		try {
			state = conn.createStatement();
			rs = state.executeQuery(sql);
			Reci course = null;
			while (rs.next()) {
				//int id = rs.getInt("id");
			//	String word2 = rs.getString("word");
				String jieshi = rs.getString("jieshi");
				String dizhi = rs.getString("dizhi");
				course = new Reci(jieshi,dizhi);
				list1.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BaseConnection.close(rs, state, conn);
		}
		
		return list1;
	}
}
