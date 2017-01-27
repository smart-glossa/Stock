function displaybill() {
	var url = "/stock/Product?operation=getParent";
	$.ajax({
		url : url,
		type : 'POST'
	}) 
	.done(
		function(result) {
			var array = JSON.parse(result);
			var query = "<select class='ss'>"
			if(result!="undefined"){
				for (var i = 0; i < array.length;i++) {
					query += "<option value="+ array[i].prodid +" class='prodid'>" + array[i].prodname+ "</option>";
					
					
				}
			}
			query += "</select>"
				$(".adds")[0].innerHTML =query;
			$(document).on("click", ".ss", function() {
				var prodid = $(this).val();
			var url = "/stock/Product?operation=gets&prodid=" + prodid;
			$.ajax({
				url: url,
				type: 'POST'
			}).done(function(result) {
				
				var array = JSON.parse(result);
				var query = "<select class='sele2'>"
				query += "<tr><th>ParentProductName</th></tr>"
				if(result!="undefined"){
					for (var i = 0; i < array.length; i++) {
						query += "<option>" + array[i].prodname + "</option>";
						
					}
				}
				query += "</select>"
				query += "<input type=\"text\" id=\"prodname\" placeholder=\"ParentProductName\" class=\"pname\">";
			query +=  "<input type=\"submit\" id=\"parent\" class=\"psub\">";
			$(".add")[0].innerHTML =query;

		}).fail(function() {

		});

	});
})
}
/*	$(document).ready(function() {
		$(document).on("click", ".ss", function() {
			var prodid = $(this).val();
			var url = "/stock/Product?operation=gets&prodid=" + prodid;
			$.ajax({
				url: url,
				type: 'POST'
			}).done(function(result) {
				
				var array = JSON.parse(result);
				var query = "<select class='sele2'>"
				query += "<tr><th>ParentProductName</th></tr>"
				if(result!="undefined"){
					for (var i = 0; i < array.length; i++) {
						query += "<option>" + array[i].prodname + "</option>";
						
					}
				}
				query += "</select>"
				//	query += "<input type=\"text\" id=\"prodname\" placeholder=\"ParentProductName\" class=\"pname\">";
					//query +=  "<input type=\"submit\" id=\"parent\" class=\"psub\">";
					$(".adds")[0].innerHTML =query;

				}).fail(function(result) {
					console.log(result)
				});
			});
	})*/