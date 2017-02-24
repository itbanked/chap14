package com.example.employee;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpTests {
	
	@Autowired
	DataSource datasource;
	
//	SimpleDateFormat format = new SimpleDateFormat("YYYY/MM/DD입니다");
	
	@Test
	public void test01_select() throws SQLException{
		System.out.println("$$$$$$$");
		System.out.println("select");
		System.out.println("$$$$$$$");
		
		Connection con = datasource.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement("select * from emp");
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){
			int empno = rs.getInt("empno");
			String ename = rs.getString("ename");
			String job = rs.getString("job");
			int mgr = rs.getInt("mgr");
			Date hiredate = rs.getDate("hiredate");
			int sal = rs.getInt("sal");
			int comm = rs.getInt("comm");
			int deptno = rs.getInt("deptno");
			
			System.out.println(empno +","+ ename +","+ job +","+ mgr +","+ hiredate +","+ sal +","+ comm +","+ deptno);
//			System.out.println(empno +","+ ename +","+ job +","+ mgr +","+ format.format(hiredate) +","+ sal +","+ comm +","+ deptno);
		}
			
	}
	
	@Test
	public void test02_insert() throws SQLException{
		System.out.println("$$$$$$$");
		System.out.println("insert");
		System.out.println("$$$$$$$");
		
		Connection con = datasource.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement("insert into emp values (?,?,?,?,?,?,?,?)");
		pstmt.setInt(1, 8001);
		pstmt.setString(2, "공유");
		pstmt.setString(3, "기획부");
		pstmt.setInt(4, 8002);
//		pstmt.setDate(5, new Date(917, 1, 9));
		pstmt.setDate(5, new Date(2000000));
		pstmt.setInt(6, 80000);
		pstmt.setInt(7, 80000);
		pstmt.setInt(8, 20);
		
		int rtn = pstmt.executeUpdate();
		System.out.println("rtn = " + rtn);
		
	}
	@Test
	public void test03_update() throws SQLException{
		System.out.println("$$$$$$$");
		System.out.println("update");
		System.out.println("$$$$$$$");
		
		Connection con = datasource.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement("update emp set empno=? where ename=?");
		pstmt.setInt(1, 8003);
		pstmt.setString(2, "한가인");
		
		int rtn = pstmt.executeUpdate();
		System.out.println("rtn = " + rtn);
		
	}
	@Test
	public void test04_delete() throws SQLException{
		System.out.println("$$$$$$$");
		System.out.println("delete");
		System.out.println("$$$$$$$");
		
		Connection con = datasource.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement("delete from emp where empno=?");
		pstmt.setInt(1, 8001);
		
		int rtn = pstmt.executeUpdate();
		System.out.println("rtn = " + rtn);
		
	}

}
