<%@ include file="include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title><fmt:message key="title"/></title>
	<style type="text/css">
		.error{ color: red;}
	</style>
	<script type="text/javascript">
		function changeBehavior() {
			window.location.href = "newUser.htm";
		}
	</script>
	</head>
<body>
	<h3><fmt:message key="login"></fmt:message></h3>
	<form:form method="post" commandName="startUserSession" modelAttribute="startUserSession" >
		<table width="50%" bgcolor="white" border="0" cellpadding="3" cellspacing="0">
			<tr>
				<td width="17%">
					<fmt:message key="user"/>
				</td>
				<td width="30%">
					<form:input path="userName" size="20" maxlength="30"/>
				</td>
				<td>
					<form:errors path="userName" cssClass="error"></form:errors>
				</td>
			</tr>
			<tr>
				<td>
					<fmt:message key="password"/>
				</td>
				<td>
					<form:password path="password" size="20" maxlength="30"/>
				</td>
				<td>
					<form:errors path="password" cssClass="error"></form:errors>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td align="left" colspan="2">
					<input type="submit" align="middle" value="<fmt:message key="button.sing"/>" style="width: 90px">
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td align="left" colspan="2">
					<input type="submit" align="middle" value="<fmt:message key="button.new-user"/>" 
						onclick="changeBehavior();return false;" style="width: 90px">
				</td>
			</tr>
		</table>
		<br>
	</form:form>
</body>
</html>