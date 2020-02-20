<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Admin</title>
   <tiles:insertAttribute name="head" />
 
</head>
<body>

<div class="container">
  <header class="row">
  <h1>Admin Mannager</h1>
  </header>
  
  <tiles:insertAttribute name="menu" />
 
  <div class="row">
  <tiles:insertAttribute name="body" />
  </div>
  <footer class="row">
  <p>hello kiittty </p>
  </footer>
</div>

</body>
</html>