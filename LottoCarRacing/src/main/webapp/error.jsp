<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>오류 발생</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/reset.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/error.css">
</head>
<body>
    <div class="error-container">
        <h1>문제가 발생했습니다</h1>
        <p class="message"><%= exception != null ? exception.getMessage() : "알 수 없는 오류입니다." %></p>
        <a class="home-btn" href="<%=request.getContextPath()%>/index.jsp">홈으로 돌아가기</a>
    </div>
</body>
</html>
