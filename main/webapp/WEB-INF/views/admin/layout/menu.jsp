<%@ page  pageEncoding="utf-8"%>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/home/index">WebSiteName</a>
    </div>
    <ul class="nav navbar-nav">
     
        <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Quan Ly
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="/admin/customer/index">Quản Lý Khách Hàng</a></li>
          <li><a href="/admin/product/index">Quản Lý Sản Phẩm</a></li>
          <li><a href="/admin/category/index">Quản Lý Các Loại Sản Phẩm</a></li>
           
        </ul>
      </li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Thong ke
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="/admin/inventory/index">Tồn kho theo loại</a></li>
          <li><a href="/admin/inventory/category">Doanh số theo loại</a></li>
          <li><a href="/admin/inventory/customer">Doanh số theo khách hàng</a></li>
           <li><a href="/admin/inventory/year">Doanh số theo năm</a></li>
             <li><a href="/admin/inventory/month">Doanh số theo tháng</a></li>
        </ul>
      </li>
      <li><a href="/home/feedback">Tai Khoan</a></li>
    
    </ul>
  </div>
</nav>