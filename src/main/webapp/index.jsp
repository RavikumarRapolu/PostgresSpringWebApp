<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
</head>
<body>
<h1 class="error">HEllo Ravi</h1>
</body>
<div align="center">
<h2 style="color:red;">Login</h2>
<table>
<form:form action="/ravi/user/login" command="userModel">
	<tr><td align="left" width="20%">Email:</td>
	<td align="left"><form:input path="email" size="30"/></td>
	<td align="left"><form:errors path="email" cssClass="error"/></td>
	</tr>
	<tr>
	<td align="left" width="20%">Password:</td>
	<td align="left"><form:input path="password" size="30"/></td>
	<td align="left"><form:errors path="password" cssClass="error"/></td>
	</tr>
	<tr>
	<td></td>
	<td align="center"><input type="submit" value="Login"/></td>
	<td></td>
	</tr>
</form:form>

</table>
</div>
</body>
<script type="text/javascript">
.error{
	color:red;font-weight: bold;
}
</script>
</html>