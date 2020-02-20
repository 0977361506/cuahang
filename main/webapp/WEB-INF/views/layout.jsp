<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
   <tiles:insertAttribute name="head" />
 
</head>
<body>

<div class="container">
  <header class="row">
  <h1>ronaldo</h1>
  </header>
  
  <tiles:insertAttribute name="menu" />
 
  <div class="row">
  <article class="col-sm-9">
  <tiles:insertAttribute name="body" />
  </article>
  <aside class="col-sm-3">
  <tiles:insertAttribute name="aside" />
    </aside>
  </div>
  <footer class="row">
  <p>hello kiittty </p>
  </footer>
</div>

</body>
</html>