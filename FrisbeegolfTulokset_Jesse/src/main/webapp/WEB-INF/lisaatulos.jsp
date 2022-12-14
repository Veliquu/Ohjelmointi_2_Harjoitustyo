<%@ page language="java" contentType="text/html; ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Lis‰‰ Tulos</title>
<style type="text/css">
label {
	display: block;
	width: 8em;
	float: left;
}
</style>
</head>
<body>
	<h1>Lis‰‰ Tulos</h1>
	<form action="/lisaa-uusitulos" method="post">

		<p>
			<label>P‰iv‰ (yyyy-MM-dd):</label> <input type="text" value="" name="paiva"size="50" />
		</p>
		<p>
			<label>Rata:</label> <input type="text" value="" name="rata" size="50" />
		</p>
		<p>
			<label>Tuuli:</label> <input type="text" value="" name="tuuli" size="50" />
		</p>
		<p>
			<label>Tulos:</label> <input type="text" value="" name="tulos" size="50" />
		</p>
		<p>
		<span class="button"><a href="/" >Peruuta</a></span>
		<input type="submit" name="submit-button" class="btn btn-success" value="Tallenna" />
		</p>
	</form>
</body>
</html>