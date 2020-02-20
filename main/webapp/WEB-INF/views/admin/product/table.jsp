<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<h2> Custommer Table</h2>

<table class="table table-hover">
  <thead>
     <tr>
      <th> id</th>
      <th> tên sản phẩm</th>
      <th>giá</th>
      <th>ngày sản xuất</th>
       <th>sản phẩm được giảm giá ?</th>
       <th>miêu tả sản phẩm </th>
       <th>số lượng xem</th>
       <th>số lượng sản phẩm</th>
        <th>special?</th>
        <th></th>
     </tr>
  </thead>
  <tbody>
  <c:forEach var="e" items="${list}">
  <tr>
   <td>${e.id}</td>
   <td>${e.name}</td>
   <td>${e.unitPrice}</td>
    <td>${e.productDate}</td>
    <td>${e.available?'yes':'no'}</td>
     <td>${e.description}</td>
    <td>${e.viewcount}</td>
    <td>${e.quantity}</td>
     <td>${e.special?'yes':'no'}</td>
   <td> <a class="btn btn-sm btn-info" href="/admin/product/edit/${e.id}">Edit</a>
      <a class="btn btn-sm btn-info" href="/admin/product/delete/${e.id}">Delete</a>
   </td>
    
   </tr>
   </c:forEach>
  </tbody>
</table>