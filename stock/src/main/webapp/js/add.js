$(document).ready(function(){
	getAll();
	$(document).on("click","#add",function(){
	var cId=$('#cId').val();
	var cName=$('#cName').val();
	var address=$('#address').val();
	var tinNo=$('#tinNo').val();
	var prop=$('#prop').val();
	if(cId==""){
	alert("please enter your companyId");
	return;
	}
	if(cName==""){
	alert("please enter your companyName");
	return;
	}
	if(address==""){
	alert("please enter your  address");
	return;
	}
	if(tinNo==""){
	alert("please enter your tinno");
	return;
	}
	if(prop==""){
	alert("please enter proprictor");
	}
	var url="http://localhost:8080/stock/stock?operation=addStock&companyId="+cId+"&companyName="+cName+"&address="+address+"&tinNo="+tinNo+"&proprietor="+prop;
		$('input[type=text]').val();
		$.ajax({
			url:url,
			type:'post'
		})
		.done(function(result){
			getAll();
		
			if(result.status=="1"){
				alert("Successfully Added");
			}
		})
		.fail(function(result){
			alert("Error Occurs");
		});


	});

	$(document).on("click","#update",function(){
	var cId=$('#cId').val();
	var cName=$('#cName').val();
	var address=$('#address').val();
	var tinNo=$('#tinNo').val();
	var prop=$('#prop').val();
	if(cId==""){
	alert("please enter your id");
	return;
	}
	if(cName==""){
	alert("please enter your companyname");
	return;
	}
	if(address==""){
	alert("please enter your address");
	return;
	}
	if(tinNo==""){
	alert("please enter your tinno");
	return;
	}
	if(prop==""){
	alert("pleasen enter your proprictor");
	return;
	}
	var url="http://localhost:8080/stock/stock?operation=updateStock&companyId="+cId+"&companyName="+cName+"&address="+address+"&tinNo="+tinNo+"&proprietor="+prop;
	$.ajax({
	url:url,
	type:'post'
	})
	.done(function(result){
	alert("Updated successfully");
	})
	.fail(function(result){
	alert("Error Occurs");
	});
	});
	$(document).on('keyup','#cId',function(){
	var cId=$('#cId').val();
	if(cId!=""){
	var url="http://localhost:8080/stock/stock?operation=getStock&companyId="+cId;
	$.ajax({
	url:url,
	type:'post'
	})
	.done(function(result){
	result=JSON.parse(result);
	$("#cName").val(result.cname);
	$("#address").val(result.address);
	$("#tinNo").val(result.tinno);
	$("#prop").val(result.proprictor);
	});
	}
	});
	
	function getAll(){
		
	var url="http://localhost:8080/stock/stock?operation=getAllstock";
	$.ajax({
	url:url,
	type:'post'
	})
	.done(function(result){
			var array=JSON.parse(result);
			var table="<table border=2px>"
				table+="<tr><th>CompanyId</th><th>CompanyName</th><th>Address</th><th>Tinno</th><th>Proprictor</th></tr>";
			for(i=0;i<array.length;i++){
				table+="<tr>";
				table+="<td>"+array[i].companyId+"</td>";
				table+="<td>"+array[i].companyName+"</td>";
				table+="<td>"+array[i].address+"</td>";
				table+="<td>"+array[i].tinNo+"</td>";
				table+="<td>"+array[i].proprietor+"</td>";
				table+="</tr>";
			}
			table+="</table>";
			$(".getAll")[0].innerHTML=table;
		});
	
}
});
	