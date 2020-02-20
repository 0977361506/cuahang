<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="/account/register" method="post" modelAttribute="form" enctype="multipart/form-data">
<h2></h2>
<div class="form-group">
  <label>Ten tai khoan</label>
  <form:input  path="id" class="form-control" />
<s:message code="NotEmpty.form.id"></s:message>
</div>
<div class="form-group">
  <label>Mat khau</label>
  <form:input  path="password"  class="form-control" />
    <form:errors path="password"></form:errors>
</div>
<div class="form-group">
  <label>email</label>
  <form:input  path="email"  class="form-control" />
    <form:errors path="email"></form:errors>
</div>
<div class="form-group">
  <label>Fullname</label>
  <form:input  path="fullname"  class="form-control" />
    <form:errors path="fullname"></form:errors>
</div>
<div class="form-group">
  <label>Photo</label>
  <input type="file" name="photo_file">
  <form:hidden  path="photo"  class="form-control" />
</div>
<div class="form-group">
   <button class="btn btn-danger" >submit</button>
</div>
</form:form>