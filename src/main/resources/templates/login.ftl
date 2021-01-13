<!DOCTYPE HTML>
<html xmlns:th="https://www.thymeleaf.org">
<head>
    <title>Getting Started: Handling Form Submission</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<h1>Form</h1>
<form action="#" th:action="@{/user/login}" th:object="${user}" method="post">
    <p>login: <input type="text" th:field="*{login}" /></p>
    <p>password: <input type="text" th:field="*{password}" /></p>
    <p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>
</form>
</body>
</html>