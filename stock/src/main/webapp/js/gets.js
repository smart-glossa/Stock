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
					query += "<option class="+ array[i].prodid +">" + array[i].prodname+ "</option>";
					//query += "<option>" + array[i].prodname+ "</option>";
					
									}
			}
			query += "</select>"
			$(".add")[0].innerHTML =query;

		}).fail(function() {

		});

	}
