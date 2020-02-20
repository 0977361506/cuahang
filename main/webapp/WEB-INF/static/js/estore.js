$(document).ready(function(){
	$(".btn-open").click(function(){
		  var id = 	$(this).closest("div").attr("data-id");
		  $("#myModal #id").val(id);
			
			});

	//code mail
	$(".btn-sent").click(function(){
		var form ={
		   id:$("#myModal #id").val(),
		   to:$("#myModal #email").val(),
		  body:$("#myModal #comments").val(),
		   from:$("#myModal #sender").val(),
		} 
		$.ajax({
			url:"/product/send-to-friend",
			data: form,
			success:function(response){
				if(response){
					$("[data-dismiss]").click();
					alert("da gui mail thanh cong")
				}
				else{
					alert("gui mail that bai")
				}
			}
		})
			});
			
	//
	$("tr[data-id] input").on("input",function(){
		 var id = 	$(this).closest("tr").attr("data-id");
		 var price = 	$(this).closest("tr").attr("data-price");
		 var discount = 	$(this).closest("tr").attr("data-discount");
		 var qty= $(this).val();
		 
		 $.ajax({
				url:`/cart/update/${id}/${qty}`,
				success:function(response){
					
	                $("#cart1").html(response[0]);
					
					$("#cart2").html(response[1]);
					
					
				}
			});
	});
	
	
	$(".btn-cart-remove").click(function(){
		  var id = 	$(this).closest("tr").attr("data-id");
		$.ajax({
			url:"/cart/remove/"+id,
			success:function(response){
				
                $("#cart1").html(response[0]);
				
				$("#cart2").html(response[1]);
				
				
			}
		});
		$(this).closest("tr").remove();
	});
	
	$(".btn-cartt-ip").click(function(){
		  var id = 	$(this).closest("div").attr("data-id");
			$.ajax({
				url:"/cart/add/"+id,
				success:function(response){
				$("#cart1").html(response[0]);
				
				$("#cart2").html(response[1]);	
				}
			});
			
	    
		var img= $(this).closest(".thumbnail").find("a>img");
		var options={to:'#cart-img',className:'cart-fly'}
		 var cart_css= '.cart-fly{ background-image: url("'+img.attr("src")+'");background-size: 100% 100%;';
		$("#cart_css").html(cart_css);
		img.effect('transfer',options,1000);
		});
	
	
	$(".btn-star").click(function(){
	  var id = 	$(this).closest("div").attr("data-id");
		$.ajax({
			url:"/product/addtoFavo/"+id,
			success:function(response){
				if(response== true){
					alert("da them thnah cong vao danh sach yeu thic")
				}
				else{
					alert("da co trong danh sach")
				}
			}
		});
	});
	
	
});