<%@ page language="java" contentType="text/html; charset=windows-1255"
	pageEncoding="windows-1255"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1255">
<link type="text/css" rel="stylesheet" href="cssFiles/style.css">
<title>Long Numbers Addition</title>
</head>
<body>

	<div id="header">
		<h2>Long Numbers Addition</h2>
	</div>

	<div id="container">
		<form action="LongNumbersArithmeticControllerServlet" method="GET">
			<input type="hidden" name="command" value="ADD">

			<table>
				<tbody>
					<tr>
						<td><label>First Long Number</label>
						<td><input type="number" name="firstNumber" required /></td>
					</tr>

					<tr>
						<td><label>Second Long Number</label>
						<td><input type="number" name="secondNumber" required /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="calculate" id="submitButton" /></td>
					</tr>

					<tr>
						<td><label>Result:</label></td>
						<td>${RESULT}</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>

</body>
</html>