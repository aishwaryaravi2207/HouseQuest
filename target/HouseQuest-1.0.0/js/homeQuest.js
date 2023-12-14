/** AJAX calls */

function getHouses() {
	var e = document.getElementById("dropdown");
	var destId = e.value;
	console.log(destId);
	$.ajax({
		url: `/HouseQuest/HouseServlet?destId=${destId}`,
		method: "GET",
		dataType: "json",
		success: function(data) {
			console.log(data);
			let houseList = document.getElementById("grid");
			for (let i = 0; i < data.length; i++) {
				houseList.innerHTML += `<div class="house-grid" id="house-grid">
							<div class="house-tile">
							<img class="house-picture" src=" ${data[i].houseDp}" />
							<div class="house-info">
							<div class="house-price">\$${data[i].price}/mo</div>
							<div class="house-bbd">${data[i].bedrooms} bds | ${data[i].bath} ba | ${data[i].distance} mi</div>
							<div class="house-address">${data[i].address}</div>
							<div class="house-amen">${data[i].grocery} | ${data[i].groc_dist} mi ${data[i].transport} | ${data[i].trans_dist} mi</div>
							</div>
							</div>
						</div>`;
			}
		},
		error: function(error) {
			console.error("Error fetching houses:", error);
		},
	});
}
