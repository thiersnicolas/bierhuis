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
	<h1>Winkelwagen</h1>
	<table>
		<thead>
			<tr>
				<th scope="col">Bier</th>
				<th scope="col">Prijs</th>
				<th scope="col">Aantal</th>
				<th scope="col">Te betalen</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${bestelbon.bestelbonlijnen}" var="bestelbonlijn">
				<tr>
					<td>${bestelbonlijn.bier.naam}</td>
					<td class="rechts"><spring:eval expression='bestelbonlijn.bier.prijs'/></td>
					<td class="rechts"><spring:eval expression='bestelbonlijn.aantal'/></td>
					<td class="rechts"><spring:eval expression='bestelbonlijn.waarde'/></td>
				</tr>
			</c:forEach>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td><b>Totaal: <spring:eval expression='bestelbon.waarde'/></b></td>
			</tr>
		</tbody>
	</table>
	<spring:url value="/winkelmand" var="url">
	</spring:url>
	<form:form action="${url}" modelAttribute="bestelbon" method='post'>
		<dl>
			<dt>
				<form:label path="naam">
					<b>Naam</b>
					<form:errors path="naam" />
				</form:label>
			</dt>
			<dd class="attribuut">
				<form:input path="naam" />
			</dd>

			<dt>
				<form:label path="adres.straat">
					<b>Straat</b>
					<form:errors path="adres.straat" />
				</form:label>
			</dt>
			<dd class="attribuut">
				<form:input path="adres.straat" />
			</dd>
		</dl>

		<dt>
			<form:label path="adres.huisNr">
				<b>Huisnummer</b>
				<form:errors path="adres.huisNr" />
			</form:label>
		</dt>
		<dd class="attribuut">
			<form:input path="adres.huisNr" />
		</dd>

		<dt>
			<form:label path="adres.postcode">
				<b>Postcode</b>
				<form:errors path="adres.postcode" />
			</form:label>
		</dt>
		<dd class="attribuut">
			<form:input path="adres.postcode" />
		</dd>

		<dt>
			<form:label path="adres.gemeente">
				<b>Gemeente</b>
				<form:errors path="adres.gemeente" />
			</form:label>
		</dt>
		<dd class="attribuut">
			<form:input path="adres.gemeente" />
		</dd>

		<input type="submit" value="Als bestelbon toevoegen">


	</form:form>
</body>
</html>