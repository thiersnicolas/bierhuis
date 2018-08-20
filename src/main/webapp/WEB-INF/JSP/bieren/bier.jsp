<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri="http://vdab.be/tags"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<!doctype html>
<html>
<head>
<v:head title="Bieren van brouwer" />
</head>

<body>
	<v:menu />
	<h1>${bier.naam}</h1>
	<dl>
		<dt>
			<b>Alcohol</b>
		</dt>
		<dd class="attribuut"><spring:eval expression='bestelbonlijn.bier.alcohol'/> &#37;</dd>

		<dt>
			<b>Prijs</b>
		</dt>
		<dd class="attribuut"><spring:eval expression='bestelbonlijn.bier.prijs'/> &euro;</dd>

		<dt>
			<b>Soort</b>
		</dt>
		<dd class="attribuut">${bestelbonlijn.bier.soort.naam}</dd>

		<dt>
			<b>Brouwer</b>
		</dt>
		<dd class="attribuut">${bestelbonlijn.bier.brouwer.naam}</dd>
	</dl>

	<spring:url value="/bieren" var="url">
	</spring:url>
	<form:form action="${url}" modelAttribute="bestelbonlijn" method='post'>
		<dl>
			<dt>
				<form:label path="aantal">
					<b>Aantal</b>
					<form:errors path="aantal"/>
				</form:label>
			</dt>
			<dd class="attribuut">
				<form:input path="aantal" autofocus='autofocus'/>
			</dd>
		</dl>
		
		<input type="submit" value="Toevoegen">
		
		
	</form:form>
</body>
</html>