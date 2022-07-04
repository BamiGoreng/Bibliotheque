<!-- Import de taglib pour pouvoir itérer -->
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
	<h2>Liste des livres</h2>
	
	<table>
		<tr>
			<td>ID du livre</td>
			<td>Titre</td>
			<td>Année d'édition</td>
			<td>Editeur</td>
			<td>Prénom de l'auteur</td>
			<td>Nom de l'auteur</td>
		</tr>
		<c:forEach items="${livres}" var="l">
			<tr>
				<td>${l.idLivre}</td>
				<td>${l.titre}</td>
				<td>${l.anneeEdition}</td>
				<td>${l.editeur}</td>
				<td>${l.prenomAuteur}</td>
				<td>${l.nomAuteur}</td>
			</tr>
		</c:forEach>
	</table>
	
	<div class = "liens">
		<a href="/bibliotheque">Retour au menu principal</a> 
		<a href="/livre">Ajouter un livre</a>
		<a href="/emprunt">Gestion des emprunts</a>
	</div>
</body>
</html>