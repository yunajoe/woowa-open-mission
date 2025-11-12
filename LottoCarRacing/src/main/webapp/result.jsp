<%@page import="java.util.Map"%>
<%@page import="model.RankCar"%>
<%@page import="java.util.List"%>
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
    Map<RankCar, List<List<Integer>>> lottoResults = (Map<RankCar, List<List<Integer>>>) request
    		.getAttribute("lottoResults");

    if (lottoResults == null || lottoResults.isEmpty()) {
    %>
    <h2 class="result-title">결과가 없습니다.</h2>
    
    <%
       return; 
    }

    for (Map.Entry<RankCar, List<List<Integer>>> entry : lottoResults.entrySet()) {
        RankCar car = entry.getKey();
        String name = car.getName();
        int rank = car.getRanking();
       List<List<Integer>> numbersList = entry.getValue();
    %>
    
    <h3 class="rank">
         <%= rank %> 등 - <%= name %>
    </h3>
    <%
       for (int i = 0; i < numbersList.size(); i++) {
    	List<Integer> set = numbersList.get(i);
    %>
    <div class="set-container">
       <p class="set"> 세트  <%=(i + 1)%> : <%=set%> </p>   
    </div>
    <%
       }
     }
    %>
  </div>
</body>
</html>