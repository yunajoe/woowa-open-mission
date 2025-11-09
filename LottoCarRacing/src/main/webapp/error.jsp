<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>오류 발생</title>
</head>
<body>
    <h1>죄송합니다. 오류가 발생했습니다.</h1>
    <p>오류 메시지: <%= exception.getMessage() %></p> <!-- 예외 메시지 출력 -->
    <a href="index.jsp">홈으로 돌아가기</a>
</body>
</html>
