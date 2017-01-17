function displaybill() {
	var url = "/stock/Product?operation=getParent";
		$.ajax({
		url : url,
		type : 'POST'
	}) //http://localhost:8080/stock/Product?operation=getParent
	.done(
		function(result) {
			var array = JSON.parse(result);
			var query = "<select class='ss'>"
					if(result!="undefined"){
				for (var i = 0; i < array.length; i++) {
					//query += "<option class='prodid'</option>"
					query += "<option value="+ array[i].prodid +" class='prodid'>" + array[i].prodname+ "</option>";
					//query += "<option>" + array[i].prodname+ "</option>";
					
									}
			}
			query += "</select>"
			$(".add")[0].innerHTML =query;

		}).fail(function() {

		});

	}
$(document).ready(function() {
	 $(document).on("dblclick", ".ss", function() {
		   var prodid = $('.prodid').val();
		//var tag = $(this).parent().parent();
		//var prodid = tag.children(".prodid")[0].innerHTML;
		//http://localhost:8080/stock/Product?operation=gets&prodid=1
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
					//	query += "<tr class='productRow'><td class='billno'>"
						//+ array[i].billNO + "</td>";
						query += "<option>" + array[i].prodname + "</option>";
						
					}
				}
				query += "</select>"
				$(".adds")[0].innerHTML =query;

		}).fail(function(result) {
		    console.log(result)
		});
		});
})