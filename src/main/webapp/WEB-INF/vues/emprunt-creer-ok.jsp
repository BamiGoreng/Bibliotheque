<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<h2>Ajouter un emprunt</h2>
	<form method="POST">
		<div>
			<label>Id du livre : <input type="number" name="livreId"
				required>
			</label>
		</div>
		<a href="/livre/liste">Liste des livres</a>
		<div>
			<label>Nom de l'emprunteur : <input type="text"
				name="emprunteur" required>
			</label>
		</div>
		<input type="submit" value="Ajouter">
		<p>${ajout}</p>
		<p>${erreur}</p>
	</form>
	<h2>Liste des emprunts</h2>
	<table>
		<tr>
			<td>ID de l'emprunt</td>
			<td>Nom de l'emprunteur</td>
			<td>Date d'emprunt</td>
			<td>ID du livre</td>
			<td>Date de restitution</td>
		</tr>
		<c:forEach items="${emprunts}" var="d">
			<tr>
				<td>${d.idEmprunt}</td>
				<td>${d.emprunteur}</td>
				<td>${d.dateEmprunt}</td>
				<td>${d.livre.idLivre}</td>
				<td>${d.dateRestitution}</td>
			</tr>
		</c:forEach>
	</table>
	<ul>
		<li><a href="/bibliotheque">Retour au menu principal</a></li>
		<li><a href="/emprunt/modifier">Modifier un emprunt</a></li>
		<li><a href="/livre">Ajouter un livre</a></li>
	</ul>
</body>
</html>