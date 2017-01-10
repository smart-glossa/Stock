function adddetail() {
	var comadd="";
	comadd +="<p id=\"comy\">ADD COMPANY DETAILS<\/p>"
	comadd += "<table>";
	comadd += "<tr><td>CompanyId<span>*<span>:<\/td><td>";
	comadd += "<input type=\"text\" id=\"comid\" placeholder=\"CompanyId..\"><\/td><\/tr>";
	comadd += "<tr><td>CompanyName<span>*<\/span>:<\/td><td><input type=\"text\" id=\"comName\" placeholder=\"CompanyName..\"><\/td><\/tr>";
	comadd += "<tr><td>TinNo<span>*<\/span>:<\/td><td><input type=\"text\" id=\"tinNo\" placeholder=\"TinNumber..\"><\/td><\/tr>";
	comadd += "<tr><td>Proprietor<span>*<\/span>:<\/td><td><input type=\"text\" id=\"prop\" placeholder=\"proprietor..\"><\/td><\/tr>";
	comadd += "<tr><td>Address<span>*<\/span>:<\/td><td><textarea id=\"addr\"><\/textarea><\/td><\/tr>";
	comadd += "<tr><td><\/td><td><input type=\"submit\" id=\"comadd\" value=\"SUBMIT\">&nbsp;&nbsp;<input type=\"submit\" id=\"comup\" value=\"UPDATE\"><\/td><\/tr>";
	$('.add')[0].innerHTML = comadd;	
}

/*****************Drop-Down***************/
function Menu() {
	var drpVar="";
	drpVar += "<ul>";
	drpVar += "   <li class=\"dropdown\">";
	drpVar += "    <a href=\"javascript:void(0)\" class=\"dropbtn\">Company Detail<\/a>";
	drpVar += "    <div class=\"dropdown-content\">";
	drpVar += "      <a href=\"#\"><div onclick=\"adddetail()\">Add Detail<\/div><\/a>";
	drpVar += "      <a href=\"#\">All Detail<\/a>";
	drpVar += "      <a href=\"#\">Link 3<\/a>";
	drpVar += "    <\/div>";
	drpVar += "  <\/li>";
	drpVar += "  <li><a href=\"#news\">News<\/a><\/li>";
	drpVar += "  <li class=\"dropdown\">";
	drpVar += "    <a href=\"javascript:void(0)\" class=\"dropbtn\">Dropdown<\/a>";
	drpVar += "    <div class=\"dropdown-content\">";
	drpVar += "      <a href=\"#\">Link 1<\/a>";
	drpVar += "      <a href=\"#\">Link 2<\/a>";
	drpVar += "      <a href=\"#\">Link 3<\/a>";
	drpVar += "    <\/div>";
	drpVar += "  <\/li>";
	drpVar += "<\/ul>";
	drpVar += "";
	$('.drop')[0].innerHTML = drpVar;
}