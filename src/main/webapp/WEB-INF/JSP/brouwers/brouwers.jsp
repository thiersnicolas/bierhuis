<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri="http://vdab.be/tags"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!doctype html>
<html>
<head>
<v:head title="Brouwers" />
</head>

<body>
	<v:menu />
	<h1>Brouwers</h1>
	<ul class="zonderbolletjes">
		<c:forEach items='${brouwers}' var='brouwer'>
			<spring:url value="/bieren/{id}" var="url">
				<spring:param name="id" value="${brouwer.id}"/>
			</spring:url>
			<li><a class="linkuitgeschakeld" href="${url}">${brouwer.naam} (${brouwer.adres.gemeente})</a></li>
		</c:forEach>
	</ul>
</body>
</html>