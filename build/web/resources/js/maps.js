/* 
 * Created by Sanchit Chadha on 2014.12.10  * 
 * Copyright © 2014 Sanchit Chadha. All rights reserved. * 
 */

var directionsDisplay;
var directionsService = new google.maps.DirectionsService();
var map;

function initialize() {
  directionsDisplay = new google.maps.DirectionsRenderer({ 'map': map });
  var blacksburg = new google.maps.LatLng(37.231481, -80.415965);
  var mapOptions = {
    zoom:16,
    center: blacksburg
  };
  console.log("TEST " + document.getElementById('map-canvas'));
  map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
  directionsDisplay.setMap(map);
}

function calcRoute() {
  var start = document.getElementById('start').value;
  var end = document.getElementById('end').value;
  var request = {
      origin:start,
      destination:end,
      travelMode: google.maps.TravelMode.WALKING
  };
  directionsService.route(request, function(response, status) {
    if (status == google.maps.DirectionsStatus.OK) {
      directionsDisplay.setDirections(response);
    }
  });
}
console.log("WINDOW: " + window);
google.maps.event.addDomListener(window, 'load', initialize);

