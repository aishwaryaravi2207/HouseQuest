$(document).ready(function() {
	destId = document.getElementById("dropdown").innerText;
	getHouses(destId);
});

/** AJAX calls */

function getHouses(destId) {
	$.ajax({
		url: "/Jingle/HouseServlet?destId=${destId}",
		method: "GET",
		dataType: "json",
		success: function(data) {
			let artistList = document.getElementById("search-tiles");
			for (let i = 0; i < data.length; i++) {
				artistList.innerHTML += `<div class="house-tile">
							<img class="house-picture" src="${data[i].houseDp}" />
							<div class="house-address">${data[i].address}</div>
							<div class="house-distance">${data[i].distance}</div>
							<div class="house-bedrooms">${data[i].bedrooms}</div>
							<div class="house-bath">${data[i].bath}</div>
						</div>`;
			}
		},
		error: function(error) {
			console.error("Error fetching artists:", error);
		},
	});
}