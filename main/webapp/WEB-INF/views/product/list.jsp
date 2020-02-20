<%@ page pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:forEach var="p" items="${cate}">
  <div class="col-md-4">
    <div class="thumbnail">
      <a href="/product/detail/${p.id}" width="192px" height="180px">
        <img class ="estore" src="/static/ảnh mạng/${p.image}">
         </a>
        <div class="caption">
         <div class="pull-right" data-id="${p.id}">
        <button class="btn btn-sm btn-danger  "><i class="glyphicon glyphicon-shopping-cart btn-cartt-ip "></i></button>
        <button class="btn btn-sm btn-success btn-star"><i class="glyphicon glyphicon-star-empty"></i></button>
        <button class="btn btn-sm btn-info btn-open" data-toggle="modal" data-target="#myModal"><i class="glyphicon glyphicon-envelope"></i></button>
        </div>
         <p>${p.name}</p>
          <p>${p.unitPrice}</p>
        </div>
       
    </div>
  </div>
</c:forEach>
<jsp:include page="dialog.jsp"/>