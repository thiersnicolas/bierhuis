<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri="http://vdab.be/tags"%>
<!doctype html>
<html>
<head>
<v:head title="Bierhuis" />
</head>
<body>
	<v:menu />
	<h1>Welkom in het huis van de Belgische bieren</h1>
	<img alt='Bierhuis' src='<c:url value="/images/bierhuis.jpg"/>'>
	<p>We hebben momenteel ${aantalBieren} bieren</p>
</body>
</html>