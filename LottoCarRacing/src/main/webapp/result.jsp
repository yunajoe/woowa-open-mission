<%@page import="java.util.List"%>
<%@page import="model.RankCar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/reset.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/result.css">
<title>로또 결과</title>
</head>
<body>
  <div class="container">
    <h1 class="title">로또 결과</h1>

    <%
      List<RankCar> rankCars = (List<RankCar>) request.getAttribute("rankCars");
      if (rankCars == null || rankCars.isEmpty()) {
    %>
        <h2 class="result-title">결과가 없습니다.</h2>
    <%
      } else {
        for (RankCar car : rankCars) {
          String name = car.getName();
          int carRank = car.getRanking();
          List<List<Integer>> lottoNumbers = car.getLottoNumber();
          List<Integer> lottoRanking = car.getLottoRanking();
    %>
        <h3 class="rank"><%= carRank %> 등 - <%= name %></h3>
        <%
          for (int i = 0; i < lottoNumbers.size(); i++) {
            List<Integer> lottoSet = lottoNumbers.get(i);
            Integer rankValue = lottoRanking.get(i);
        %>
            <div class="set-container">
                <p >세트 <%= (i + 1) %> : <%= lottoSet %></p>
                <p><%= rankValue == 0 ? "탈락" : "등수: " + rankValue %></p>
            </div>
        <%
          }
        %>
    <%
        }
      }
    %>
  </div>
</body>
</html>
