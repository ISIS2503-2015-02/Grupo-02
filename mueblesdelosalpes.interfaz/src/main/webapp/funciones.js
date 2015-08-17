/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//public/prueba.js
 function prueba()
    {
        
         var mapa="";
                
                $.ajax({
                    url: '../mueblesdelosalpes.servicios/webresources/Tranvia/tranvias',
                    type : "GET",
                  
                    contentType: 'application/json',
                }).done(function(data) {
                    
                   
                    beaches=data ;
                    initMap();
                   
                 
                    
                
                    console.log(data);
                }, this).error(function(data) {
                    alert(data);
                }, this);
        
        
    }
    
    
    
    
    function initMap() {
  var map = new google.maps.Map(document.getElementById('map'), {
    zoom: 11    ,
    center: {lat: 4.7, lng: -74.02}
  });

  setMarkers(map);
}

// Data for the markers consisting of a name, a LatLng and a zIndex for the
// order in which these markers should display on top of each other.
var beaches = null ;

var shapes = {
    coords: [1, 1, 1, 20, 18, 20, 18, 1],
    type: 'poly'
  };
function setMarkers(map) {
 
  // Shapes define the clickable region of the icon. The type defines an HTML
  // <area> element 'poly' which traces out a polygon as a series of X,Y points.
  // The final coordinate closes the poly by connecting to the first coordinate.
  
   $.each(beaches, function(index,value){
          var latitud= value.posicionLatitud;
              var longitud=value.posicionLongitud;
              var nivelChoque=value.nivelChoque;
              var nivelPanico=value.nivelPanico;
              var nivelTemperatura=value.nivelTemperatura;
               var imagen="" ;
              
              if(nivelChoque>50){
               imagen="http://chart.apis.google.com/chart?chst=d_map_pin_icon&chld=caution|#00FFBF";
          }
          else
          {
             imagen="http://chart.apis.google.com/chart?chst=d_map_pin_icon&chld=bus|FFFF00";
          }
              
              
       var marker = new google.maps.Marker({
      position: {lat: latitud, lng: longitud},
      map: map,
      title: value.nombre,
      shape:shapes,
     
      icon:imagen,
        

      zIndex: index
      
    });
    
    var infowindow = new google.maps.InfoWindow({
    content: value.nombre
  });
  
  marker.addListener('click', function() {
    infowindow.open(map, marker);
  });
       
   });
  
 
}
    
    