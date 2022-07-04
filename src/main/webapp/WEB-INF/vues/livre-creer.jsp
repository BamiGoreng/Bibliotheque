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
			<input type="text" name="titre" required>
			<label>Année d'édition :</label>
			<input name="anneeEdition" type="date" required>
			<label>Editeur :</label>
			<input type="text" name="editeur" required>
			<label>Prénom de l'auteur :</label>
			<input type="text" name="prenomAuteur" required>
			<label>Nom de l'auteur :</label>
			<input type="text" name="nomAuteur"required>
			<input type="submit" value="Ajouter">
	</form>
	<p>${erreur}</p>
	</div>
	</section>
	<section class="liens">
		<a href="/bibliotheque">Retour au menu principal</a>
		<a href="/livre/liste">Lister les livres</a>
		<a href="/emprunt">Gestion des emprunts</a>
	</section>
	
</body>
</html>