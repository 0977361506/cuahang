<%@ page pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<c:set var="cart" value="${sessionScope['scopedTarget.cartService']}"></c:set>
<div class="panel panel-default">
	<div class="panel-heading"><s:message code="lay.cart.vip"></s:message></div>
	<div class="panel-body">
	<img id="cart-img" src="/static/ảnh mạng/shoppingcart.png"class="col-sm-5">
	<ul class="col-sm-5">
	<li><b id="cart1">${cart.count}</b>mặt hàng</li>
	<li><b id="cart2">${cart.amount}</b>VNĐ</li>
	<li>
	<a href="/cart/view">Xưm Giỏ Hàng</a>
	</li>
	</ul>
	</div>
</div>
<div class="panel panel-default">
	<div class="panel-heading">search</div>
	<div class="pane-body">
	<form action="/timkiem/sanpham" method="post" >
	<input name="keyword" class="form-control">
	<br/>
	<button class="btn btn-sm btn-success">tim kiem</button>
	</form>
	</div>
</div>
<div class="panel panel-default">
	<div class="panel-heading"><s:message code="lay.cart.title"></s:message></div>
	<div class="list-group">
	<c:set value="${pageContext.response.locale.language}" var="lang"></c:set>
	<c:forEach var="c" items="${vip}">
		<a href="/Product/list/${c.id}" class="list-group-item ">${(lang=='vi')?c.name:c.nameVN}</a> 
	</c:forEach>
	</div>
</div>
<div class="panel panel-default">
	<div class="panel-heading">hang dac biet</div>
	<div class="list-group">
		<a href="/product/db/0" class="list-group-item ">Hàng Mới</a>
		 <a href="/product/db/1"  class="list-group-item">Hàng Bán Chạy</a>
		 <a href="/product/db/2"  class="list-group-item">SẢn Phẩm Xem Nhiều</a>
		 <a href="/product/db/3"  class="list-group-item">SẢn Phẩm Giảm Giá</a>
		 <a href="/product/favo" class="list-group-item">Danh Sách Mặt Hàng Bạn Đã Xem</a>
	</div>
</div>
<style id="cart_css"></style>