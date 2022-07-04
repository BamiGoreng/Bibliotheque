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
	<h1>Bibliothèque</h1>
	<h2>Liste des Emprunts</h2>
	<table>
		<tr>
			<td>ID de l'emprunt</td>
			<td>Nom de l'emprunteur</td>
			<td>Date d'emprunt</td>
			<td>ID du livre</td>
			<td>Date de restitution</td>
			<!-- <td>Titre</td>
			<td>Année d'édition</td>
			<td>Editeur</td>
			<td>Prénom de l'auteur</td>
			<td>Nom de l'auteur</td> -->
		</tr>
		<c:forEach items="${emprunts}" var="d">
			<tr>
				<td>${d.idEmprunt}</td>
				<td>${d.emprunteur}</td>
				<td>${d.dateEmprunt}</td>
				<td>${d.livre.idLivre}</td>
				<td>${d.dateRestitution}</td>
				<%-- <td>${d.livre.titre}</td>
				<td>${d.livre.anneeEdition}</td>
				<td>${d.livre.editeur}</td>
				<td>${d.livre.prenomAuteur}</td>
				<td>${d.livre.nomAuteur}</td> --%>
			</tr>
		</c:forEach>
	</table>

	<div>
		<p>${validation}</p>
		<a href="/bibliotheque">Retour au menu principal</a> 
		<a href="/emprunt">Ajouter un emprunt</a>
		<a href="/emprunt/modifier">Modifier un emprunt</a>
	</div>
</body>
</html>