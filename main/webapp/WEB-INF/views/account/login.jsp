<%@ page  pageEncoding="utf-8"%>
<form action="/account/login" method="post">
<h2>${error}</h2>
<div class="form-group">
  <label>Ten tai khoan</label>
  <input  name="id" class="form-control" >
</div>
<div class="form-group">
  <label>Mat khau</label>
  <input  name="pw"  class="form-control" >
</div>
<div class="form-group">
 <div class="form-control">
  <input type="checkbox" name="rm" >
  <label>Remember PassWord </label>
 </div>
  
</div>
<div class="form-group">
   <button class="btn btn-sm btn-success">
        Dang Nhap
         </button>
</div>
</form>