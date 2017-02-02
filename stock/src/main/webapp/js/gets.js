var prodid;
var prodid2;

function productdislay() {
    var url = "/stock/Product?operation=getParent";
    $.ajax({
            url: url,
            type: 'POST'
        })
        .done(
            function(result) {
                var array = JSON.parse(result);
                var qry = "<div class='productsname' >"

                if (result != "undefined") {
                    for (var i = 0; i < array.length; i++) {
                        qry += "<p class=" + array[i].prodid + " class='prodid' id='datas'>" + array[i].prodname + "</p>";
                    }
                }
                qry += "</div>"
                $(".prod").append(qry);
            }).fail(function(result) {
            alert(result);
        });
}

$(document).on('click','#datas',function() {
            prodid = $('.prodid').val();
            prod = $($(this)[0]).text();
        var prodid2 = $(this).val();
        var url = "/stock/Product?operation=gets&prodid=" + prodid2;
        $.ajax({
            url: url,
            type: 'POST'
        }).done(function(result) {
            var response = JSON.parse(result);
            var columns = response.columnName;
            if ($(".third").length > 0) {
                $(".third").remove();
            }
            var table = "<div class=third><h3>" + tableName + " </h3><table>";
            for (var i = 0; i < columns.length; i++) {
                table += "<th class=\"green\">" + columns[i] + "</th>"
            }
            table += "</div>"
            var rowCount = response.keys.length;
            for (var i = 0; i < rowCount; i++) {
                var row = response['r' + i];
                table += "<tr class=row>"
                for (var j = 0; j < columns.length; j++) {
                    table += "<td class=td>" + row[j] + "</td>"
                }
                table += "</tr>";
            }
            $("#table").append(table);
        }).fail(function(result) {
        })
    });

/*
function displaybill() {
    var url = "/stock/Product?operation=getParent";
    $.ajax({
            url: url,
            type: 'POST'
        })
        .done(
            function(result) {
                var array = JSON.parse(result);
                var qry = "<select class='select1'>"

                if (result != "undefined") {
                    for (var i = 0; i < array.length; i++) {
                        qry += "<option value=" + array[i].prodid + " class='prodid'>" + array[i].prodname + "</option>";
                    }
                }
                qry += "</select>"
                $(".add").append(qry);
            })
        .fail(function(result) {
            alert(result);
        });
}

$(document).on("change", ".select1", function() {
    $(this).find("option:selected").each(function() {
        prodid = $(this).val();
        var url = "/stock/Product?operation=gets&prodid=" + prodid;
        $.ajax({
            url: url,
            type: 'POST'
        }).done(function(result) {

            var array = JSON.parse(result);
            var query = "<select class='select2'>"
            query += "<tr><th>ParentProductName</th></tr>"
            if (result != "undefined") {
                for (var i = 0; i < array.length; i++) {
                    query += "<option value=" + array[i].prodid + " class='prodid'>" + array[i].prodname + "</option>";

                }
            }
            query += "</select>"
            if (!$('#prodname1').length) {
                query += "<input type=\"text\" id=\"prodname1\" placeholder=\"ParentProductName\" class=\"pname\">";
                query += "<input type=\"submit\" id=\"parent1\" class=\"psub\">";
            }

            var aa = $(".select2");
            if (aa.length) {
                aa.remove();
            }
            $(".add").append(query);


        }).fail(function() {});
    });
});
$(document).on("change", ".select2", function() {
    $(this).find("option:selected").each(function() {
        var prodid2 = $(this).val();
        var url = "/stock/Product?operation=gets&prodid=" + prodid2;
        $.ajax({
            url: url,
            type: 'POST'
        }).done(function(result) {

            var array = JSON.parse(result);
            var query = "<select class='select3'>"
            query += "<tr><th>ParentProductName</th></tr>"
            if (result != "undefined") {
                for (var i = 0; i < array.length; i++) {
                    query += "<option value=" + array[i].prodid + " class='prodid'>" + array[i].prodname + "</option>";

                }
            }
            query += "</select>"
            query += "<input type=\"text\" id=\"prodname2\" placeholder=\"ParentProductName\" class=\"pname\">";
            query += "<input type=\"submit\" id=\"parent2\" class=\"psub\">";
            $(".add").append(query);


        }).fail(function() {});
    });
});*/
$(document).on("click", "#parent1", function(key) {
    var prodname = $('#prodname1').val();
    if (prodname === "") {
        alert("Please Enter ParentProductName");
        $("#prodname1").focus().css("outline-color", "#ff0000");
        return;
    }

    var url = "/stock/Product?operation=productAdd&prodName=" + prodname + "&parentid=" + prodid;
    $.ajax({
        url: url,
        type: 'POST'
    }).done(function(result) {
        result = JSON.parse(result);
        if (result.status == 1) {
            alert("SuccessFully Added");
            $('#prodname1').val("");


        } else if (result.status == 0) {
            alert("Error occurs");
        }

    }).fail(function(result) {
        alert("Please Check Details!..")
    });
});

$(document).on("click", "#parent2", function(key) {
    //var prodid = $(this).val();
    var prodname = $('#prodname2').val();
    if (prodname === "") {
        alert("Please Enter ParentProductName");
        $("#prodname2").focus().css("outline-color", "#ff0000");
        return;
    }

    var url = "/stock/Product?operation=productAdd&prodName=" + prodname + "&parentid=" + prodid2;
    $.ajax({
        url: url,
        type: 'POST'
    }).done(function(result) {
        result = JSON.parse(result);
        if (result.status == 1) {
            alert("SuccessFully Added");
            $('#prodname2').val("");


        } else if (result.status == 0) {
            alert("Error occurs");
        }

    }).fail(function(result) {
        alert("Please Check Details!..")
    });
});
