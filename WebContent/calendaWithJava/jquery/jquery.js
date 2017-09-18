$(document).ready(function(){
	var weeks =  ["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"];
	var month = ["December","Janyuary","Feburay","March","Appril","May","June",
		"July","August","September","October","November","December"];
	var liClick;
	$("li div").click(function(){
		 $(this).addClass("thisDate");
		 $("li div").not(this).removeClass("thisDate");
		 var textT = $(this).html();
		 var textH = $("span.textH2").html(textT);
		 var index = $("li div").index(this);
			 $(".monthDesc").find("li").addClass("hidden");
			 $(".monthDesc").find("img").addClass("hidden");
			 $(".monthDesc").find(".once").addClass("hidden");
			 $(".monthDesc").find("li").eq(index).removeClass("hidden").css("list-style","none");
			 $(".monthDesc").find("img").eq(index).removeClass("hidden").css("list-style","none");
		
		 var textTh1 = $("h1.textH1").html(weeks[index%7]);
		 var monthN = $("h5").text();
		 var myInteger = parseInt(monthN);
		 if($(this).parents("li").hasClass("difM"))
			 {
			 	var textH = $("span.monthN").html(month[myInteger-1]);
			 }else
			 {
				 var textH = $("span.monthN").html(month[myInteger]);
			 }
	});
	
	});
	
function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}

// Close the dropdown menu if the user clicks outside of it
window.onclick = function(event) {
  if (!event.target.matches('.dropbtn')) {

    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}