<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@page import="guitarsearch.domain.Builder" %>
<%@page import="guitarsearch.domain.Type" %>
<%@page import="guitarsearch.domain.Wood" %>

<html lang="zh-CN">
<head>
	<meta charset="UTF-8">
	<title>Guitar Inventory</title>
	<link rel="stylesheet" type="text/css" href="css/style2.css">
</head>
<body>
	<header id="header">
		<div class="welcomes">
			<span>Rick's store</span>
			<sub>Welcome here to choose the guitar you like</sub>
		</div>
	</header>
	<section id="content">
		<table border=1>
			<thead>
				<th>Option</th>
				<th>Serial Number</th>
				<th>Builder</th>
				<th>Model</th>
				<th>Spring Number</th>
				<th>Type</th>
				<th>Back Wood</th>
				<th>Top Wood</th>
				<th>Price</th>				
			</thead>
			<tbody>
				<c:forEach var="guitar" items="${applicationScope.Guitars}">
					<tr>
						<td><input type="checkbox" name="options" value="${guitar.serialNumber}" form="deleteG"></td>
						<td>${guitar.serialNumber}</td>
						<td>${guitar.spec.builder}</td>
						<td>${guitar.spec.model}</td>
						<td>${guitar.spec.numStrings}</td>
						<td>${guitar.spec.type}</td>
						<td>${guitar.spec.backWood}</td>
						<td>${guitar.spec.topWood}</td>
						<td>${guitar.price}</td>
					</tr>		
				</c:forEach>
			</tbody>
		</table>
		<form action="DeleteGuitars" method="get" id="deleteG">
			<input type="submit" value="删除">
		</form>	
	</section>
</body>
</html>