<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@page import="guitarsearch.domain.Builder" %>
<%@page import="guitarsearch.domain.Type" %>
<%@page import="guitarsearch.domain.Wood" %>


<html lang="zh-CN">
<head>
	<meta charset="UTF-8">
	<title>Guitar Seacher 2.0</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/jquery-2.2.0.min.js"></script>
	<script type="text/javascript" src="js/search.js"></script>
</head>
<body>
	<header id="header">
		<div class="welcomes">
			<span>Rick's store</span>
			<sub>Welcome here to choose the guitar you like</sub>
		</div>
	</header>
	<section id="content">
		<div class="search-form">
			<form id="myform">
				<ul>
				
					<li>
						<label for="builder">Builder:</label>
						<select name="bulider" id="builder">
							<c:forEach var="builder" items="${Builder.builder}">
								<option value="${builder}">${builder.name}</option>
							</c:forEach>
						</select>				
					</li>
					
					<li>
						<label for="type">Type:</label>
						<select name="type" id="type">
							<c:forEach var="type" items="${Type.type}">
								<option value="${type}">${type.name}</option>
							</c:forEach>
						</select>	
					</li>
					
					<li>
						<label for="numStrings">Strings:</label>
						<select name="numStrings" id="numStrings">
							<c:forTokens delims="," var="string" items="4,6,7,8,12">
								<option value="${string}">${string}</option>
							</c:forTokens>
						</select>
					</li>
					
					<li>
						<label for="backWood">Back Wood:</label>
						<select name="backWood" id="backWood">
							<c:forEach var="backWood" items="${Wood.wood}">
								<option value="${backWood}">${backWood.name}</option>
							</c:forEach>
						</select>
					</li>
					
					<li>
						<label for="topWood">Top Wood:</label>
						<select name="topWood" id="topWood">
							<c:forEach var="topWood" items="${Wood.wood}">
								<option value="${topWood}">${topWood.name}</option>
							</c:forEach>
						</select>
					</li>
					
					<li>
						<label for="model">Model:</label>
						<input type="input" name="model"  id="model">
					</li>
					
				</ul>			
				<input type="button" name="submit" value="search" id="btnQuery">
			</form>
		</div>

		<div class="result">
			<h2>Results</h2>

			<table border="1">
				<thead>
					<tr>
						<th>Serial Number</th>
						<th>Builder</th>
						<th>Model</th>
						<th>Spring Number</th>
						<th>Type</th>
						<th>Back Wood</th>
						<th>Top Wood</th>
						<th>Price</th>
					</tr>
				</thead>

				<tbody id="r-tbody">
				</tbody>
			</table>

			<div id="tips"></div>
		</div>
	</section>
</body>
</html>