<%@ page  pageEncoding="utf-8"%>

<form>
<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Send to Friends</h4>
      </div>
      <div class="modal-body">
       
       <div class="form-group">
           <label>
            sender name
           </label>
           <input id="sender" class="form-control">
       </div>
       <div class="form-group">
           <label>
             Recipient Name
           </label>
           <input id="email" class="form-control">
       </div>
        <div class="form-group">
           <label>
            Comments
           </label>
           <textarea id="comments" class="form-control" rows="3"></textarea>
       </div>
       <input type="hidden" id="id">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-default btn-sent" >Send</button>
      </div>
    </div>

  </div>
</div>
</form>