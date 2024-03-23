/*startPoint*/
function initializeGMAP1() {
    //alert ("xxx"); 
    //console.log("Adres:::");
    
    var latlng = new google.maps.LatLng(41.0464146037958, 29.033405012130515);
    var map = new google.maps.Map(document.getElementById('map'), { center: latlng, zoom: 11 });
    var marker = new google.maps.Marker({ map: map, position: latlng, draggable: true, anchorPoint: new google.maps.Point(0, -29) });
    
    var input = document.getElementById('searchInput');
    map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);
    
    var geocoder = new google.maps.Geocoder();
    var autocomplete = new google.maps.places.Autocomplete(input);
     
    autocomplete.bindTo('bounds', map);
    var infowindow = new google.maps.InfoWindow();
    autocomplete.addListener('place_changed', function () {
        infowindow.close();
        marker.setVisible(false);
        var place = autocomplete.getPlace();
        if (!place.geometry) {
            window.alert("Aradığınız yer bulunamamıştır");
            return;
        }

        // If the place has a geometry, then present it on a map.
        if (place.geometry.viewport) { map.fitBounds(place.geometry.viewport); } 
        else { map.setCenter(place.geometry.location);
               map.setZoom(11); }

        marker.setPosition(place.geometry.location);
        marker.setVisible(true);

        bindDataToForm(place.formatted_address, place.geometry.location.lat(), place.geometry.location.lng());
        infowindow.setContent(place.formatted_address);
        infowindow.open(map, marker);
       
        var arrAddress = results[0].address_components; 
        for (ac = 0; ac < arrAddress.length; ac++) {
            if (arrAddress[ac].types[0] == "postal_code") { document.getElementById("SP_POSTAL_CODE").value = arrAddress[ac].long_name;}
            if (arrAddress[ac].types[0] == "street_number") { document.getElementById("SP_STREET_NUMBER").value = arrAddress[ac].long_name; }
            if (arrAddress[ac].types[0] == "route") { document.getElementById("SP_ROUTE").value = arrAddress[ac].long_name; }
            if (arrAddress[ac].types[0] == "administrative_area_level_1") { document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_1").value = arrAddress[ac].long_name; }
            if (arrAddress[ac].types[0] == "administrative_area_level_2") { document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_2").value = arrAddress[ac].long_name; }
            if (arrAddress[ac].types[0] == "administrative_area_level_3") { document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_3").value = arrAddress[ac].long_name; }
            if (arrAddress[ac].types[0] == "administrative_area_level_4") { document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_4").value = arrAddress[ac].long_name;}
            if (arrAddress[ac].types[0] == "country") { document.getElementById("SP_COUNTRY").value = arrAddress[ac].long_name; }
            //if (arrAddress[ac].types[0] == "locality") {  document.getElementById("tbCity").value = arrAddress[ac].long_name; }   
        }
        document.getElementById("SP_FORMATED_ADDRESS").value = results[0].formatted_address;
        document.getElementById("SP_LAT").value = marker.getPosition().lat();
        document.getElementById("SP_LNG").value = marker.getPosition().lng();

    });
    
    // this function will work on marker move event into map 
    google.maps.event.addListener(marker, 'dragend', function () {
        geocoder.geocode({'latLng': marker.getPosition()}, function (results, status) {
            if (status == google.maps.GeocoderStatus.OK) {
                if (results[0]) {
                    
                    bindDataToForm(results[0].formatted_address, marker.getPosition().lat(), marker.getPosition().lng());
                    infowindow.setContent(results[0].formatted_address);
                    infowindow.open(map, marker);
                    
                    var arrAddress = results[0].address_components;
                    for (ac = 0; ac < arrAddress.length; ac++) {
                        if (arrAddress[ac].types[0] == "postal_code") { document.getElementById("SP_POSTAL_CODE").value = arrAddress[ac].long_name; }
                        if (arrAddress[ac].types[0] == "street_number") { document.getElementById("SP_STREET_NUMBER").value = arrAddress[ac].long_name; }
                        if (arrAddress[ac].types[0] == "route") { document.getElementById("SP_ROUTE").value = arrAddress[ac].long_name; }
                        if (arrAddress[ac].types[0] == "administrative_area_level_1") { document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_1").value = arrAddress[ac].long_name; }
                        if (arrAddress[ac].types[0] == "administrative_area_level_2") { document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_2").value = arrAddress[ac].long_name; }
                        if (arrAddress[ac].types[0] == "administrative_area_level_3") { document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_3").value = arrAddress[ac].long_name; }
                        if (arrAddress[ac].types[0] == "administrative_area_level_4") { document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_4").value = arrAddress[ac].long_name; }
                        if (arrAddress[ac].types[0] == "country") { document.getElementById("SP_COUNTRY").value = arrAddress[ac].long_name; }
                        //if (arrAddress[ac].types[0] == "locality") {  document.getElementById("tbCity").value = arrAddress[ac].long_name;  }   
                    }
                    document.getElementById("SP_FORMATED_ADDRESS").value = results[0].formatted_address;
                    document.getElementById("SP_LAT").value = marker.getPosition().lat();
                    document.getElementById("SP_LNG").value = marker.getPosition().lng();
                }
            }
        });
    });
}

/*endPoint*/
function initializeGMAP2() {
    
    var latlng = new google.maps.LatLng(41.0464146037958, 29.033405012130515);
    var map = new google.maps.Map(document.getElementById('map2'), { center: latlng, zoom: 11 });
    var marker = new google.maps.Marker({ map: map, position: latlng, draggable: true, anchorPoint: new google.maps.Point(0, -29) });
    
    var input = document.getElementById('searchInput2');
    map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);
    
    var geocoder = new google.maps.Geocoder();
    var autocomplete = new google.maps.places.Autocomplete(input);
     
    autocomplete.bindTo('bounds', map);
    var infowindow = new google.maps.InfoWindow();
    autocomplete.addListener('place_changed', function () {console.log("Adres:::");
        infowindow.close();
        marker.setVisible(false);
        var place = autocomplete.getPlace();
        if (!place.geometry) {
            window.alert("Aradığınız yer bulunamamıştır");
            return;
        }

        // If the place has a geometry, then present it on a map.
        if (place.geometry.viewport) { map.fitBounds(place.geometry.viewport); } 
        else { map.setCenter(place.geometry.location);
               map.setZoom(11); }

        marker.setPosition(place.geometry.location);
        marker.setVisible(true);

        bindDataToForm2(place.formatted_address, place.geometry.location.lat(), place.geometry.location.lng());
        infowindow.setContent(place.formatted_address);
        infowindow.open(map, marker);
       
        var arrAddress = results[0].address_components;
        for (ac = 0; ac < arrAddress.length; ac++) {
            if (arrAddress[ac].types[0] == "postal_code") { document.getElementById("SP_POSTAL_CODEx").value = arrAddress[ac].long_name  }
            if (arrAddress[ac].types[0] == "street_number") { document.getElementById("SP_STREET_NUMBERx").value = arrAddress[ac].long_name  }
            if (arrAddress[ac].types[0] == "route") { document.getElementById("SP_ROUTEx").value = arrAddress[ac].long_name  }
            if (arrAddress[ac].types[0] == "administrative_area_level_1") { document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_1x").value = arrAddress[ac].long_name}
            if (arrAddress[ac].types[0] == "administrative_area_level_2") { document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_2x").value = arrAddress[ac].long_name}
            if (arrAddress[ac].types[0] == "administrative_area_level_3") { document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_3x").value = arrAddress[ac].long_name}
            if (arrAddress[ac].types[0] == "administrative_area_level_4") { document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_4x").value = arrAddress[ac].long_name}
            if (arrAddress[ac].types[0] == "country") { document.getElementById("SP_COUNTRYx").value = arrAddress[ac].long_name}
            //if (arrAddress[ac].types[0] == "locality") { document.getElementById("tbCity").value = arrAddress[ac].long_name  }   
        }
        document.getElementById("SP_FORMATED_ADDRESSx").value = results[0].formatted_address;
        document.getElementById("SP_LATx").value = marker.getPosition().lat();
        document.getElementById("SP_LNGx").value = marker.getPosition().lng();

    });
    
    // this function will work on marker move event into map 
    google.maps.event.addListener(marker, 'dragend', function () {
        geocoder.geocode({'latLng': marker.getPosition()}, function (results, status) {
            if (status == google.maps.GeocoderStatus.OK) {
                if (results[0]) {
                    
                    bindDataToForm2(results[0].formatted_address, marker.getPosition().lat(), marker.getPosition().lng());
                    infowindow.setContent(results[0].formatted_address);
                    infowindow.open(map, marker);
                    
                    
                    var arrAddress = results[0].address_components;
                    for (ac = 0; ac < arrAddress.length; ac++) {
                        if (arrAddress[ac].types[0] == "postal_code") { document.getElementById("SP_POSTAL_CODEx").value = arrAddress[ac].long_name  }
                        if (arrAddress[ac].types[0] == "street_number") { document.getElementById("SP_STREET_NUMBERx").value = arrAddress[ac].long_name  }
                        if (arrAddress[ac].types[0] == "route") { document.getElementById("SP_ROUTEx").value = arrAddress[ac].long_name  }
                        if (arrAddress[ac].types[0] == "administrative_area_level_1") { document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_1x").value = arrAddress[ac].long_name}
                        if (arrAddress[ac].types[0] == "administrative_area_level_2") { document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_2x").value = arrAddress[ac].long_name}
                        if (arrAddress[ac].types[0] == "administrative_area_level_3") { document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_3x").value = arrAddress[ac].long_name}
                        if (arrAddress[ac].types[0] == "administrative_area_level_4") { document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_4x").value = arrAddress[ac].long_name}
                        if (arrAddress[ac].types[0] == "country") { document.getElementById("SP_COUNTRYx").value = arrAddress[ac].long_name; }
                        //if (arrAddress[ac].types[0] == "locality") { document.getElementById("tbCity").value = arrAddress[ac].long_name  }   
                    }
                    document.getElementById("SP_FORMATED_ADDRESSx").value = results[0].formatted_address;
                    document.getElementById("SP_LATx").value = marker.getPosition().lat();
                    document.getElementById("SP_LNGx").value = marker.getPosition().lng();
                }
            }
        });
    });
}

/*station*/
function initializeGMAP3() {
    
    var latlng = new google.maps.LatLng(41.0464146037958, 29.033405012130515);
    var map = new google.maps.Map(document.getElementById('map3'), { center: latlng, zoom: 11 });
    var marker = new google.maps.Marker({ map: map, position: latlng, draggable: true, anchorPoint: new google.maps.Point(0, -29) });
    
    var input = document.getElementById('searchInput3');
    map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);
    
    var geocoder = new google.maps.Geocoder();
    var autocomplete = new google.maps.places.Autocomplete(input);
     
    autocomplete.bindTo('bounds', map);
    var infowindow = new google.maps.InfoWindow();
    autocomplete.addListener('place_changed', function () {console.log("Adres:::");
        infowindow.close();
        marker.setVisible(false);
        var place = autocomplete.getPlace();
        if (!place.geometry) {
            window.alert("Aradığınız yer bulunamamıştır");
            return;
        }

        // If the place has a geometry, then present it on a map.
        if (place.geometry.viewport) { map.fitBounds(place.geometry.viewport); } 
        else { map.setCenter(place.geometry.location);
               map.setZoom(11); }

        marker.setPosition(place.geometry.location);
        marker.setVisible(true);

        bindDataToForm3(place.formatted_address, place.geometry.location.lat(), place.geometry.location.lng());
        infowindow.setContent(place.formatted_address);
        infowindow.open(map, marker);
       
        var arrAddress = results[0].address_components;
        for (ac = 0; ac < arrAddress.length; ac++) {
            if (arrAddress[ac].types[0] == "postal_code") { document.getElementById("SP_POSTAL_CODExx").value = arrAddress[ac].long_name  }
            if (arrAddress[ac].types[0] == "street_number") { document.getElementById("SP_STREET_NUMBERxx").value = arrAddress[ac].long_name  }
            if (arrAddress[ac].types[0] == "route") { document.getElementById("SP_ROUTEx").value = arrAddress[ac].long_name  }
            if (arrAddress[ac].types[0] == "administrative_area_level_1") { document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_1xx").value = arrAddress[ac].long_name}
            if (arrAddress[ac].types[0] == "administrative_area_level_2") { document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_2xx").value = arrAddress[ac].long_name}
            if (arrAddress[ac].types[0] == "administrative_area_level_3") { document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_3xx").value = arrAddress[ac].long_name}
            if (arrAddress[ac].types[0] == "administrative_area_level_4") { document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_4xx").value = arrAddress[ac].long_name}
            if (arrAddress[ac].types[0] == "country") { document.getElementById("SP_COUNTRYxx").value = arrAddress[ac].long_name}
            //if (arrAddress[ac].types[0] == "locality") { document.getElementById("tbCity").value = arrAddress[ac].long_name  }   
        }
        document.getElementById("SP_FORMATED_ADDRESSxx").value = results[0].formatted_address;
        document.getElementById("SP_LATxx").value = marker.getPosition().lat();
        document.getElementById("SP_LNGxx").value = marker.getPosition().lng();

    });
    
    // this function will work on marker move event into map 
    google.maps.event.addListener(marker, 'dragend', function () {
        geocoder.geocode({'latLng': marker.getPosition()}, function (results, status) {
            if (status == google.maps.GeocoderStatus.OK) {
                if (results[0]) {
                    
                    bindDataToForm3(results[0].formatted_address, marker.getPosition().lat(), marker.getPosition().lng());
                    infowindow.setContent(results[0].formatted_address);
                    infowindow.open(map, marker);
                    
                    
                    var arrAddress = results[0].address_components;
                    for (ac = 0; ac < arrAddress.length; ac++) {
                        if (arrAddress[ac].types[0] == "postal_code") { document.getElementById("SP_POSTAL_CODExx").value = arrAddress[ac].long_name  }
                        if (arrAddress[ac].types[0] == "street_number") { document.getElementById("SP_STREET_NUMBERxx").value = arrAddress[ac].long_name  }
                        if (arrAddress[ac].types[0] == "route") { document.getElementById("SP_ROUTExx").value = arrAddress[ac].long_name  }
                        if (arrAddress[ac].types[0] == "administrative_area_level_1") { document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_1xx").value = arrAddress[ac].long_name}
                        if (arrAddress[ac].types[0] == "administrative_area_level_2") { document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_2xx").value = arrAddress[ac].long_name}
                        if (arrAddress[ac].types[0] == "administrative_area_level_3") { document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_3xx").value = arrAddress[ac].long_name}
                        if (arrAddress[ac].types[0] == "administrative_area_level_4") { document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_4xx").value = arrAddress[ac].long_name}
                        if (arrAddress[ac].types[0] == "country") { document.getElementById("SP_COUNTRYxx").value = arrAddress[ac].long_name; }
                        //if (arrAddress[ac].types[0] == "locality") { document.getElementById("tbCity").value = arrAddress[ac].long_name  }   
                    }
                    document.getElementById("SP_FORMATED_ADDRESSxx").value = results[0].formatted_address;
                    document.getElementById("SP_LATxx").value = marker.getPosition().lat();
                    document.getElementById("SP_LNGxx").value = marker.getPosition().lng();
                }
            }
        });
    });
}




/*startPoint*/
function bindDataToForm(address, lat, lng) {
    document.getElementById('location').value = address;
    document.getElementById('autocomplete').value = address;
    document.getElementById('lat').value = lat;
    document.getElementById('lng').value = lng;
}

/*endPoint*/
function bindDataToForm2(address, lat, lng) {
    document.getElementById('location2').value = address;
    document.getElementById('autocomplete_2').value = address;
    document.getElementById('lat2').value = lat;
    document.getElementById('lng2').value = lng;
}

/*station*/
function bindDataToForm3(address, lat, lng) {
    document.getElementById('location3').value = address;
    document.getElementById('autocomplete_3').value = address;
    document.getElementById('lat3').value = lat;
    document.getElementById('lng3').value = lng;
}

//google.maps.event.addDomListener(window, 'load', initializeGMAP1);
//google.maps.event.addDomListener(window, 'load', initializeGMAP2);
//google.maps.event.addDomListener(window, 'load', initializeGMAP3);