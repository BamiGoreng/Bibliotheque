<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Bibliothèque</h1>
	<h2>Ajouter un livre :</h2>
	<!-- 	Message d'erreur s'affichant sous conditions définies dans le Controller -->
	<p>${message}</p>
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
		<input type="submit" value="Envoi">
	</form>
	<p>
		<a href="/inde">Retour à la page d'accueil</a>
	</p>
</body>
</html>