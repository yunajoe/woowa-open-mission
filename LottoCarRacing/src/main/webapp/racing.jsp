<%@page import="model.RankCar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.util.*, model.Car"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/reset.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/racing.css">
<title>레이싱 결과입니다.</title>
</head>
<body>
  <%
  List<Car> cars = (List<Car>) session.getAttribute("carRacingResults");
  List<RankCar> topRanks = (List<RankCar>) session.getAttribute("rankCars");
  %>
  
  <div class="container">
    <h1 class="title">자동차 경주 결과</h1>
    <%
    if (cars == null || cars.isEmpty()) {
    %>
    <h2 class="result-title">자동차 경주 결과 데이터가 없습니다.</h2>
    <%
    }
    %>
    <%
    if (cars != null && !cars.isEmpty()) {
    %>
    <table class="table">
      <tr>
        <th>자동차 이름</th>
        <th>전진 횟수</th>
        <th>후진 횟수</th>
        <th>정지 횟수</th>
        <th>최종 점수</th>
        <th>순위</th>
      </tr>
      <%
      for (int i = 0; i < cars.size(); i++) {
      	Car car = cars.get(i);
      %>
      <tr>
        <td><%=car.getName()%></td>
        <td><%=car.getForward()%></td>
        <td><%=car.getBackward()%></td>
        <td><%=car.getStop()%></td>
        <td><%=car.getFinalScore()%></td>
        <td><%=(i + 1)%></td>
      </tr>
      <%
      }
      %>
    </table>
    <%
    }
    %>
    <div class="result-container">
      <h3 class="result-title">맞춘 자동차</h3>
      <%
      if (topRanks == null || topRanks.isEmpty()) {
      %>
      <h2 class="result-title">맞춘 자동차가 없습니다.</h2>
      <%
      }
      %>
      <%
      if (topRanks != null && !topRanks.isEmpty()) {
      %>
      <ul class="rank-container">
        <%
        for (RankCar rankCar : topRanks) {
        %>
        <li>순위 <%=rankCar.getRanking()%> : <%=rankCar.getName()%></li>
        <%
        }
        %>
      </ul>
      <form action="<%=request.getContextPath()%>/lotto" method="post" class="form">
        <div class="lotto-container">
          <h3 class="lotto-title">당첨 번호 입력</h3>
          <p class="info">1~45 사이의 숫자를 각각 입력해주세요</p>
          <div class="lotto-input-box-container">
            <input name="num1" /> <input name="num2" /> <input name="num3" /> <input name="num4" /> <input
              name="num5"
            /> <input name="num6" />
          </div>
        </div>
        <div class="lotto-container">
          <h3 class="lotto-title">보너스 번호 입력</h3>
          <p class="info">당첨 번호와 중복되지 않는 1~45 사이의 숫자</p>
          <input name="bonusNum" />
        </div>
        <button class="button">로또 결과 확인</button>
      </form>
      <%
      }
      %>
    </div>
  </div>
</body>
</html>