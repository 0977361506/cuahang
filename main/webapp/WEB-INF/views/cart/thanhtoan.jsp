<%@ page pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h2> Danh Sach San Pham Trong Gio Hang</h2>
<table class="table">
    <thead class="thead-light">
      <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Unit Price</th>
        <th>DisCount</th>
        <th>Quantity</th>   
        <th>Amount</th>
        <th>Amount</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="p" items="${sessionScope['scopedTarget.cartService'].items}">
      <tr >
      
        <td>${p.id}</td>
        <td>${p.name}</td>
        <td>${p.unitPrice}</td>
        <td>${p.discount}</td>
        <td>${p.quantity}</td>
        <td>${p.quantity*p.unitPrice}</td>
   
      </tr>
     </c:forEach>
    </tbody>
  </table>
  <h2>Hoa don Thanh Toan</h2>
  
<form:form action="/thanhtoan/order"  modelAttribute="order" >
<p>${thanhtoan}</p>
<h2></h2>
<div class="form-group">
  <label>Custommer</label>
  <form:input  path="customer.id" class="form-control" />
</div>
<div class="form-group">
  <label>OrderDate</label>
  <form:input  path="orderDate"  class="form-control" />
</div>
<div class="form-group">
  <label>Address</label>
  <form:input  path="address"  class="form-control" />
</div>
<div class="form-group">
  <label>Amout</label>
  <form:input  path="omount"  class="form-control" />
</div>
<div class="form-group">
  <label>Notes</label>
  <form:textarea  path="description"  class="form-control" />
</div>
<div class="form-group">
   <button class="btn btn-sm btn-success">
          Thanh Toan
         </button>
</div>
</form:form>