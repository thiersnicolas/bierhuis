<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri="http://vdab.be/tags"%>
<!doctype html>
<html>
<head>
<v:head title="Brouwers" />
</head>
<body>
	<v:menu />
	<h1>Brouwers</h1>
	<c:forEach items='${brouwers}' var='brouwer'>
		<li>${brouwer.naam}(${brouwer.adres.gemeente})</li>
	</c:forEach>
</body>
</html>