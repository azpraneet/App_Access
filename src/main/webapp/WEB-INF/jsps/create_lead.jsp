<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="saveLead" method="post">
    <pre>
        firstName: <input type="text" name="firstname" /><br>
        lastName: <input type="text" name="lastname" /><br>
        email: <input type="text" name="email" /><br>
        mobile: <input type="text" name="mobile" /><br>
        <input type="submit" value="Save" />
    </pre>
</form>
	${msg}
</body>
</html>