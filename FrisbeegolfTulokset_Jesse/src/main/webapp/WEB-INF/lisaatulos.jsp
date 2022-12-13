<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Lisää Tulos</title>
<style type="text/css">
label {
	display: block;
	width: 8em;
	float: left;
}
</style>
</head>
<body>
	<h1>Lisää Tulos</h1>
	<form action="/lisaa-uusitulos" method="post">

		<p>
			<label>Päivä (yyyy-MM-dd):</label> <input type="text" value="" name="paiva"size="50" />
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