<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Guitar Seacher</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">	
</head>
<body>
	<header id="header">
		<span>Rick's store</span>
		<span>Welcome here to choose the guitar suitable you like</span>
	</header>
	<section id="wrap">
		<div id="search-form">
			<form method="get" action="SearchGuitar">
				<ul>
<!-- 					<li>
						<label for="serialNumber">Serial Number:</label>
						<input type="input" name="serialNumber" placeholder="Serial Number" id="serialNumber">
					</li> -->

					<li>
						<label for="builder">Builder:</label>
						<input type="input" name="builder" placeholder="builder" id="builder">
					</li>

					<li>
						<label for="model">Model:</label>
						<input type="input" name="model" placeholder="model" id="model">
					</li>

					<li>
						<label for="type">Type:</label>
						<input type="input" name="type" placeholder="type" id="type">
					</li>

					<li>
						<label for="backWood">Back Wood:</label>
						<input type="input" name="backWood" placeholder="back wood" id="backWood">
					</li>
					<li>
						<label for="">Top Wood:</label>
						<input type="input" name="topWood" placeholder="top wood" id="topWood">
					</li>
<!-- 					<li>
						<label for="price">Price:</label>
						<input type="input" name="price" placeholder="price" id="price">
					</li> -->
				</ul>
				<input type="submit" name="submit" value="search">
			</form>
		</div>
		<div id="result-show">
			<h2>Results</h2>
			<table border="1">
				<thead>
					<tr>
						<th>Serial Number</th>
						<th>Builder</th>
						<th>Model</th>
						<th>Type</th>
						<th>Back Wood</th>
						<th>Top Wood</th>
						<th>Price</th>
					</tr>
				</thead>
				<tbody>
					
				</tbody>
			</table>
		</div>
	</section>
</body>
</html>