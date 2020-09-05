<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
  	background: url(resources/img/background.jpg);
  	background-repeat: no-repeat;
  	background-size: cover;
}
body, h1, h2, h3, h4, h5, h6 {
	font-family: "Raleway", Arial, Helvetica, sans-serif
}

</style>
<title>Levenshtein Distance Calculator</title>
</head>
<body class="w3-light-grey">

	<!-- Navigation Bar -->
	<div class="w3-bar w3-white w3-border-bottom">
		<a href="/home"
			class="w3-bar-item w3-button w3-text-red w3-hover-red"><b>Levenshtein
				Distance Calculator</b></a>
	</div>
	<div id="block1" class="w3-display-middle" style="width: 65%">
		<div>
			<form action="/calculate" method="POST">
				<div class="w3-container w3-white w3-padding-16">
					<h3>Enter Word1 and Word2</h3>
					<div class="w3-row-padding" style="margin: 0 -16px;">
						<div class="w3-half">
							<label>Word1</label> <input class="w3-input w3-border"
								name="token1" type="text" placeholder="${text1}" required="true">
						</div>
						<div class="w3-half">
							<label>Word2</label> <input class="w3-input w3-border"
								name="token2" type="text" placeholder="${text2}" required="true">
						</div>
					</div>
					<p>
						<input type="submit" value="Calculate Levenshtein Distance"
							class="w3-button w3-red">
					</p>
				</div>
			</form>
		</div>
		<div>
			<div class="w3-container w3-white w3-padding-16 w3-border-top">
				<div class="w3-half">
					<h1>Result:</h1>
				</div>
				<div class="w3-half">
					<h1 class="w3-text-red">${message}</h1>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer -->
	<footer class="w3-bar w3-container w3-center w3-white w3-display-bottommiddle">
		<h5>Find Me Online</h5>
		<div class="w3-display-bottom">
			<a href="https://prafulladiwesh.github.io/prafulladiwesh/"><i
				class="fa fa-globe w3-hover-opacity"
				style="font-size: 36px; color: red"></i></a> <a
				href="https://www.linkedin.com/in/prafulla-diwesh-73905a104/"><i
				class="fa fa-linkedin w3-hover-opacity"
				style="font-size: 36px; color: red"></i></a> <a
				href="https://github.com/prafulladiwesh"><i
				class="fa fa-github w3-hover-opacity"
				style="font-size: 36px; color: red"></i></a> <a
				href="https://prafulladiwesh@gmail.com"><i
				class="fa fa-envelope w3-hover-opacity"
				style="font-size: 36px; color: red"></i></a>
		</div>
		<p>
			Created by <a href="https://prafulladiwesh.github.io/prafulladiwesh/"
				target="_blank" class="w3-hover-text-red">Prafulla Diwesh</a>
		</p>
	</footer>
</body>
</html>
