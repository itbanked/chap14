package com.example.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberTests {
	
	//DI(Dependency Injection)
	@Autowired
	DataSource datasource;
	
	SimpleDateFormat format = new SimpleDateFormat("YYYY/MM/DD");
	
	@Test
	public void test01_select() throws SQLException{
		System.out.println("################");
		System.out.println("test01_select()");
		System.out.println("################");
		
		Connection con = datasource.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement("select * from member");
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){
			int no = rs.getInt("no");
			String name = rs.getString("name");
			Date regdate = rs.getDate("regdate");
			System.out.println(no +","+ name +","+ format.format(regdate));
		}
		
		con.close();
		
	}
	@Test
	public void test02_insert() throws SQLException, ParseException{
		System.out.println("################");
		System.out.println("test02_insert()");
		System.out.println("################");
		
		Connection con = datasource.getConnection();
		PreparedStatement pstmt = con.prepareStatement("insert into member values (?,?,?)");
		pstmt.setInt(1, 30);
		pstmt.setString(2, "yyy");
		
		pstmt.setDate(3, new java.sql.Date(format.parse("2000/01/03").getTime()));
//		Date date = format.parse("1999/10/10");	//Date type으로 변환
//		java.sql.Date regdate = new java.sql.Date(date.getTime());
//		pstmt.setDate(3, regdate);
		
		int rtn = pstmt.executeUpdate();
		
		System.out.println("rtn = " + rtn);
		
		con.close();
		
	}
	
}
