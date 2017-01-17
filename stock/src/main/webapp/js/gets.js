function displaybill() {
	var url = "/arun/bill?operation=getall";
	var imgURL = "img/1.jpg";
	$.ajax({
		url : url,
		type : 'POST'
	})
	.done(
		function(result) {
			var array = JSON.parse(result);
			var query = "<select border= '2px solid black'>"
			//query += "<tr><th>BillNo</th> <th>SalesAmount</th><th>PaidAmount</th><th>PrincipleAmount</th><th>CreaditAmount</th><th>ShortageAmount</th><th>Excess</th><th>Date</th><th>Delete</th></tr>"
			if(result!="undefined"){
				for (var i = 0; i < array.length; i++) {
					//query += "<tr class='productRow'><td class='billno'>"
					//+ array[i].billNO + "</td>";
					query += "<option>" + array[i].sales + "</option>";
					query += "<option>" + array[i].paid + "</option>";
					query += "<option>" + array[i].prin + "</option>";
					query += "<option>" + array[i].credit + "</option>";
					query += "<option>" + array[i].shortage + "</option>";
					query += "<option>" + array[i].Excess + "</option>";
					query += "<option>" + array[i].date + "</option>";
					query += "<option> <img class='delete' src='" + imgURL + "' width='25px' height='25px'/></option>"
				}
			}
			query += "</select>"
			$(".myDIV1")[0].innerHTML =query;

		}).fail(function() {

		});

	}
