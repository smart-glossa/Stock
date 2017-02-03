	function adddetail() {
		var comadd="";
		//comadd +="<div id=\"div1\>";
		comadd +="<p id=\"comy\">ADD COMPANY DETAILS<\/p>"
		comadd += "<table>";
		comadd += "<tr><td>CompanyId<span>*<span>:<\/td><td>";
		comadd += "<input type=\"text\" id=\"comid\" placeholder=\"CompanyId..\"><\/td><\/tr>";
		comadd += "<tr><td>CompanyName<span>*<\/span>:<\/td><td><input type=\"text\" id=\"comName\" placeholder=\"CompanyName..\"><\/td><\/tr>";
		comadd += "<tr><td>TinNo<span>*<\/span>:<\/td><td><input type=\"text\" id=\"tinNo\" placeholder=\"TinNumber..\"><\/td><\/tr>";
		comadd += "<tr><td>Proprietor<span>*<\/span>:<\/td><td><input type=\"text\" id=\"prop\" placeholder=\"proprietor..\"><\/td><\/tr>";
		comadd += "<tr><td>Address<span>*<\/span>:<\/td><td><textarea id=\"addr\"><\/textarea><\/td><\/tr>";
		comadd += "<tr><td><\/td><td><input type=\"submit\" id=\"comadd\" value=\"SUBMIT\">&nbsp;&nbsp</td><\/tr>";
		//comadd +="<\/div>";
		$('.add')[0].innerHTML = comadd;	
	}

	/*****************Drop-Down***************/
	function Menu() {
		var drpVar="";
		drpVar += "<ul>";
		drpVar += "   <li class=\"dropdown\">";
		drpVar += "    <a href=\"javascript:void(0)\" class=\"dropbtn\">Company Detail<\/a>";
		drpVar += "    <div class=\"dropdown-content\">";
		drpVar += "      <a href=\"#\"  id=\"dis1\"><div onclick=\"adddetail()\">Add Detail<\/div><\/a>";
		drpVar += "      <a href=\"#\" id=\"dis2\"><div onclick=\"updatedetail()\" >Update Detail<\/div><\/a>";
		drpVar += "      <a href=\"#\" id=\"dis3\"><div onclick=\"productNameAdd()\" >Add productName<\/div><\/a>";
		drpVar += "    <\/div>";
		drpVar += "  <\/li>";
		drpVar += "  <li><a href=\"#\" id=\"dis4\"><div onclick=\"displaybill()\" >ParentProductList<\/div><\/a><\/li>";
		drpVar += "  <li class=\"dropdown\">";
		drpVar += "    <a href=\"javascript:void(0)\" class=\"dropbtn\">Dropdown<\/a>";
		drpVar += "    <div class=\"dropdown-content\">";
		drpVar += "      <a href=\"#\"  ><span class=\"context-menu-one btn btn-neutral\">right click me</span><\/a>";
		drpVar += "      <a href=\"#\">Link 2<\/a>";
		drpVar += "      <a href=\"#\">Link 3<\/a>";
		drpVar += "    <\/div>";
		drpVar += "  <\/li>";
		drpVar += "<\/ul>";
		drpVar += "";
		
		$('.drop')[0].innerHTML = drpVar;
	}
   function Mens(){
	   var menuVar="";
	   menuVar += "<div class=\"custom-menu\">";
	   menuVar += "<div id=\"mySidenav\" class=\"sidenav\">";
	   menuVar += "  <a href=\"javascript:void(0)\" class=\"closebtn\" onclick=\"closeNav()\">&times;<\/a>";
	   menuVar += "  <a href=\"#\" onclick=\"adddetail()\">Add Detail<\/a>";
	   menuVar += "  <a href=\"#\" onclick=\"updatedetail()\">Update Detail<\/a>";
	   menuVar += "  <a href=\"#\" onclick=\"myFunction()\"><div id=\"filp\">Add productName<\/div><\/a>";
	  // menuVar += "  <a href=\"#\">Contact<\/a>";
	   menuVar += "<\/div>";
	   menuVar += "<\/div>";
	   $('.drop')[0].innerHTML = menuVar;

   }
   function myFunction(){
	   productdislay();
	   productNameAdd();
	}
  
	/**************Update company detail**********/
	
	function updatedetail() {
		var comup="";
		//comup +="<div id=\"div2\>";
		comup +="<p id=\"comy\">UPDATE COMPANY DETAILS<\/p>"
		comup += "<table>";
		comup += "<tr><td>CompanyId<span>*<span>:<\/td><td>";
		comup += "<input type=\"text\" id=\"ucomid\" placeholder=\"CompanyId..\"><\/td><\/tr>";
		comup += "<tr><td>CompanyName<span>*<\/span>:<\/td><td><input type=\"text\" id=\"ucomName\" placeholder=\"CompanyName..\"><\/td><\/tr>";
		comup += "<tr><td>TinNo<span>*<\/span>:<\/td><td><input type=\"text\" id=\"utinNo\" placeholder=\"TinNumber..\"><\/td><\/tr>";
		comup += "<tr><td>Proprietor<span>*<\/span>:<\/td><td><input type=\"text\" id=\"uprop\" placeholder=\"proprietor..\"><\/td><\/tr>";
		comup += "<tr><td>Address<span>*<\/span>:<\/td><td><textarea id=\"uaddr\"><\/textarea><\/td><\/tr>";
		comup += "<tr><td><\/td><td><input type=\"submit\" id=\"comupdate\" value=\"UPDATE\">&nbsp;&nbsp;<\/td><\/tr>";
		//comup +="<\/div>";
		$('.add')[0].innerHTML = comup;	
	}
	
	/**************Price Details**************/
	function priceDetailsAdd(){
		var priceVar="";
		priceVar += "<input type=\"text\" id=\"prodid\" placeholder=\"ProductId\">";
		priceVar += "<input type=\"text\" id=\"prodName\" placeholder=\"ProductName\">";
		priceVar += "<input type=\"text\" id=\"parid\" placeholder=\"PriceId\">";
		priceVar += "<input type=\"submit\" value=\"SUBMIT\" id=\"priceAdd\">";
		$('.add')[0].innerHTML = priceVar;	
	}
	function productNameAdd() {
		var productVar="";
		productVar += "<p id=\"comy\"> ADD PRODUCTNAME &<span class=\"colorss\"> PARENTPRODUCT<\/span><\/p>";
		productVar += "<div class=\"prodss\">";
		productVar += "<input type=\"text\" id=\"prodName\" placeholder=\"ProductName\">";
		productVar += "<\/div>";
		productVar += "<div class=\"prodsss\">";
		productVar += "<input type=\"submit\" value=\"PRODUCT\" id=\"Addsubmit\">";
		productVar += "<\/div>";
		productVar += "<div class=\"pardss\">";
		productVar += "<input type=\"text\" id=\"parentName\" placeholder=\"ParentProductName\">";
		productVar += "<\/div>";
		productVar += "<div class=\"pardsss\">";
		productVar += "<input type=\"submit\" value=\"PARENT\" id=\"parentAdd\">";
		productVar += "<\/div>";
		$('.add')[0].innerHTML=productVar;
		
	}
	
	/*************DOM function***************/
	
	function myDom() {
		var head = document.createElement("div");
		head.className = 'head';
		document.body.appendChild(head);
		
		var div3 = document.createElement("div");
		document.body.appendChild(div3);

		var acDiv = document.createElement("div");
		acDiv.className = 'productAdd';
		var h2 = document.createElement("h2");
		var h2Value = document.createTextNode("ADD PRODUCTNAME");
		h2.appendChild(h2Value);
		acDiv.appendChild(h2);
		
		var l1Value = document.createTextNode("ProductName");
		l1Value.className="proName";
		acDiv.appendChild(l1Value);
		
		var input = document.createElement("input");
		input.type="text";
		input.id = 'prodName';
		input.className = 'll';
		input.placeholder = 'Enter ProductName';
		acDiv.appendChild(input);
		
		var button=document.createElement("input");
		button.type="submit";
		button.id="Addsubmit"
		button.value="ADD";
		acDiv.appendChild(button);
		div3.appendChild(acDiv); 
	}