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
	<h2>Ajouter un livre :</h2>
</div>
<div>
	<form class="flex-container" method="POST">
		<label>Titre :</label>
		<input type="text" name="titre">
		<label>Année d'édition : </label>
		<input name="anneeEdition" type="date">
		<label>Editeur :</label>
		<input type="text" name="editeur">
		<label>Prénom de l'auteur : </label>
		<input type="text"name="prenomAuteur">
		<label>Nom de l'auteur :</label>
		<input type="text" name="nomAuteur">
		<input type="submit" value="Ajouter">
	</form>
	<p>${validation}</p>
	</div>	
	</section>
	<div class="liens">
		
		<a href="/bibliotheque">Retour au menu principal</a>
		<a href="/livre/liste">Lister les livres</a>
		<a href="/emprunt">Gestion des emprunts</a>
	</div>
</body>
</html>