$(document).ready(function(){
	//set options
	var speed = 500; //Fade Speed
	var autoSwitch = true; //auto slider option
	var autoSwitchSpeed = 4000 // Auto Slider speed
	
	//add initial active class
	$(".slide").first().addClass(".active");
	
	//hide  all silde
	$(".slide").hide();
	
	//show first slide
	$(".slide").show();
	
});