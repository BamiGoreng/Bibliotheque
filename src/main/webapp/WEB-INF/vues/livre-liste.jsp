<!-- Import de taglib pour pouvoir itérer -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Voyages :: Japon</title>
</head>
<body>
	<h1>Bibliothèque</h1>
	<h2>Ajouter un livre :</h2>
	<ul>
		<!-- 	iteration avec le taglib -->
		<c:forEach items="${livres}" var="d">
			<li>${d.titre}
			: ${d.anneeEdition}
			: ${d.editeur}
			: ${d.prenomAuteur}
			: ${d.nomAuteur}</li>
		</c:forEach>
	</ul>
	<p>
		<a href="/inde">Retour à la page d'accueil</a>
	</p>
</body>
</html>