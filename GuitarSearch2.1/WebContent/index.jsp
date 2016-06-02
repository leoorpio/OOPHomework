<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@page import="guitarsearch.domain.Builder" %>
<%@page import="guitarsearch.domain.Type" %>
<%@page import="guitarsearch.domain.Wood" %>

<html lang="zh-CN">
<head>
	<meta charset="UTF-8">
	<title>Guitar Seacher 2.1</title>
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
						<label for="builder">喜欢的制造商:</label>
						<select name="bulider" id="builder">
							<c:forEach var="builder" items="${Builder.builder}">
								<option value="${builder}">${builder.name}</option>
							</c:forEach>
						</select>				
					</li>				
				</ul>			
				<input type="button" name="submit" value="search" id="btnQuery">
			</form>
		</div>

		<div class="filter-conditions">
			<div class="filter">
				<p>筛选条件：</p>
				<div class="filter-label">
					<span>BackWood: Indian Rosewood</span>
					<i></i>
				</div>
				<div class="filter-label">
					<span>BackWood</span>
					<i></i>
				</div>
			</div>

			<div class="selected-line">
				<div class="selected-wrap">
					<div class="key-name">Type</div>
					<div class="key-value">
						<ul>
							<li>acoustic</li>
							<li>electric</li>
						</ul>
					</div>
				</div>	
			</div>

			<div class="selected-line">
				<div class="selected-wrap">	
					<div class="key-name">Strings</div>				
					<div class="key-value">
						<ul>
							<li>2</li>
							<li>4</li>
							<li>6</li>
							<li>7</li>
							<li>8</li>
							<li>12</li>
						</ul>
					</div>
				</div>
			</div>

			<div class="selected-line">
				<div class="selected-wrap">
					<div class="key-name">BackWood</div>				
					<div class="key-value">
						<ul>
							<li>Indian Rosewood</li>
							<li>Brazilian Rosewood</li>
							<li>Mahogany</li>
							<li>Maple</li>
							<li>Cocobolo</li>
							<li>Cedar</li>
							<li>Adirondack</li>
							<li>Alder</li>
							<li>Sitka</li>
						</ul>
					</div>
				</div>
			</div>

			<div class="selected-line">
				<div class="selected-wrap">
					<div class="key-name">TopWood</div>
					<div class="key-value">
						<ul>
							<li>Indian Rosewood</li>
							<li>Brazilian Rosewood</li>
							<li>Mahogany</li>
							<li>Maple</li>
							<li>Cocobolo</li>
							<li>Cedar</li>
							<li>Adirondack</li>
							<li>Alder</li>
							<li>Sitka</li>
						</ul>					
					</div>
				</div>
			</div>

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