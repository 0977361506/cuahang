<%@ page  pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
      <tr data-id="${p.id}" data-price="${p.unitPrice}" data-discount="${p.discount}">
      
        <td>${p.id}</td>
        <td>${p.name}</td>
        <td>${p.unitPrice}</td>
        <td>${p.discount}</td>
        <td><input value="${p.quantity}" type="number" min="1" style="width=60px"/></td>
        <td>${p.quantity*p.unitPrice}</td>
         <td><button class="btn btn-sm btn-success btn-cart-remove">
         <span class="glyphicon glyphicon-trash"></span>
         </button></td>
      </tr>
     </c:forEach>
    </tbody>
  </table>
        <a href="/cart/clear" class="ab"><button type="button" class="btn btn-primary" aria-label="Right Align">
								<span class="glyphicon glyphicon-arrow-right"></span> Clear
							</button></a>
         <button class="btn btn-sm btn-info">
         Continue Shopping
         </button>
         <button class="btn btn-sm btn-success">
         <a href="/thanhtoan/order"> Thanh Toan</a>
         </button>