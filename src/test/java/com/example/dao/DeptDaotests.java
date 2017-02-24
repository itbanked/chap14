package com.example.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Dept;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeptDaotests {
	
	@Autowired
	DeptDao dao;

	@Test
	public void test01_getAllDepts(){
		
		List<Dept> list = dao.getAllDepts();
		
		for(Dept l : list){
			System.out.println(l.getDname() +","+ l.getDname() +","+ l.getLoc());
		}
	}
}
