<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<style>
body {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    background-color: #f5f5f5;
}

form {
    border: 1px solid #ddd;
    padding: 20px;
    border-radius: 8px;
    background: #fff;
}

h2 {
    text-align: center;
    margin-bottom: 20px;
}

table {
    width: 100%;
}

table th {
    text-align: left;
    padding: 10px;
    color: #555;
}

table td {
    padding: 10px;
}

input[type="text"],
input[type="email"] {
    width: 100%;
    padding: 5px;
    border: 1px solid #ddd;
    border-radius: 5px;
}

input[type="submit"] {
    width: 100%;
    padding: 10px;
    border: 0;
    background: #6c757d;
    color: #fff;
    border-radius: 5px;
    cursor: pointer;
}

input[type="submit"]:hover {
    background: #5a8e2c;
}
</style>
</head>
<body>
	<form action="" method="post">
	<h2>아이디 찾기</h2>
		<table>
			<tr>
				<th>이름</th>
				<td>
					<input type="text" name="userName" required>
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>
					<input type="email" name="email" required>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="아이디 찾기">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>