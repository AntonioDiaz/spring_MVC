<%@ include file="include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title><fmt:message key="title"/></title>
	<style type="text/css">
		.error{color: red;}
	</style>
	</head>
<body>
	
	<form:form method="post" commandName="newUser" modelAttribute="newUser" >
		<table width="70%" bgcolor="white" border="0" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="2">
					<h3><fmt:message key="new-user-form.header"></fmt:message></h3>
				</td>
				<td>
					<a href="index.jsp"><fmt:message key="back"></fmt:message></a>
				</td>
			</tr>
			<tr>
				<td width="23%">
					<fmt:message key="new-user-form.name"/>
				</td>
				<td width="35%">
					<form:input path="name" size="30" maxlength="30"/>
				</td>
				<td>
					<form:errors path="name" cssClass="error"></form:errors>
				</td>
			</tr>
			<tr>
				<td>
					<fmt:message key="new-user-form.surname"/>
				</td>
				<td>
					<form:input path="surname" size="30" maxlength="30"/>
				</td>
				<td>
					<form:errors path="surname" cssClass="error"></form:errors>
				</td>
			</tr>
			<tr>
				<td>
					<fmt:message key="new-user-form.email"/>
				</td>
				<td>
					<form:input path="email" size="30" maxlength="50"/>
				</td>
				<td>
					<form:errors path="email" cssClass="error"></form:errors>
				</td>
			</tr>			
			<tr>
				<td>
					<fmt:message key="new-user-form.username"/>
				</td>
				<td>
					<form:input path="userName" size="30" maxlength="30"/>
				</td>
				<td>
					<form:errors path="userName" cssClass="error"></form:errors>
				</td>
			</tr>			
			<tr>
				<td>
					<fmt:message key="new-user-form.password"/>
				</td>
				<td>
					<form:password path="password" size="30" maxlength="30"/>
				</td>
				<td>
					<form:errors path="password" cssClass="error"></form:errors>
				</td>
			</tr>			
			<tr>
				<td>
					<fmt:message key="new-user-form.repeat-password"/>
				</td>
				<td>
					<form:password path="repeatPassword" size="30" maxlength="30"/>
				</td>
				<td>
					<form:errors path="repeatPassword" cssClass="error"></form:errors>
				</td>
			</tr>			
			<tr>
				<td>&nbsp;</td>
				<td align="right">
					<input type="submit" align="middle" value="<fmt:message key="button.create"/>">
				</td>
			</tr>
		</table>
		<br>
	</form:form>
</body>
</html>