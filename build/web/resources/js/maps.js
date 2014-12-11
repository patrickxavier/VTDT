/* 
 * Created by Sanchit Chadha on 2014.12.10  * 
 * Copyright © 2014 Sanchit Chadha. All rights reserved. * 
 */

var directionsDisplay;
var directionsService = new google.maps.DirectionsService();
var map;
var marker;

function initialize() {
    directionsDisplay = new google.maps.DirectionsRenderer({'map': map});
    var blacksburg = new google.maps.LatLng(37.231481, -80.415965);
    var mapOptions = {
        zoom: 16,
        center: blacksburg
    };

    map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
    directionsDisplay.setMap(map);

    // Try HTML5 geolocation
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function (position) {
            var pos = new google.maps.LatLng(position.coords.latitude,
                    position.coords.longitude);

            marker = new google.maps.Marker({
                map: map,
                position: pos,
                title: 'Current Location'
            });

            $('#currLoc1').attr('value', pos);
            $('#currLoc2').attr('value', pos);

            map.setCenter(pos);
        }, function () {
            handleNoGeolocation(true);
        });
    } else {
        // Browser doesn't support Geolocation
        handleNoGeolocation(false);
    }
}

function handleNoGeolocation(errorFlag) {
    if (errorFlag) {
        var content = 'Error: The Geolocation service failed.';
    } else {
        var content = 'Error: Your browser doesn\'t support geolocation.';
    }

    var options = {
        map: map,
        position: new google.maps.LatLng(60, 105),
        content: content
    };

    var infowindow = new google.maps.InfoWindow(options);
    map.setCenter(options.position);
}

function calcRoute() {
    marker.setMap(null);
    var start = document.getElementById('start').value;
    var end = document.getElementById('end').value;
    var request = {
        origin: start,
        destination: end,
        travelMode: google.maps.TravelMode.WALKING
    };
    directionsService.route(request, function (response, status) {
        if (status == google.maps.DirectionsStatus.OK) {
            directionsDisplay.setDirections(response);
        }
    });
}
console.log("WINDOW: " + window);
google.maps.event.addDomListener(window, 'load', initialize);

