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
  <div class="container">
    <h1 class="title">자동차 경주 결과</h1>
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
        List<Car> cars = (List<Car>) session.getAttribute("carRacingResults");
        List<String> topRanks = (List<String>) session.getAttribute("topRanksCars");
      %>
      <%
      if (cars != null && !cars.isEmpty()) {
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
          } else {
        %>
        <tr>
          <td colspan="6" style="text-align: center;">결과 데이터가 없습니다.</td>
        </tr>
       <%
           }
       %>
    </table>
    <div class="top-rank-section">
       <h3>🏁 1~3등 자동차</h3>
         <%
            if (topRanks != null && !topRanks.isEmpty()) {
         %>
          <ul>
              <% for (String carName : topRanks) { %>
                  <li><%= carName %></li>
              <% } %>
          </ul>
          <%
              } else {
          %>
           <p>맞춘 자동차가 없습니다.</p>
            <%
                }
            %>
     </div>     
    <form action="<%=request.getContextPath()%>/lotto" method="post" class="form">
      <div class="lotto-container">
        <h3 class="lotto-title">당첨 번호 입력</h3>
        <p class="info">1~45 사이의 숫자를 각각 입력해주세요</p>
        <div class="lotto-input-box-container">
          <input name="num1" /> <input name="num2" /> <input name="num3" /> <input name="num4" /> <input name="num5" />
          <input name="num6" />
        </div>
      </div>
      <div class="lotto-container">
        <h3 class="lotto-title">보너스 번호 입력</h3>
        <p class="info">1~45 사이의 숫자를 각각 입력해주세요</p>
        <input name="bonusNum" />
      </div>
      <button class="button">로또 결과 확인</button>
    </form>
  </div>
</body>
</html>