//------------------------------------------------------------------------------
$(document).ready(function(){
  $(".owl-carousel").owlCarousel();
});

//------------------------------------------------------------------------------
function toggleMenu() {
  console.log('test click')
  var x = document.getElementById("siteMenu");
  if (x.className === "menu site-menu") {
    x.className += " responsive";
  } else {
    x.className = "menu site-menu";
  }
}

//------------------------------------------------------------------------------
function showHidePanelFunction(vs) {
    var name = "myDIV" + vs;
    var elems = document.getElementsByClassName(name);
    for (var i = 0; i < elems.length; i += 1) { 
        if (elems[i].style.display == "none") { elems[i].style.display = "block";} 
        else { elems[i].style.display = "none";}
    }
}

//------------------------------------------------------------------------------
function showHideVehiclePanel() {
   $(".arac-list").collapse('hide');
}
//------------------------------------------------------------------------------