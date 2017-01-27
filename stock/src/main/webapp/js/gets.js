function displaybill() {
	var url = "/stock/Product?operation=getParent";
	$.ajax({
		url : url,
		type : 'POST'
	}) 
	.done(
		function(result) {
			var array = JSON.parse(result);
			var qry = "<select class='select1'>"
			if(result!="undefined"){
				for (var i = 0; i < array.length;i++) {
					qry += "<option value="+ array[i].prodid +">" + array[i].prodname+ "</option>";
					
					
				}
			}
			qry += "</select>"
				$(".add")[1].innerHTML =qry;
			$(document).on("click", ".select1", function() {
				var prodids = $(this).val();
			var url = "/stock/Product?operation=gets&prodid=" + prodids;
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
				query += "<input type=\"text\" id=\"prodnames\" placeholder=\"ParentProductName\" class=\"pname\">";
			query +=  "<input type=\"submit\" id=\"parent\" class=\"psub\">";
			$(".add")[0].innerHTML =query;
			});
			 $(document).on("click","#parent",function(key) {
				    //var prodid = $(this).val();
				    var prodname = $('#prodnames').val();
				    if (prodname === "") {
				      alert("Please Enter ParentProductName");
				      $("#prodnames").focus().css("outline-color", "#ff0000");
				      return;
				    }
				   
				   var url = "/stock/Product?operation=productAdd&prodName=" + prodname + "&parentid="+ prodids;
				   $.ajax({
				     url: url,
				     type: 'POST'
				   }).done(function(result) {
				     result =JSON.parse(result);
				     if(result.status == 1) {
				       alert("SuccessFully Added");
				       $('#prodnames').val("");
				       
				       
				     } else if(result.status == 0) {
				       alert("Error occurs");
				     }

				   }).fail(function(result) {
				    alert("Please Check Details!..")
				  });
				 })
			
		}).fail(function() {
	});
})
}
