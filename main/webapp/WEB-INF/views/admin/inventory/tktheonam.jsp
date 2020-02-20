<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
<h2>Bảng thống kê theo năm</h2>

<table class="table table-hover">
  <thead>
     <tr>
      <th> CAtegory</th>
      <th> số lượng</th>
      <th> Giá trị</th>
      <th> Giá trị nhỏ nhất</th>
      <th> Giá trị lớn nhất</th>
      <th> Giá trị trung bình</th>
      
     </tr>
  </thead>
  <tbody>
  <c:forEach var="e" items="${data}">
  <tr>
   <td>${e[0]}</td>
   <td>${e[1]}</td>
  <td><f:formatNumber value="${e[2]}" pattern="#,###.00"/></td>
    <td><f:formatNumber value="${e[3]}" pattern="#,###.00"/></td>
    <td><f:formatNumber value="${e[4]}" pattern="#,###.00"/></td>
   <td><f:formatNumber value="${e[5]}" pattern="#,###.00"/></td>
  
    
   </tr>
   </c:forEach>
  </tbody>
</table>
<jsp:include page="chart.jsp"></jsp:include>