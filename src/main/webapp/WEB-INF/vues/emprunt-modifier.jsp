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

	<h2>Modifier un emprunt</h2>
	</div>
	<div>
	<form class="flex-container" method="POST">
		
			<label>Id de l'emprunt : </label>
			<input type="number" name="empruntId" required>
			<label>Date de restitution : </label>
			<input type="date" name="dateRestitution" required>
			<input type="submit" value="Modifier">
	</form>
	<p>${modif}</p>
	<p>${erreur}</p>
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
		<a href="/emprunt">Ajouter un emprunt</a>
		<a href="/livre">Ajouter un livre</a>
	</div>
</body>
</html>