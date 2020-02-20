<%@ page pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 <div id="fb-root"></div>
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v5.0"></script>
<div class="row gunny">
  <div class = "col-sm-7 text-center ">
    <img  src="/static/ảnh mạng/${pro.image}" width="100%" height="350px">
  </div>
  <div class ="col-sm-5">
   <ul class="list-group">
  <li class="list-group-item list-group-item-success">Tên sản phẩm :${pro.name}</li>
  <li class="list-group-item list-group-item-info">giá sản phẩm : <fmt:formatNumber value="${pro.unitPrice}" pattern="#,###.00" />VNĐ </li>
  <li class="list-group-item list-group-item-warning"> giảm giá sản phẩm : <fmt:formatNumber value="${pro.discount}" type="percent" /></li>
  <li class="list-group-item list-group-item-danger">số lượt xem : ${pro.viewcount}</li>
   <li class="list-group-item list-group-item-danger">Loại hàng đặc biệt : ${pro.special?'Yes':'No'}</li>
   <li class="list-group-item list-group-item-danger">ngày sản xuất : <fmt:formatDate value="${pro.productDate}" pattern="dd-MM-yyyy"/></li>
    </ul>
  </div>
</div>

<div class="jumbotron">
    mieu ta san pham : ${pro.description}
 </div>
  <div class="jumbotron">
             <div class="fb-comments" data-href="http://localhost:8080/product/detail/${c.id}" data-width="730" data-numposts="5"></div>
            </div>
<div class="row">
<ul class="nav nav-tabs">
  <li class="active"><a data-toggle="tab" href="#home">Sản Phẩm Cùng Loại</a></li>
  <li><a data-toggle="tab" href="#menu1">Danh Sách Sản Phẩm Đã Xem</a></li>
</ul>

<div class="tab-content">
  <div id="home" class="tab-pane fade in active">
    <c:forEach var="c" items="${pro1}">
  <div class="col-md-4">
 <a href="/product/detail/${c.id}" width="192px" height="180px">
    <img class="estore1" src="/static/ảnh mạng/${c.image}"  width="150px" height="180px">
  </a>
   </div>
  </c:forEach>
  </div>
  <div id="menu1" class="tab-pane fade">
    <c:forEach var="c" items="${views}">
  <div class="col-md-4">
 <a href="/product/detail/${c.id}" width="192px" height="180px">
    <img class="estore1" src="/static/ảnh mạng/${c.image}"  width="150px" height="180px">
  </a>
   </div>
  </c:forEach>
  </div>
</div>
 </div>
 