$(document).ready(function() {
  $(document).on("click","#comadd",function(key) {
    var comid = $('#comid').val();
    var cname = $('#comName').val();
    var tno = $('#tinNo').val();
    var prop=$('#prop').val();
    var addr=$('#addr').val();
    if (comid === "") {
    	alert("Please Enter CompanyId");
      $("#comid").focus().css("outline-color", "#ff0000");
      return;
    }
    if (cname === "") {
      alert("Please Enter CompanyName");
      $("#comName").focus().css("outline-color", "#ff0000");
      return;
    }
    if (tno === "") {
      alert("Please Enter TinNumber");
      $("#tinNo").focus().css("outline-color", "ff0000");
      return;
    }
    if (prop === "") {
      alert("Please Enter Proprietor ");
      $("#prop").focus().css("outline-color", "ff0000");
      return;
    }
    if(addr==""){
     alert("Please Enter Address");
     $('#addr').focus().css('outline-color','ff0000');
     return;
   }
   
   var url = "/stock/stock?operation=Adddetail&comid=" + comid + "&comName="+ cname + "&tinNo=" + tno + "&prop=" + prop +"&addr="+addr;
   $.ajax({
    url: url,
    type: 'POST'
  }).done(function(result) {
    result =JSON.parse(result);
    if(result.status == 1) {
      alert("SuccessFully Added");
      $('#comid').val("");
      $('#comName').val("");
      $('#tinNo').val("");
      $('#prop').val("");
      $('#addr').val("");
    } else if(result.status == 0) {
      alert("Error occurs");
    }

  }).fail(function(result) {
   alert("Please Check Details!..")
 });
})
  $(document).on("click","#comupdate",function(key) {
    var ucomid = $('#ucomid').val();
    var ucname = $('#ucomName').val();
    var utno = $('#utinNo').val();
    var uprop=$('#uprop').val();
    var uaddr=$('#uaddr').val();
    if (ucomid === "") {
    	alert("Please Enter CompanyId");
      $("#ucomid").focus().css("outline-color", "#ff0000");
      return;
    }
    if (ucname === "") {
      alert("Please Enter CompanyName");
      $("#ucomName").focus().css("outline-color", "#ff0000");
      return;
    }
    if (utno === "") {
      alert("Please Enter TinNumber");
      $("#utinNo").focus().css("outline-color", "ff0000");
      return;
    }
    if (uprop === "") {
      alert("Please Enter Proprietor ");
      $("#prop").focus().css("outline-color", "ff0000");
      return;
    }
    if(uaddr==""){
     alert("Please Enter Address");
     $('#uaddr').focus().css('outline-color','ff0000');
     return;
   }
   var url = "/stock/stock?operation=updatedetail&ucomid=" + ucomid + "&ucomName="+ ucname + "&utinNo=" + utno + "&uprop=" + uprop +"&uaddr="+uaddr;
   $.ajax({
     url: url,
     type: 'POST'
   }).done(function(result) {
     result =JSON.parse(result);
     if(result.status == 1) {
       alert("SuccessFully Added");
       $('#ucomid').val("");
       $('#ucomName').val("");
       $('#utinNo').val("");
       $('#uprop').val("");
       $('#uaddr').val("");
     } else if(result.status == 0) {
       alert("Error occurs");
     }

   }).fail(function(result) {
    alert("Please Check Details!..")
  });
 })
 $(document).on("keyup", "#ucomid", function() {
	    var cid = $('#ucomid').val();
	    if (cid != "") {
	        var getUrl = "/stock/stock?operation=getcompany&ucomid=" + cid;
	        $.ajax({
	            url: getUrl,
	            type: "POST"
	        })
	        .done(function(result) {
	            result = JSON.parse(result);
	            var cid = result.cid;
	            var cname = result.cname;
	            var tno=result.tno;
	            var prop=result.prop;
	            var addr=result.addr;
	                    //var date=result.date;
	                    $("#ucomid").val(cid);
	                    $("#ucomName").val(cname);
	                    $("#utinNo").val(tno);
	                    $("#uprop").val(prop);
	                    $("#uaddr").val(addr);
	                    
	                })
	        .fail(function(result) {
	            alert("Some Errors Please Enter correct value");
	        });
	    } else {
	        $("#ucomName").val("");
	        $("#utinNo").val("");
	        $("#uprop").val("");
	        $("#uaddr").val("");
	    }
	});
})
