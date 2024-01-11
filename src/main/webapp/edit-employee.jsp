<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${EMPLOYEE_EXISTING_DATA} 

<form action="update" method="post">
ID<input type="text" name ="eid1" value="${EMPLOYEE_EXISTING_DATA.id} " readonly="readonly"><br></br>
FName<input type="text" name ="efname1" value="${EMPLOYEE_EXISTING_DATA.fname} "><br></br>
LName<input type="text" name ="elname1" value="${EMPLOYEE_EXISTING_DATA.lname} "><br></br>
Email<input type="text" name ="email1" value="${EMPLOYEE_EXISTING_DATA.email} "><br></br>
Phone<input type="text" name ="epass1" value="${EMPLOYEE_EXISTING_DATA.pass} "><br></br>
<input type="Submit" value="Update">
</form>
</body>
</html>