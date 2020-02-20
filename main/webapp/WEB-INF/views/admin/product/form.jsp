<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h2>ProductForm</h2>
<h2> ${message} ${param.message}</h2>
<form:form action="/admin/product/index" modelAttribute="entity" enctype="multipart/form-data">
<div class="row">

 <div class="form-group col-sm-6">
  <label>Id</label>
  <form:input path="id"  class="form-control" />
</div>

 <div class="form-group col-sm-6">
  <label>full name</label>
  <form:input path="name"  class="form-control" />
</div>
 </div>



<div class="row">

 <div class="form-group col-sm-6">
  <label>unitPrice</label>
  <form:input path="unitPrice"  class="form-control" />
</div>

 <div class="form-group col-sm-6">
  <label>productDate</label>
  <form:input path="productDate"  class="form-control" />
</div>
 </div>
 
 <div class="row">

 <div class="form-group col-sm-4">
  <label>quantity</label>
  <form:input path="quantity"  class="form-control" />
</div>

 <div class="form-group col-sm-4">
  <label>discount</label>
  <form:input path="discount"  class="form-control" />
</div>
<div class="form-group col-sm-4">
  <label>viewcount</label>
  <form:input path="viewcount"  class="form-control" />
</div>
 </div>


<div class="row">

 <div class="form-group col-sm-6">
  <label>available</label>
  <div class="form-control">
    <form:radiobutton path="available"  value="true" label="available"/>
  <form:radiobutton path="available"  value="false" label="Unavailable"/>
</div>
</div>

 <div class="form-group col-sm-6">
  <label>special</label>
  <div class="form-control">
   <form:radiobutton path="special"  value="true" label="yes"/>
   <form:radiobutton path="special"  value="false" label="no"/>
   </div>
</div>
 </div>
 
 
<div class="form-group">
  <label>image</label>
  <input type="file" name="image_file" class="form-control">
  
  <form:hidden path="image"   />
</div>
<div class="form-group">
  <label>description</label>
  <form:input path="image"  class="form-control"  />
</div>


<div class="form-group">
   <button class="btn btn-sm btn-success" formaction="/admin/product/create">
        Create
         </button>
            <button class="btn btn-sm btn-primary" formaction="/admin/product/update">
        Update
         </button>
            <button class="btn btn-sm btn-danger" formaction="/admin/product/delete">
        delete
         </button>
         
            <a class="btn btn-sm btn-success" href="/admin/product/index">Reset</a>
     
</div>
</form:form>