<%@ page language="java" contentType="text/html; ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Tulokset</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
</head>
<body>
	<h1>Frisbeegolf Tulokset</h1>
	<p><a href="/lisaa-uusitulos">Lis‰‰ Tulos</a></p>
	<p>N‰ytet‰‰n Frisbeegolf tuloksia. Koska, miss‰ heitetty ja tuulen nopeuden.</p>
	<table class="table table_striped" >
		<tr>
			<th>Tulos ID</th>
			<th>P‰iv‰</th>
			<th>Rata</th>
			<th>Tuuli</th>
			<th>Tulos</th>
			<th>&nbsp;</th>
		</tr>
		<%-- t‰m‰ on jsp-komentti  --%>
		<%-- ${asiakkaat} viittaa keyword-arvolla request-olion Map-tietorakenteessa olevaan asiakaslistaan(ArrayList) --%>
		<c:forEach items="${tulokset}" var="tulos">
			
			<tr>
				<td><c:out value="${tulos.id}" /></td>  <%-- lyhennysmerkint‰ metodikutsulle ${asiakas.getAsiakastunnus()} --%>
				<td><c:out value="${tulos.paiva}" /></td> 
				<td><c:out value="${tulos.rata}" /></td> 
				<td><c:out value="${tulos.tuuli}" /></td>
				<td><c:out value="${tulos.tulos}" /></td>  
				<td><a href="/poista-tulos?id=<c:out value='${tulos.id}'/>">Poista</a></td> <%-- asiakaskohtainen poisto-linkki --%>
				<td><a href="/muuta?id=<c:out value='${tulos.id}'/>">Muokka</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>