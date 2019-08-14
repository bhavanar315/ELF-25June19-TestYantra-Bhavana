package com.tyss.emp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.tyss.emp.dto.EmployeeInfoBean;

import lombok.extern.java.Log;

@Log
@Component
public class EmployeeDAOJDBCImpl implements EmployeeDAO {

	public  ArrayList<EmployeeInfoBean> getAllEmployeeInfo() {
		String dbUrl = "jdbc:mysql://localhost:3306/techchefs_db";
		String query = "select * from employee_info";

		try (Connection connection = DriverManager.getConnection(dbUrl, "root", "root");
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(query);) {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			ArrayList<EmployeeInfoBean> arrayList=new ArrayList<EmployeeInfoBean>();
			
			// 4."Process the results" returned by "SQL queries"
			while (rs.next()) {
				EmployeeInfoBean bean=new EmployeeInfoBean();
				
				bean.setId(rs.getInt("id"));
				bean.setEmpName(rs.getString("name"));
				bean.setAge(rs.getInt("age"));
				bean.setPhone(rs.getLong("phone"));
				bean.setGender(rs.getString("gender"));
				bean.setSalary(rs.getDouble("salary"));
				bean.setJoiningDate(rs.getDate("joining_date"));
				bean.setAccountNumber(rs.getInt("account_number"));
				bean.setEmail(rs.getString("email"));
				bean.setDesignation(rs.getString("designation"));
				bean.setDob(rs.getDate("dob"));
				//bean.setDepartmentId(rs.getInt("dept_id"));
				//bean.setManagerId(rs.getInt("mngr_id"));
				arrayList.add(bean);
			}
			return arrayList;
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public EmployeeInfoBean getEmployeeInfo(String id) {

		try {
			return getEmployeeInfo(Integer.parseInt(id));
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return null;
		}
	}

	public EmployeeInfoBean getEmployeeInfo(int id) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmployeeInfoBean bean = null;
		try {
			// 1.Load the "Driver"
//			java.sql.Driver driver = new com.mysql.jdbc.Driver();
//			DriverManager.deregisterDriver(driver);
			Class.forName("com.mysql.jdbc.Driver");
			// 2.Get the "DB Connection" via "Driver"

			String dbUrl = "jdbc:mysql://localhost:3306/techchefs_db";
			connection = DriverManager.getConnection(dbUrl, "root", "root");

			log.info("Connection Obj==>" + connection.getClass());

			// 3.Issue "SQL Queries" via "Connection"
			String query = "select * from employee_info " + "where id=?";
			log.info("" + query);
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			bean = new EmployeeInfoBean();

			// 4."Process the results" returned by "SQL queries"
			while (rs.next()) {
				bean.setId(rs.getInt("id"));
				bean.setEmpName(rs.getString("name"));
				bean.setAge(rs.getInt("age"));
				bean.setPhone(rs.getLong("phone"));
				bean.setGender(rs.getString("gender"));
				bean.setSalary(rs.getDouble("salary"));
				bean.setJoiningDate(rs.getDate("joining_date"));
				bean.setAccountNumber(rs.getInt("account_number"));
				bean.setEmail(rs.getString("email"));
				bean.setDesignation(rs.getString("designation"));
				bean.setDob(rs.getDate("dob"));
				//bean.setDepartmentId(rs.getInt("dept_id"));
				//bean.setManagerId(rs.getInt("mngr_id"));

			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// 5.Close all JDBC Objects
			try {
				if (connection != null) {
					connection.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return bean;
	}

	@Override
	public boolean createEmployeeInfo(EmployeeInfoBean bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEmployeeInfo(EmployeeInfoBean bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEmployeeInfo(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEmployeeInfo(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<EmployeeInfoBean> getEmployeeIds(int eid) {
		// TODO Auto-generated method stub
		return null;
	}

}
