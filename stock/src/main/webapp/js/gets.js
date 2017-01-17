function displaybill() {
	var url = "/stock/Product?operation=getParent";
		$.ajax({
		url : url,
		type : 'POST'
	}) //http://localhost:8080/stock/Product?operation=getParent
	.done(
		function(result) {
			var array = JSON.parse(result);
			var query = "<select>"
					if(result!="undefined"){
				for (var i = 0; i < array.length; i++) {
					query += "<option class='ss',"+ array[i].prodid +">" + array[i].prodname+ "</option>";
					//query += "<option>" + array[i].prodname+ "</option>";
					
									}
			}
			query += "</select>"
			$(".add")[0].innerHTML =query;

		}).fail(function() {

		});

	}
$(document).ready(function() {
	 $(document).on("click", ".ss", function() {
			// If user not confirmed, then dont execute, just return back.
		// if (!confirm(" Delete Are you sure?")) {
		  // return;
	//	}
		var tag = $(this).parent().parent();
		var billno = tag.children(".parid")[0].innerHTML;
		var url = "/arun/bill?operation=delete&abillno=" + billno;
		$.ajax({
		    url: url,
		    type: 'POST'
		}).done(function(result) {
		   tag.remove();
		}).fail(function(result) {
		    console.log(result)
		});
		});
})