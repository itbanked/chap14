package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.domain.Emp;

@Component
public class EmpDao {
	
	static Log log = LogFactory.getLog(EmpDao.class);
	
	@Autowired
	DataSource datasource;
	
	
	public List<Emp> getAllEmps(){
		System.out.println("############");
		System.out.println("getAllEmps()");
		System.out.println("############");
		
		List<Emp> list = new ArrayList<Emp>();

		try {
			Connection con = datasource.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from emp");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				Emp e = new Emp();
				e.setEmpno(rs.getInt("empno"));
				e.setEname(rs.getString("ename"));
				e.setJob(rs.getString("job"));
				e.setMgr(rs.getInt("mgr"));
				e.setHiredate(rs.getDate("hiredate"));
				e.setSal(rs.getDouble("sal"));
				e.setComm(rs.getDouble("comm"));
				e.setDeptno(rs.getInt("deptno"));
				
				
				list.add(e);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
		return list;
	}

}
