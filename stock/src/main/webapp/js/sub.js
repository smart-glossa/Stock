function openNav() {
    document.getElementById("mySidenav").style.display = "block";
}

function closeNav() {
    document.getElementById("mySidenav").style.display = "none";
}
$(document).ready(function(){
    $("#filp").click(function(){
        $(".prod").slideToggle("slow");
    });
});
$(document).ready(function(){
    $("#parentTable").click(function(){
        $(".prod").slideToggle("slow");
    });
});