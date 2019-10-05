<%@ page language="java" contentType="text/html; charset=windows-1255"
	pageEncoding="windows-1255"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1255">
<link type="text/css" rel="stylesheet" href="cssFiles/style.css">
<title>Long Numbers Multiplication</title>
</head>
<body>

	<div id="header">
		<h2>Long Numbers Multiplication</h2>
	</div>

	<div id="container">
		<form action="LongNumbersArithmeticControllerServlet" method="GET">
			<input type="hidden" name="command" value="MULTIPLY">

			<table>
				<tbody>
					<tr>
						<td><label>First Long Number</label>
						<td><input type="number" name="firstNumber" /></td>
					</tr>

					<tr>
						<td><label>Second Long Number</label>
						<td><input type="number" name="secondNumber" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="calculate" /></td>
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