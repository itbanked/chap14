<%@page import="com.example.domain.Emp"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
   <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>listall.jsp</title>
<!-- 1.animate -->
<link rel="stylesheet" href="/webjars/animate.css/3.5.2/animate.min.css">
<!-- 2.bootstrap -->
<link rel="stylesheet" href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
<!-- 3. jquery -->
<script type="text/javascript" src="/webjars/jquery/1.11.1/jquery.min.js"></script>
<!-- 4. bootstrap -->
<script type="text/javascript" src="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
</head>
<body>
<h1>직원 리스트</h1>
<table class="table table-bordered table-striped">
<thead>
<tr>
<th>직원번호</th><th>직원이름</th><th>입사일</th><th>직급</th><th>매니저번호</th><th>월급</th><th>보너스</th><th>부서번호</th>
</tr>
</thead>
<tbody>
<%
	List<Emp> list = (List<Emp>)request.getAttribute("emps");
	
	for(Emp e : list){

%>
<tr>
<td><%= e.getEmpno() %></td><td><%= e.getEname() %></td><td><%= e.getHiredate() %></td><td><%= e.getJob()%></td>
<td><%= e.getMgr()%></td><td><%= e.getSal() %></td><td><%= e.getComm()%></td><td><%= e.getDeptno() %></td>
</tr>
<%-- 	<%= e.getEmpno() %>,<%= e.getEname() %>, <%= e.getHiredate() %><br> --%>
<%
	}
%>
</tbody>
</table>

<hr>

<table class="table table-striped">
<thead>
<tr>
<th>직원번호</th><th>직원이름</th><th>입사일</th><th>직급</th><th>매니저번호</th><th>월급</th><th>보너스</th><th>부서번호</th>
</tr>
</thead>
<tbody>
<c:forEach var="e" items="${emps}">
	
	<tr>
	<td>${e.empno}</td> <td>${e.ename}</td> <td> ${e.hiredate}</td><td>${e.job}</td><td>${e.mgr}</td>
	<td>${e.sal }</td><td>${e.comm }</td><td>${e.deptno}</td>
	</tr>
	
<%-- 	${e.empno}, ${e.ename}, ${e.hiredate}<br> --%>
	
</c:forEach>
</tbody>
</table>



</body>
</html>