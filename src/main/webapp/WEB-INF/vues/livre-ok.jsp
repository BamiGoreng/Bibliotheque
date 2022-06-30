<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion de bibliothèque</title>
</head>
<body>
	<h1>Bibliothèque</h1>
	<h2>Ajouter un livre :</h2>
	<form method="POST">
		<div>
			<label>Titre : <input type="text" name="titre"></label>
		</div>
		<div>
			<label>Année d'édition : <input name="anneeEdition"
				type="date"></label>
		</div>
		<div>
			<label>Editeur :<input type="text" name="editeur"></label>
		</div>
		<div>
			<label>Prénom de l'auteur : <input type="text"
				name="prenomAuteur"></label>
		</div>
		<div>
			<label>Nom de l'auteur : <input type="text" name="nomAuteur"></label>
		</div>
		<input type="submit" value="Ajouter">
	</form>
	<div>
		<p>${validation}</p>
		<a href="/bibliotheque">Retour au menu principal</a>
		<a href="/livre/liste">Lister les livres</a>
		<a href="/emprunt">Gestion des emprunts</a>
	</div>
</body>
</html>