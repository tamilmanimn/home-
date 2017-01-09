package com.smartglossa.home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONObject;

public class homeClass {
	Connection con = null;
	Statement stat = null;
	ResultSet rs = null;

	public homeClass() throws ClassNotFoundException, SQLException {
		openConnection();

	}

	public void addMember(int mid, String mname, String dob, String mno) throws SQLException {
		try {
			String query = "insert into member(memberid,name,dob,mobilenumber) values(" + mid + ",'" + mname + "','"
					+ dob + "','" + mno + "')";
			stat.execute(query);
		} finally {
			closeConnection();
		}
	}

	public void updateMember(int mid, String mname, String dob, String mno) throws SQLException {
		try {
			String query = "update member set name='" + mname + "',dob='" + dob + "',mobilenumber='" + mno + "'where memberid=" + mid;
			stat.execute(query);

		} finally {
			closeConnection();

		}
	}
	
	public void deleteMember(int mid) throws SQLException {
		try {
			String query="delete from member where memberid="+mid;
			stat.execute(query);
			
		} finally {
			closeConnection();

		}
		
	}
	
	public JSONObject getOne(int mid) throws SQLException {
		JSONObject result=new JSONObject();
		try {
			String query="select * from member where memberid="+mid;
			rs=stat.executeQuery(query);
			if(rs.next()){
				result.put("memberid",rs.getString("memberid"));
				result.put("name",rs.getString("name"));
				result.put("dob",rs.getString("dob"));
				result.put("mobilenumber",rs.getString("mobilenumber"));
				
			}
			
		} finally {
			closeConnection();

		}
		return result;
		
	}
	
	public JSONArray getAll() throws SQLException {
		JSONArray result=new JSONArray();
		try {
			String query="select * from member";
			rs=stat.executeQuery(query);
			while (rs.next()) {
				JSONObject obj=new JSONObject();
				obj.put("memberid",rs.getString("memberid"));
				obj.put("name",rs.getString("name"));
				obj.put("dob",rs.getString("dob"));
				obj.put("mobilenumber",rs.getString("mobilenum`"
						+ "ber"));
				result.put(obj);
					
			}
			
		} finally {
			closeConnection();

		}
		return result;
		
		
	}
	
	public void addSalary(int mid,String salary) throws SQLException {
		try {
			String query="insert into salary(memberid,salary)values("+mid+",'"+salary+"')";
			stat.execute(query);
			
		} finally {
			closeConnection();

		}
		
	}
	
	public void updateSalary(int mid,String salary) throws SQLException {
		try {
			String query="update salary set salary="+salary+" where memberid="+mid;
			stat.execute(query);
			
		} finally {
			closeConnection();

		}
		
	}
	
	public void deleteSalary(int mid) throws SQLException {
		try {
			String query="delete from salary where memberid="+mid;
			stat.execute(query);
			
		} finally {
			closeConnection();

		}
		
	}
	
	public JSONObject oneSalary(int mid) throws SQLException {
		JSONObject result=new JSONObject();
		try {
			String query="select * from salary where memberid="+mid;
			rs=stat.executeQuery(query);
			if(rs.next()){
				result.put("memberid",rs.getString("memberid"));
				result.put("salary",rs.getString("salary"));
				
			}
			
		} finally {
			closeConnection();

		}
		return result;
		
	}
	
	public JSONArray allSalary() throws SQLException {
		JSONArray result=new JSONArray();
		try {
			String query="select * from salary";
			rs=stat.executeQuery(query);
			while (rs.next()) {
				JSONObject obj=new JSONObject();
				obj.put("memberid",rs.getString("memberid"));
				obj.put("salary",rs.getString("salary"));
				result.put(obj);
				
			}
			
		} finally {
			closeConnection();

		}
		return result;
		
		
	}

	private void openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://" + homeConstant.MYSQL_SERVER + "/" + homeConstant.DATABASE,
				homeConstant.USERNAME, homeConstant.PASSWORD);
		stat = con.createStatement();

	}

	private void closeConnection() throws SQLException {
		if (con != null) {
			con.close();
		}
		if (stat != null) {
			stat.close();
		}
		if (rs != null) {
			rs.close();
		}

	}

}
