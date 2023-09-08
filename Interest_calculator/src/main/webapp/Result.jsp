<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Interest Calculator</title>
<link rel="stylesheet" href="anji3.css">
</head>
<body>
<jsp:include page="Home_Interest.html"/>
<c:set var="data" value="${requestScope.data}"/>
<c:set var="type" value="${requestScope.calculator_type}"/>
<c:set var="decimal" value="${requestScope.decimal}"/>

<c:choose>
<c:when test="${type eq 'simpleinterest' }"><h3><c:out value="SIMPLE INTEREST"></c:out></h3>
</c:when>
<c:otherwise><h3><c:out value="COMPOUND INTEREST"/></h3></c:otherwise>
</c:choose>
<div id="div1" class="center">
<div>
<h4>Details</h4>
<label>Starting Date</label>
<c:out value="${requestScope.sdate }"/><br>
<label>Ending Date</label>
<c:out value="${requestScope.edate}"/><br>
<c:if test="${data.getYear()!=0 }"><c:out value="${data.getYear()}"></c:out> Year's,</c:if>
<c:if test="${data.getMonths()!=0 }"><c:out value="${data.getMonths()}"></c:out> Months's,</c:if>
<c:if test="${data.getDays()!=0 }"><c:out value="${data.getDays()}"></c:out> Day's</c:if>
<br>
Principal <c:out value="${requestScope.Principal}"/><br>
Rate of interest <c:out value="${requestScope.interest_rate }"/>
<c:out value="${requestScope.rate_type}"/>
<br>
</div>
<div>
<h4>Interest</h4>
<label>Interest </label><c:out value="${decimal.format(Double.valueOf(data.getSi()))}"/><br>
<c:out value="${decimal.format(Double.valueOf(data.getYearly())) }" /> Per Year<br>
<c:out value="${decimal.format(Double.valueOf(data.getMonthly())) }"/> Per  Month<br>
<c:out value="${decimal.format(Double.valueOf(data.getDays1()))}"/> Per  Day<br>
<label>Total Amount </label><c:out value="${decimal.format(Double.valueOf(data.getTotal_amount()))}"/>
</div>
</div>
</body>
</html>