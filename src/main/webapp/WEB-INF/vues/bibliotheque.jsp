<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style><%@include file="/css/style.css"%></style>
<title>Gestion de bibliothèque</title>
</head>
<body>
<section class="principal">
<div>
	<h1>Bibliothèque</h1>
	<h2>Bienvenue sur l'application de gestion de bibliothèque</h2>
	</div>
	<div class = "choisir">
	
		<!-- 	1ere page : creer un livre -->
		<a href="/livre">Créer ou voir des livres</a>
	<!-- 2eme page : creer + afficher + modifier emprunt -->
	<a href="/emprunt">Créer, voir ou modifier des emprunts</a>
	</div>
	</section>
</body>
</html>