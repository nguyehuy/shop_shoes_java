var cart=[];
$("#staplesbmincart").load();
$(document).ready(function(){
	if(localStorage.cart){
		cart=JSON.parse(localStorage.cart);
	}
});


$(function () {
    $(".googles-cart").on('click', function (e) {
    	var $x=$(this).parent();
    	 var id=Number($x.find(".id").val());
    	 var qty=Number($x.find(".add").val());
        var price=Number($x.find(".amount").val());
        var name=$x.find(".googles_item").val();
        
        var link=$x.find(".link").val();

        for(var i in cart){
        	if (cart[i].Id==id){
        		cart[i].Qty=cart[i].Qty+qty;
        		cart[i].Price=cart[i].Price+price
			showCart();
			saveCart();
			return;
		}
	}

	var items={Id: id,Product: name, Price: price, Qty: qty, Link: link};
	cart.push(items);
	showCart();
	saveCart();
       
    });

});


$(function () {
    $(".sbmincart-remove").on('click',function (e) {

    	
    	var $x=$(this).attr("data-sbmincart-idx");
       
    });
});


 function deleteItem(index){
            cart.splice(index,1); // delete item at index
            showCart();
            saveCart();
            
        }

function saveCart(){
	if(window.localStorage){
		localStorage.cart=JSON.stringify(cart);
	}
}
function showCart(){
	var total=Number(0);
	$("#staplesbmincart").css("visibility", "visible");
	if(cart.length == 0){
		var empty="";
		 $("form[name*='form']").addClass("sbmincart-empty");
		$(".body").css("visibility", "hidden");
		$(".sbmincart-footer").html("<p class='sbmincart-empty-text'>Your shopping cart is empty</p>");
		return;
	}

	$("form[name*='form']").removeClass("sbmincart-empty");
	$(".body").empty();
	$(".body").css("visibility", "visible");
	for(var i in cart){
		var item=cart[i];
		total=total+item.Price*item.Qty;
		var row = "<li class='sbmincart-item'>"+ 
           "<div class='sbmincart-details-name'>"+
                "<a class='sbmincart-name' href='file:///F:/IT/Java/Template/Web2/web/shop.html'>"+item.Product+"</a>"+             
                "<ul class='sbmincart-attributes'></ul>"+
            "</div>"+      
             "<div class='sbmincart-details-quantity'>"+                
                "<input class='sbmincart-quantity' data-sbmincart-idx='"+i+"'  type='text' pattern='[0-9]*' value='"+item.Qty+"' autocomplete='off'>"+         
            "</div>"+          
            "<div class='sbmincart-details-remove'>"+                
            "<button type='button' class='sbmincart-remove'  onclick='deleteItem(" + i + ")'>×</button>"+             
            "</div>"+            
            "<div class='sbmincart-details-price'>"+                
                "<span class='sbmincart-price'>"+"$"+item.Price+"</span>"  +          
            "</div>"+            
            "</li>";
        $(".body").append(row);
	}
	$(".sbmincart-footer").html("<div class='sbmincart-subtotal'>"+ "Subtotal:"+ "$"+total+ " USD" +"</div>"+            
                    "<button class='sbmincart-submit' data-sbmincart-alt='undefined' onclick='order()'>Confirm</button>"+
				"</div>	");
}


$(function () {
    $(".top_googles_cart").on('click', function (e) {
    	showCart();

});
});


$(function () {
    $(".sbmincart-closer").on('click', function (e) {
    	$("#staplesbmincart").css("visibility", "hidden");
    	$(".body").css("visibility", "hidden");

});
});
function data(id){
	$.ajax({
	    type : "GET",
	    url : "/Web_Project/addtocart",
	    data : {
	    "id" : id
	    },
	    success: function(data){
	   
	    }
	});
}
function order(){
	var order=[];
	var price=[];
	var quantity=[]
	for(var i in cart){
		order[i]=cart[i].Id;
		price[i]=cart[i].Price;
		quantity[i]=cart[i].Qty;
	}
	$.ajax({
	    type : "POST",
	    url : "/Web_Project/addtocart",
	    data : {
	    order: order,
	    price: price,
	    quantity: quantity
	    },
	    success: function(data){
	    	window.location.href = '/Web_Project/checkout';
	    	//alert("cccc");
	    }
	});
	
	
	
}
