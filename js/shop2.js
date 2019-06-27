var cart = [];
var name1 = [];
var price = [];
var number = [];
var idp=[];
$("#staplesbmincart").load();
$(document).ready(function() {
	if (localStorage.cart) {
		//cart = JSON.parse(localStorage.cart);
		// showCart1();
		//showPrice();
		localStorage.clear();
	}
	$(".top_googles_cart").css("visibility", "hidden");
	$(".top_googles_cart1").css("visibility", "hidden");
	$("td[name=name]").each(function() {
		name1.push($(this).text());
		

	});
	$(".price").each(function() {
		price.push($(this).val());

	});
	$(".number").each(function() {
		number.push($(this).text());

	});
	$(".id").each(function() {
		idp.push($(this).val());

	});
	
});

function deleteItem(index) {
	cart.splice(index, 1); // delete item at index
	showPrice();
	saveCart();
	$.ajax({
		type : "GET",
		url : "/Web_Project/remove",
		data : {
			"id" : index
		},
		success : function(data) {
			alert("cccc");
		}
	});

}

function saveCart() {
	if (window.localStorage) {
		localStorage.cart = JSON.stringify(cart);
	}
}
function showCart() {
	var total = Number(0);
	$("#staplesbmincart").css("visibility", "visible");
	if (cart.length == 0) {
		var empty = "";
		$("form[name*='form']").addClass("sbmincart-empty");
		$(".body").css("visibility", "hidden");
		$(".sbmincart-footer")
				.html(
						"<p class='sbmincart-empty-text'>Your shopping cart is empty</p>");
		return;
	}

	$("form[name*='form']").removeClass("sbmincart-empty");
	$(".body").empty();
	$(".body").css("visibility", "visible");
	for ( var i in cart) {
		var item = cart[i];
		total = total + item.Price * item.Qty;
		var row = "<li class='sbmincart-item'>"
				+ "<div class='sbmincart-details-name'>"
				+ "<a class='sbmincart-name' href='file:///F:/IT/Java/Template/Web2/web/shop.html'>"
				+ item.Product
				+ "</a>"
				+ "<ul class='sbmincart-attributes'></ul>"
				+ "</div>"
				+ "<div class='sbmincart-details-quantity'>"
				+ "<input class='sbmincart-quantity' data-sbmincart-idx='"
				+ i
				+ "'  type='text' pattern='[0-9]*' value='"
				+ item.Qty
				+ "' autocomplete='off'>"
				+ "</div>"
				+ "<div class='sbmincart-details-remove'>"
				+ "<button type='button' class='sbmincart-remove'  onclick='deleteItem("
				+ i
				+ ")'>×</button>"
				+ "</div>"
				+ "<div class='sbmincart-details-price'>"
				+ "<span class='sbmincart-price'>"
				+ "$"
				+ item.Price
				+ "</span>" + "</div>" + "</li>";
		$(".body").append(row);
	}
	$(".sbmincart-footer")
			.html(
					"<div class='sbmincart-subtotal'>"
							+ "Subtotal:"
							+ "$"
							+ total
							+ " USD"
							+ "</div>"
							+ "<button class='sbmincart-submit' type='submit' data-sbmincart-alt='undefined'>Check Out</button>"
							+ "</div>	");
}

//function showCart1() {
//	if (cart.length == 0) {
//		$(".timetable_sub").css("visibility", "hidden");
//		$(".quantity").html("0 Product");
//		return;
//	}
//
//	$(".timetable_sub").css("visibility", "visible");
//	$(".cartBody").empty();
//	for ( var i in cart) {
//		var item = cart[i];
//		var index = Number(i) + 1;
//		var row = "<tr class='rem1'>" + "<td class='nvert'>" + index + "</td>"
//				+ "<td class='invert-image'>" + "<a href='single.html'>"
//				+ "<img src='" + item.Link
//				+ "' alt=' '' class='img-responsive'>" + "</a>" + "</td>"
//				+ "<td class='invert'>" + "<div class='quantity'>"
//				+ "<div class='quantity-select'>"
//				+ "<div class='entry value-minus'>&nbsp;</div>"
//				+ "<div class='entry value'>" + "<span>" + item.Qty + "</span>"
//				+ "</div>"
//				+ "<div class='entry value-plus active'>&nbsp;</div>"
//				+ "</div>" + "</div>" + "</td>" + "<td class='invert'>"
//				+ item.Product + "</td>" +
//
//				"<td class='invert'>$" + item.Price + "</td>"
//				+ "<td class='invert'>" + "<div class='rem'>" +
//
//				// "<button class='sbmincart-remove' value='" + i +
//				// "'>Delete</button>"+
//				"<div class='close1' onclick='deleteItem(" + i + ")'> </div>" +
//
//				"</div>" +
//
//				"</td>" + "</tr>";
//		$(".cartBody").append(row);
//	}
//	if (cart.length > 1) {
//		$(".quantity").html(cart.length + " Products");
//	} else if (cart.length == 1) {
//		$(".quantity").html(cart.length + " Product");
//	}
//}

$(function() {
	$(".top_googles_cart").on('click', function(e) {
		showCart();

	});
});

$(function() {
	$(".sbmincart-closer").on('click', function(e) {
		$("#staplesbmincart").css("visibility", "hidden");
	});
});

function showPrice() {
	var total = Number(0);
	$(".total").empty();
	$(".qty").empty();

	for (var i = 0; i < name1.length; i++) {
		total = total + Number(price[i])*Number(number[i]);
		var row = "<li>" + name1[i] + "<i>-</i>" + "<span>" + "$"
				+ price[i] + "</span>" + "</li>";
		$(".total").append(row);
	}
	var row1 = "<li>Total" + "<i>-</i>" + "<span>" + "$" + total + "</span>"
			+ "</li>";

	$(".total").append(row1);
	$(".qty").append(name1.length+ " Product");
	if (name1.length==0){
		$(".timetable_sub").fadeOut();
		$(".address_form").fadeOut();
	}

}

function deletePrice(i){
	name1.splice(i, 1);
	number.splice(i, 1);
	price.splice(i, 1);
	idp.splice(i, 1);
	showPrice();
}

function decreasePrice(i){
	number[i]=Number(number[i])-Number(1);
	showPrice();
}
function increasePrice(i){
	number[i]=Number(number[i])+Number(1);
	showPrice();
}

function remove(id) {
	var $x = 'rem' + id;
	var index;
	$("."+$x).fadeOut();
	$.ajax({
		type : "POST",
		url : "/Web_Project/remove",
		data : {
			"id" : id
		},
		success : function(data) {

		}
	});
	for (var i = 0; i < idp.length; i++) {
		if (idp[i]==id){
			index=i;
			
		}
	}
	
	deletePrice(index);

}
function decrease(id) {
	var $x = 'rem' + id;
	var index;
	for (var i = 0; i < idp.length; i++) {
		if (idp[i]==id){
			index=i;
			
		}
	}

	
	
	if (number[index]>1){
		$.ajax({
			type : "POST",
			url : "/Web_Project/decrease",
			data : {
				"id" : id
			},
			success : function(data) {

			}
		});
		decreasePrice(index);
	}else {
		remove(id);
	}
	

}
function increase(id) {
	var $x = 'rem' + id;
	var index;
	

	$.ajax({
		type : "POST",
		url : "/Web_Project/increase",
		data : {
			"id" : id
		},
		success : function(data) {

		}
	});
	for (var i = 0; i < idp.length; i++) {
		if (idp[i]==id){
			index=i;	
		}
	}
	
	increasePrice(index);

}
