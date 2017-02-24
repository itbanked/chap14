package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dao.EmpDao;
import com.example.domain.Emp;

//servlet과 같은역할 , servlet을 사용하기 위함
@Controller
public class EmpController {
	
	static Log log = LogFactory.getLog(EmpController.class);
	
	@Autowired
	EmpDao dao;		//db에 접근하기 위함

	@RequestMapping("/emp/listall")
	public String listAll(HttpServletRequest request){
		log.info("#############");
		log.info("listAll()");
		log.info("#############");
		
		List<Emp> list = dao.getAllEmps();
		
		request.setAttribute("emps", list);
	
		
		return "listall";	//view를 리턴  (저절로 forward가 됨)
	}
	
}
