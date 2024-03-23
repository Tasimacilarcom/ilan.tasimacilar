// This sample uses the Autocomplete widget to help the user select a
// place, then it retrieves the address components associated with that
// place, and then it populates the form fields with those details.
// This sample requires the Places library. Include the libraries=places
// parameter when you first load the API. For example:
// <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&libraries=places">

var placeSearch, autocomplete, autocomplete2, autocomplete3;

var componentForm = {
    postal_code:'long_name',
    street_number: 'long_name',
    route: 'long_name',
    administrative_area_level_1: 'long_name',
    administrative_area_level_2: 'long_name',
    administrative_area_level_3: 'long_name',
    administrative_area_level_4: 'long_name',
    //locality: 'long_name',
    country: 'short_name'
};

//------------------------------------------------------------------------------
    // Baslangıc
    function initAutocomplete() { 
        // Otomatik tamamlama nesnesini oluşturuluyor, arama sonuçlarını/tahminlerini coğrafi konum türleriyle sınırlamak.
        autocomplete = new google.maps.places.Autocomplete(document.getElementById('autocomplete'), {types: ['geocode']});
        autocomplete2 = new google.maps.places.Autocomplete(document.getElementById('autocomplete_2'), {types: ['geocode']});
        autocomplete3 = new google.maps.places.Autocomplete(document.getElementById('autocomplete_3'), {types: ['geocode']});

        // Avoid paying for data that you don't need by restricting the set of place fields that are returned to just the address components.
        //autocomplete.setFields(['address_component']);
        //autocomplete2.setFields(['address_component']);

        // Kullanıcı açılır menüden bir adres seçtiğinde, adres alanlarını formda doldurun.
        autocomplete.addListener('place_changed', fillInAddress);
        autocomplete2.addListener('place_changed', fillInAddress2);
        autocomplete3.addListener('place_changed', fillInAddress3);
    }
//------------------------------------------------------------------------------

//------------------------------------------------------------------------------
    // adres alanlarını forma doldurur.
    // rota baslangic noktasi icin
    function fillInAddress() {

        // Otomatik tamamlama nesnesinden yer ayrıntıları alınıyor.
        var place = autocomplete.getPlace();

            //  Aşağıdaki kod baska bir alternatif yontem. yerden bilgileri alıp forma gondermek ıcın
            //  
            //    for (var component in componentForm) {
            //        document.getElementById(component).value = '';
            //        document.getElementById(component).disabled = false;
            //    }
            //
            //    // Adresin her bir parçasını,bileşenini yer ayrıntılarından alır ve ardından formdaki ilgili alanı doldurur.
            //    for (var i = 0; i < place.address_components.length; i++) {
            //
            //        var addressType = place.address_components[i].types[0];
            //        if (componentForm[addressType]) {
            //            var val = place.address_components[i][componentForm[addressType]];
            //            document.getElementById(addressType).value = val;
            //        }
            //    }
            
            document.getElementById("SP_POSTAL_CODE").value ="";
            document.getElementById("SP_STREET_NUMBER").value = "";
            document.getElementById("SP_ROUTE").value = "";
            document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_1").value ="";
            document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_2").value ="";
            document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_3").value ="";
            document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_4").value ="";
            document.getElementById("SP_COUNTRY").value ="";
            document.getElementById("SP_FORMATED_ADDRESS").value = "";
            document.getElementById("SP_LAT").value = "";
            document.getElementById("SP_LNG").value = "";
        
            var arrAddress = place.address_components;
     
            for (ac = 0; ac < arrAddress.length; ac++) {
                if (arrAddress[ac].types[0] == "postal_code") { document.getElementById("SP_POSTAL_CODE").value = arrAddress[ac].long_name   }
                if (arrAddress[ac].types[0] == "street_number") { document.getElementById("SP_STREET_NUMBER").value = arrAddress[ac].long_name   }
                if (arrAddress[ac].types[0] == "route") { document.getElementById("SP_ROUTE").value = arrAddress[ac].long_name  }
                if (arrAddress[ac].types[0] == "administrative_area_level_1") { document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_1").value = arrAddress[ac].long_name}
                if (arrAddress[ac].types[0] == "administrative_area_level_2") { document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_2").value = arrAddress[ac].long_name}
                if (arrAddress[ac].types[0] == "administrative_area_level_3") { document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_3").value = arrAddress[ac].long_name}
                if (arrAddress[ac].types[0] == "administrative_area_level_4") { document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_4").value = arrAddress[ac].long_name}            
                if (arrAddress[ac].types[0] == "country") { document.getElementById("SP_COUNTRY").value = arrAddress[ac].long_name}
                //if (arrAddress[ac].types[0] == "locality") {  document.getElementById("tbCity").value = arrAddress[ac].long_name   }   
            }
           
            document.getElementById("SP_FORMATED_ADDRESS").value = place.formatted_address;
            document.getElementById("SP_LAT").value = place.geometry.location.lat();
            document.getElementById("SP_LNG").value = place.geometry.location.lng();

    }
//------------------------------------------------------------------------------

//------------------------------------------------------------------------------
    // adres alanlarını forma doldurur.
    // rota bitis noktasi icin
    function fillInAddress2() {

        // Otomatik tamamlama nesnesinden yer ayrıntıları alınıyor. 
        
        
        document.getElementById("SP_POSTAL_CODEx").value ="";
            document.getElementById("SP_STREET_NUMBERx").value = "";
            document.getElementById("SP_ROUTEx").value = "";
            document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_1x").value ="";
            document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_2x").value ="";
            document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_3x").value ="";
            document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_4x").value ="";
            document.getElementById("SP_COUNTRYx").value ="";
            document.getElementById("SP_FORMATED_ADDRESSx").value = "";
            document.getElementById("SP_LATx").value = "";
            document.getElementById("SP_LNGx").value = "";
        
        var place2 = autocomplete2.getPlace();

        var arrAddress2 = place2.address_components;
            for (ac2 = 0; ac2 < arrAddress2.length; ac2++) {
                if (arrAddress2[ac2].types[0] == "postal_code") { document.getElementById("SP_POSTAL_CODEx").value = arrAddress2[ac2].long_name   }
                if (arrAddress2[ac2].types[0] == "street_number") { document.getElementById("SP_STREET_NUMBERx").value = arrAddress2[ac2].long_name   }
                if (arrAddress2[ac2].types[0] == "route") { document.getElementById("SP_ROUTEx").value = arrAddress2[ac2].long_name  }
                if (arrAddress2[ac2].types[0] == "administrative_area_level_1") { document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_1x").value = arrAddress2[ac2].long_name}
                if (arrAddress2[ac2].types[0] == "administrative_area_level_2") { document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_2x").value = arrAddress2[ac2].long_name}
                if (arrAddress2[ac2].types[0] == "administrative_area_level_3") { document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_3x").value = arrAddress2[ac2].long_name}
                if (arrAddress2[ac2].types[0] == "administrative_area_level_4") { document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_4x").value = arrAddress2[ac2].long_name}
                if (arrAddress2[ac2].types[0] == "country") { document.getElementById("SP_COUNTRYx").value = arrAddress2[ac2].long_name}
                //if (arrAddress2[ac2].types[0] == "locality") {  document.getElementById("tbCity").value = arrAddress2[ac2].long_name   }   
            }

            document.getElementById("SP_FORMATED_ADDRESSx").value = place2.formatted_address;
            document.getElementById("SP_LATx").value = place2.geometry.location.lat();
            document.getElementById("SP_LNGx").value = place2.geometry.location.lng();

    }
//------------------------------------------------------------------------------

//------------------------------------------------------------------------------
    // adres alanlarını forma doldurur.
    // duraklar icin kullanılıyor
    function fillInAddress3() {

        // Otomatik tamamlama nesnesinden yer ayrıntıları alınıyor. 
        
        document.getElementById("SP_POSTAL_CODExx").value = "";
        document.getElementById("SP_STREET_NUMBERxx").value = "";
        document.getElementById("SP_ROUTExx").value = "";
        document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_1xx").value = "";
        document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_2xx").value = "";
        document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_3xx").value = "";
        document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_4xx").value = "";
        document.getElementById("SP_COUNTRYxx").value = "";
        document.getElementById("SP_FORMATED_ADDRESSxx").value = "";
        document.getElementById("SP_LATxx").value = "";
        document.getElementById("SP_LNGxx").value = "";
        
        var place3 = autocomplete3.getPlace();

        var arrAddress3 = place3.address_components;
        for (ac3 = 0; ac3 < arrAddress3.length; ac3++) {
            if (arrAddress3[ac3].types[0] == "postal_code") { document.getElementById("SP_POSTAL_CODExx").value = arrAddress3[ac3].long_name   }
            if (arrAddress3[ac3].types[0] == "street_number") { document.getElementById("SP_STREET_NUMBERxx").value = arrAddress3[ac3].long_name   }
            if (arrAddress3[ac3].types[0] == "route") { document.getElementById("SP_ROUTExx").value = arrAddress3[ac3].long_name  }
            if (arrAddress3[ac3].types[0] == "administrative_area_level_1") { document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_1xx").value = arrAddress3[ac3].long_name}
            if (arrAddress3[ac3].types[0] == "administrative_area_level_2") { document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_2xx").value = arrAddress3[ac3].long_name}
            if (arrAddress3[ac3].types[0] == "administrative_area_level_3") { document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_3xx").value = arrAddress3[ac3].long_name}
            if (arrAddress3[ac3].types[0] == "administrative_area_level_4") { document.getElementById("SP_ADMINISTRATIVE_AREA_LEVEL_4xx").value = arrAddress3[ac3].long_name}
            if (arrAddress3[ac3].types[0] == "country") { document.getElementById("SP_COUNTRYxx").value = arrAddress3[ac3].long_name}
        }
    //alert ("xxx");    
        document.getElementById("SP_FORMATED_ADDRESSxx").value = place3.formatted_address;
        document.getElementById("SP_LATxx").value = place3.geometry.location.lat();
        document.getElementById("SP_LNGxx").value = place3.geometry.location.lng();

    }
//------------------------------------------------------------------------------

//------------------------------------------------------------------------------
    // Bias the autocomplete object to the user's geographical location, 
    // as supplied by the browser's 'navigator.geolocation' object.
    // rota baslangic noktasi icin
    function geolocate() {
//        if (navigator.geolocation) {
//            navigator.geolocation.getCurrentPosition(function (position) {
//                var geolocation = {
//                    lat: position.coords.latitude,
//                    lng: position.coords.longitude
//                };
//                var circle = new google.maps.Circle( {center: geolocation, radius: position.coords.accuracy});
//                autocomplete.setBounds(circle.getBounds());
//            });
//        }
        autocomplete.setComponentRestrictions ({'country': ['tr']});
    }
//------------------------------------------------------------------------------   

//------------------------------------------------------------------------------
    // Bias the autocomplete object to the user's geographical location, 
    // as supplied by the browser's 'navigator.geolocation' object.
    // rota bitis noktasi icin
    function geolocate2() {
//        if (navigator.geolocation) {
//            navigator.geolocation.getCurrentPosition(function (position) {
//                var geolocation = {
//                    lat: position.coords.latitude,
//                    lng: position.coords.longitude
//                };
//                var circle = new google.maps.Circle( {center: geolocation, radius: position.coords.accuracy});
//                autocomplete2.setBounds(circle.getBounds());
//            });
//        }
        autocomplete2.setComponentRestrictions ({'country': ['tr']});
    }
//------------------------------------------------------------------------------   

//------------------------------------------------------------------------------
    // Bias the autocomplete object to the user's geographical location, 
    // as supplied by the browser's 'navigator.geolocation' object.
    // duraklar icin
    function geolocate3() {
//        if (navigator.geolocation) {
//            navigator.geolocation.getCurrentPosition(function (position) {
//                var geolocation = {
//                    lat: position.coords.latitude,
//                    lng: position.coords.longitude
//                };
//                var circle = new google.maps.Circle( {center: geolocation, radius: position.coords.accuracy});
//                autocomplete3.setBounds(circle.getBounds());
//            });
//        }
        autocomplete3.setComponentRestrictions ({'country': ['tr']});
    }
//------------------------------------------------------------------------------   