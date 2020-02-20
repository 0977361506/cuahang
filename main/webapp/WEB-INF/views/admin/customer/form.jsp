<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h2>CustomerForm</h2>
<h2> ${message} ${param.message}</h2>
<form:form action="/admin/customer/index" modelAttribute="entity" enctype="multipart/form-data">
<div class="row">

 <div class="form-group col-sm-6">
  <label>Id</label>
  <form:input path="id"  class="form-control" />
</div>

 <div class="form-group col-sm-6">
  <label>full name</label>
  <form:input path="fullname"  class="form-control" />
</div>
 </div>



<div class="row">

 <div class="form-group col-sm-6">
  <label>password</label>
  <form:input path="password"  class="form-control" />
</div>

 <div class="form-group col-sm-6">
  <label>email</label>
  <form:input path="email"  class="form-control" />
</div>
 </div>
 


<div class="row">

 <div class="form-group col-sm-6">
  <label>admin</label>
  <div class="form-control">
    <form:radiobutton path="admin"  value="true" label="admin"/>
  <form:radiobutton path="admin"  value="false" label="user"/>
</div>
</div>

 <div class="form-group col-sm-6">
  <label>activated</label>
  <div class="form-control">
   <form:radiobutton path="activated"  value="true" label="yes"/>
   <form:radiobutton path="activated"  value="false" label="no"/>
   </div>
</div>
 </div>
 
 
<div class="form-group">
  <label>photo</label>
  <input type="file" name="photo_file" class="form-control">
  
  <form:hidden path="photo"   />
</div>

<div class="form-group">
   <button class="btn btn-sm btn-success" formaction="/admin/customer/create">
        Create
         </button>
            <button class="btn btn-sm btn-primary" formaction="/admin/customer/update">
        Update
         </button>
            <button class="btn btn-sm btn-danger" formaction="/admin/customer/delete">
        delete
         </button>
         
            <a class="btn btn-sm btn-success" href="/admin/customer/index">Reset</a>
     
</div>
</form:form>