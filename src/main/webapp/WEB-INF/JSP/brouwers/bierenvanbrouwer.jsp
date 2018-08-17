<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri="http://vdab.be/tags"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!doctype html>
<html>
<head>
<v:head title="Bieren van brouwer" />
</head>

<body>
	<v:menu />
	<h1>${brouwer.naam} (${brouwer.adres.gemeente})</h1>
	<ul class="zonderbolletjes">
		<c:forEach items='${brouwer.bieren}' var='bier'>
			<spring:url value="/bieren/{id}" var="url">
				<spring:param name="id" value="${bier.id}"/>
			</spring:url>
			<li><a class="linkuitgeschakeld" href="${url}">${bier.naam}</a></li>
		</c:forEach>
	</ul>
</body>
</html>