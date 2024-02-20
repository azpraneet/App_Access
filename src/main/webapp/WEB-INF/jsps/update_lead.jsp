<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update</title>
</head>
<body>
	<h2>Update Lead</h2>
<form action="editreg" method="post">
    <pre>
    	<input type="hidden" name="id" value="${lead.id }"/>
        firstName: <input type="text" name="firstname" value="${lead.firstname }" /><br>
        lastName: <input type="text" name="lastname" value="${lead.lastname }"/><br>
        email: <input type="text" name="email" value="${lead.email }"/><br>
        mobile: <input type="text" name="mobile" value="${lead.mobile }" /><br>
        <input type="submit" value="Update" />
    </pre>
</form>
	${msg}
</body>
</html>