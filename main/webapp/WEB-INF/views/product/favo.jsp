<%@ page pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="row gunny">
<h1 class="text-success text-center">Danh Sách SẢn Phẩm Bạn Đã Xem</h1>
<c:forEach var="c" items="${favo}">
  <div class = "col-sm-7 text-center ">
    <img  src="/static/ảnh mạng/${c.image}" width="65%" height="250px">
  </div>
  <div class ="col-sm-5">
   <ul class="list-group">
  <li class="list-group-item list-group-item-success">Tên sản phẩm :${c.name}</li>
  <li class="list-group-item list-group-item-info">giá sản phẩm : <fmt:formatNumber value="${c.unitPrice}" pattern="#,###.00" />VNĐ </li>
  <li class="list-group-item list-group-item-warning"> giảm giá sản phẩm : <fmt:formatNumber value="${c.discount}" type="percent" /></li>
  <li class="list-group-item list-group-item-danger">số lượt xem : ${c.viewcount}</li>
   <li class="list-group-item list-group-item-danger">Loại hàng đặc biệt : ${c.special?'Yes':'No'}</li>
   <li class="list-group-item list-group-item-danger">ngày sản xuất : <fmt:formatDate value="${c.productDate}" pattern="dd-MM-yyyy"/></li>
    </ul>
  </div>
  </c:forEach>
</div>