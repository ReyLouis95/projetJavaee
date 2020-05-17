$(document).ready(function(){
	$("#restaurants").DataTable();
	
	$(".detailResto").on('click', function(){
		 window.location = $(this).data("href")
	})
});