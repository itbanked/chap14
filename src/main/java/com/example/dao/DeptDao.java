package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.domain.Dept;

@Component
public class DeptDao {
	
	static Log log = LogFactory.getLog(DeptDao.class);
	
	@Autowired
	DataSource datasource;
	
	public List<Dept> getAllDepts(){
		System.out.println("############");
		System.out.println("test01_select()");
		System.out.println("############");
		
		List<Dept> list = new ArrayList<>();
		
		try {
			Connection con = datasource.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from dept");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				Dept d = new Dept();
				d.setDeptno(rs.getInt("deptno"));
				d.setDname(rs.getString("dname"));
				d.setLoc(rs.getString("loc"));
				list.add(d);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}

}
