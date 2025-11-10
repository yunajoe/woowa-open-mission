<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/reset.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/index.css">
<title>자동차 경주 & 로또</title>
</head>
<body>
  <div class="container">
    <div class="title-container">
      <h1 class="title">자동차 경주 & 로또</h1>
      <p class="sub-title">레이싱에서 우승하고 로또에 도전하세요!</p>
    </div>
    <form action="<%=request.getContextPath()%>/car" method=post class="input-container">
      <div class="input-container">
        <label for="car-input">자동차 이름 입력 (쉼표로 구분)</label> <input id="car-input" name="carNames" />
      </div>
      <p class="info">* 2~100대, 이름 1~10자, 공백 불가, 중복 불가</p>
      <button type="submit" class="button">레이스 시작</button>
    </form>
  </div>
</body>
</html>
