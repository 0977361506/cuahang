<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<h2> Custommer Table</h2>

<table class="table table-hover">
  <thead>
     <tr>
      <th> id</th>
      <th> FullName</th>
      <th>email</th>
      <th>activated</th>
       <th>admin</th>
        <th></th>
     </tr>
  </thead>
  <tbody>
  <c:forEach var="e" items="${list}">
  <tr>
   <td>${e.id}</td>
   <td>${e.fullname}</td>
   <td>${e.email}</td>
    <td>${e.activated?'yes':'no'}</td>
     <td>${e.admin?'yes':'no'}</td>
   <td> <a class="btn btn-sm btn-info" href="/admin/customer/edit/${e.id}">Edit</a>
      <a class="btn btn-sm btn-info" href="/admin/customer/delete/${e.id}">Delete</a>
   </td>
    
   </tr>
   </c:forEach>
  </tbody>
</table>