<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h2>Category Form</h2>
<h2> ${message} ${param.message}</h2>
<form:form action="/admin/category/index" modelAttribute="entity">
<div class="form-group">
  <label>id</label>
  <form:input path="id"  class="form-control" />
</div>
<div class="form-group">
  <label>name</label>
  <form:input path="name"  class="form-control" />
</div>
<div class="form-group">
  <label>nameVN</label>
  <form:input path="nameVN"  class="form-control" />
</div>

<div class="form-group">
   <button class="btn btn-sm btn-success" formaction="/admin/category/create">
        Create
         </button>
            <button class="btn btn-sm btn-primary" formaction="/admin/category/update">
        Update
         </button>
            <button class="btn btn-sm btn-danger" formaction="/admin/category/delete">
        delete
         </button>
         
            <a class="btn btn-sm btn-success" href="/admin/category/index">Reset</a>
     
</div>
</form:form>