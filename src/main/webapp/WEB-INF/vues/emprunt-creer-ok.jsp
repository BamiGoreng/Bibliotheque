<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<h2>Ajouter un emprunt</h2>
		</div>
		<div>
			<form class="flex-container" method="POST">
				<label>Id du livre : </label>
				 <input type="number" name="livreId" required>
				 <label>Nom de l'emprunteur : </label>
				 <input	type="text" name="emprunteur" required>
				 <input	type="submit" value="Ajouter">
				<p>${ajout}</p>
				<p>${erreur}</p>
			</form>
		</div>
		<div>
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
		</div>
	</section>
	<div class="liens">
		<a href="/bibliotheque">Retour au menu principal</a> 
		<a href="/emprunt/modifier">Modifier un emprunt</a> 
		<a href="/livre">Ajouter un livre</a>
	</div>
</body>
</html>