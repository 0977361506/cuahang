<%@ page  pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/home/index"><s:message code="lay.alo.home"></s:message></a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="/home/about">About Us</a></li>
      <li><a href="/home/contact">Contact Us</a></li>
      <li><a href="/home/feedback">Feedback</a></li>
      <li><a href="/home/faq">FAQs</a></li>
       <li><a href="/cart/viewd">Mat Hang Da Mua</a></li>
       <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Menu
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="/account/login">Dang nhap</a></li>
          <li><a href="/account/register">Dang ki</a></li>
          <li><a href="/account/logoff">Dang xuat</a></li>
        </ul>
      </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#" data-lang="vi">Tiếng Việt</a></li>
      <li><a href="#" data-lang="en">English</a></li>
    </ul>
  </div>
</nav>
<div class="row dangcap">
<div class="col col-sm-7">
<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner">
    <div class="item active text-center">
      <img src="/static/ảnh mạng/vipp.png" alt="Los Angeles">
    </div>

    <div class="item text-center">
      <img src="/static/ảnh mạng/vipp1.png" alt="Chicago">
    </div>

    <div class="item text-center">
      <img src="/static/ảnh mạng/vipp2.png" alt="New York">
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
</div>
<div class="col col-sm-5">

   <div>
      <img src="/static/ảnh mạng/vipp3.png" alt="Chicago">
    </div>
</div>
<div class="col col-sm-5">

   <div>
      <img src="/static/ảnh mạng/vipp4.png" alt="Chicago">
    </div>
</div>
<div class="col col-sm-5">

   <div>
      <img src="/static/ảnh mạng/vipp5.png" alt="Chicago">
    </div>
</div>

</div>
<script>

$(function(){
  $('a[data-lang]').click(function(){
	  var lang = $(this).attr("data-lang");
	  $.ajax({
		  url:'/home/language?lang='+lang,
	  success:function(){
		  location.reload();
	  }
	  });
  })
})
</script>