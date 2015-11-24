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
                    url: '../mobibuses.servicios/webresources/Tranvia/tranvias',
                    type : "GET",
                  
                    contentType: 'application/json',
                }).done(function(data) {
                    
                   
                    
                    verRutasTranvia(data);
                   
                 
                    
                
                    console.log(data);
                }, this).error(function(data) {
                    alert(data);
                }, this);
        
        
    }
    
   
   
     function crearMapaMobibusesBono(data,coor1,coor2)
    {
          var map = new google.maps.Map(document.getElementById('map'), {
                  zoom: 11    ,
                  center: {lat: 4.598889 , lng:  -74.080833}
                });
                
                
      
   
    
                marcarMobibusesBon(map,data,coor1,coor2);
    }
   
    
    function crearMapaMobibuses(data)
    {
          var map = new google.maps.Map(document.getElementById('map'), {
                  zoom: 11    ,
                  center: {lat: 4.598889 , lng:  -74.080833}
                });
                
                
      
   
    
                marcarMobibuses(map,data);
    }
    
    
    function verMobibusesMasCercanoUsuario(){
        
          if (navigator.geolocation) {
         //pongo en el parametro el nombre que quiera utilizar 
        navigator.geolocation.getCurrentPosition(ubicacion);
        
          }
        
    }
    
    
    function marcarMobibuses(map,data)
    {
        
        $.each(data, function(index,value){
          var latitud= value.posicionLatitud;
              var longitud=value.posicionLongitud;
              
               var imagen="" ;
              var contenido="";
              
    
          
             contenido=value.nombre;
             imagen="http://chart.apis.google.com/chart?chst=d_map_pin_icon&chld=bus|FFFF00";
          
              
              
       var marker = new google.maps.Marker({
      position: {lat: latitud, lng: longitud},
      map: map,
      title: value.nombre,
      shape:shapes,
     
      icon:imagen,
        

      zIndex: index
      
    });
    
    var infowindow = new google.maps.InfoWindow({
    content:contenido 
        });
  
  marker.addListener('click', function() {
    infowindow.open(map, marker);
  });
       
   });
        
        
    }
    
    
    
     
    function marcarMobibusesBon(map,data , coor1, coor2)
    {
                 
       var marker = new google.maps.Marker({
      position: {lat: coor1, lng: coor2},
      map: map,
    
      shape:shapes,
     
   
      
    });
    

  
        
        
        
        
        
        
        
        
        
        
        
        
        $.each(data, function(index,value){
          var latitud= value.posicionLatitud;
              var longitud=value.posicionLongitud;
              
               var imagen="" ;
              var contenido="";
              
    
          
             contenido=value.nombre;
             imagen="http://chart.apis.google.com/chart?chst=d_map_pin_icon&chld=bus|FFFF00";
          
              
              
       var marker = new google.maps.Marker({
      position: {lat: latitud, lng: longitud},
      map: map,
      title: value.nombre,
      shape:shapes,
     
      icon:imagen,
        

      zIndex: index
      
    });
    
    var infowindow = new google.maps.InfoWindow({
    content:contenido 
        });
  
  marker.addListener('click', function() {
    infowindow.open(map, marker);
  });
       
   });
        
        
    }
    
    
    function verMobibuses()
    {
        
        $.ajax({
                    url: '../mobibuses.servicios/webresources/mobibus/mobibuses',
                    type : "GET",
                  
                    contentType: 'application/json',
                }).done(function(data) {
                    
                   
                    crearMapaMobibuses(data);
                    
                   
                 
                    
                
                    console.log(data);
                }, this).error(function(data) {
                    alert(data);
                }, this);
        
        
        
        
        
    }
    
    function direccion( coo1,coo2 , coo3,coo4) {
  var directionsDisplay = new google.maps.DirectionsRenderer;
  var directionsService = new google.maps.DirectionsService;
  var map = new google.maps.Map(document.getElementById('map'), {
    zoom: 14,
       center: {lat: coo1, lng: coo2}
  });
  directionsDisplay.setMap(map);

  calculateAndDisplayRoute(directionsService, directionsDisplay,coo1,coo2,coo3,coo4);
  
}

function posicionActual()
{
    
     if (navigator.geolocation) {
         //pongo en el parametro el nombre que quiera utilizar 
        navigator.geolocation.getCurrentPosition(ubicacion);
    } 
    
}

function ubicacion(coordenadas)
{
   
     var latitud = coordenadas.coords.latitude;
     var longitud=coordenadas.coords.longitude;
     
     busquedaMasCercano(latitud,longitud);
     
     //llamar al metodo que quiera con estas variables 
    
}

    
    function verRutasTranvia(data) {
        
        
    
      
        
                var map = new google.maps.Map(document.getElementById('map'), {
                  zoom: 13    ,
                  center: {lat: 4.598889 , lng:  -74.080833}
                });
                
                var flightPlanCoordinates = [
    {lat: 4.43, lng: -74.068},
    {lat: 4.84, lng: -74.068}
    
  ];
  var flightPlanCoordinates2 = [
    {lat: 4.63, lng: -74.001},
    {lat: 4.63, lng: -74.214}
    
  ];
  var flightPlanCoordinates3 = [
    {lat: 4.69, lng: -74.001},
    {lat: 4.69, lng: -74.214}
    
  ];
  var flightPath = new google.maps.Polyline({
    path: flightPlanCoordinates,
    geodesic: true,
    strokeColor: '#FF0000',
    strokeOpacity: 1.0,
    strokeWeight: 2
  });
    var flightPath3 = new google.maps.Polyline({
    path: flightPlanCoordinates3,
    geodesic: true,
    strokeColor: '#FF0000',
    strokeOpacity: 1.0,
    strokeWeight: 2
  });
  var flightPath2 = new google.maps.Polyline({
    path: flightPlanCoordinates2,
    geodesic: true,
    strokeColor: '#FF0000',
    strokeOpacity: 1.0,
    strokeWeight: 2
  });

  flightPath.setMap(map);
  flightPath2.setMap(map);
  flightPath3.setMap(map);
      
   
    
                setMarkers(map,data);
        
  
}

// Data for the markers consisting of a name, a LatLng and a zIndex for the
// order in which these markers should display on top of each other.
var beaches = null ;

var shapes = {
    coords: [1, 1, 1, 20, 18, 20, 18, 1],
    type: 'poly'
  };
  
  
  function busquedaMasCercanoBon(coordenada1,coordenada2)
  {
      $.ajax({
                    url: '../mobibuses.servicios/webresources/mobibus/mobibusesBon/'+coordenada1+"/"+coordenada2,
                    type : "GET",
                  
                    contentType: 'application/json',
                }).done(function(data) {
                    
                   
                    
                   crearMapaMobibusesBono(data,coordenada1,coordenada2);
                   
                 
                    
                
                    console.log(data);
                }, this).error(function(data) {
                    alert(data);
                }, this);
        
      
      
      
  }
  
  function busquedaMasCercano(coordenada1,coordenada2)
  {
      
      
      
       $.ajax({
                    url: '../mobibuses.servicios/webresources/mobibus/mobibuses/'+coordenada1+"/"+coordenada2,
                    type : "GET",
                    
                    
                  
                    contentType: 'application/json',
                }).done(function(data) {
                    
                   
                    
                          
                          var latitud=data.posicionLatitud;
                          var longitud = data.posicionLongitud;
                          
                          direccion(coordenada1,coordenada2,latitud,longitud);
                          
                          
                      
                   
                 
                    
                
                    console.log(data);
                }, this).error(function(data) {
                    alert(data);
                }, this);
        
      
      
      
  }
  function acercarEmergencia(coor1,coor2)
  {
     
                $.ajax({
                    url: '../mobibuses.servicios/webresources/Tranvia/tranvias',
                    type : "GET",
                  
                    contentType: 'application/json',
                }).done(function(data) {
                    
                   
                    
                    acercarEmergencia2(coor1,coor2,data);
                   
                 
                    
                
                    console.log(data);
                }, this).error(function(data) {
                    alert(data);
                }, this);
        
  }
  
  function acercarEmergencia2(coor1,coor2,data)
  {
     var map = new google.maps.Map(document.getElementById('map'), {
                  zoom: 15    ,
                  center: {lat: coor1 , lng:  coor2}
                });
                
                
      
   
    
                setMarkers(map,data);
  }
  
function setMarkers(map,data) {
 
  // Shapes define the clickable region of the icon. The type defines an HTML
  // <area> element 'poly' which traces out a polygon as a series of X,Y points.
  // The final coordinate closes the poly by connecting to the first coordinate.
  
  
   document.getElementById('directionsPanel').innerHTML=" <h2><strong> <font color=\"white\">Tranvias en estado de emergencia </font>  </strong> </h2>";
    
  
   $.each(data, function(index,value){
          var latitud= value.posicionLatitud;
              var longitud=value.posicionLongitud;
              var nivelChoque=value.nivelChoque;
              var nivelPanico=value.nivelPanico;
              var nivelTemperatura=value.nivelTemparatura;
               var imagen="" ;
              var contenido="";
                
              
          if(nivelChoque>50 || nivelPanico>50 || nivelTemperatura>50)
          {
               imagen="http://chart.apis.google.com/chart?chst=d_map_pin_icon&chld=caution|#00FFBF";
               contenido="el vehiculo "+value.nombre+" se encuentra en estado de emergencia"+"<p>"+"<button name=\"busquedaMasCercano\" id=\"busquedaMasCercano\" onclick=\"busquedaMasCercano("+latitud+","+longitud+"); return false;\"> Buscar bus mas cercano </button>";
               contenido+="<p> <button name=\"busquedaMasCercanoBon\" id=\"busquedaMasCercanoBon\" onclick=\"busquedaMasCercanoBon("+latitud+","+longitud+"); return false;\"> Buscar 3 buses mas cercano </button>";
           document.getElementById('directionsPanel').innerHTML+="<input type=image src=\"images/lupa.png\" name=\"acercarEmergencia\" id=\"acercarEmergencia\" onclick=\"acercarEmergencia("+latitud+","+longitud+"); return false;\">  ";
          
           document.getElementById('directionsPanel').innerHTML+="<font color=\"white\" >" +  value.nombre  + "   </font> <p>" ;
               }
          else
          {
             contenido="Nombre Tranvia: "+value.nombre+"<p>";
             contenido+="Conducido por: " + value.nombreConductor;
             contenido+="Kilomatros desde ultima revicion: "+value.kilometraje;
             imagen="http://chart.apis.google.com/chart?chst=d_map_pin_icon&chld=bus|FFFF00";
          }
              
              
       var marker = new google.maps.Marker({
      position: {lat: latitud, lng: longitud},
      map: map,
      title: value.nombre,
      shape:shapes,
     
      icon:imagen,
        panel: document.getElementById('directionsPanel'),

      zIndex: index
      
    });
    
    
    
     
    
    var infowindow = new google.maps.InfoWindow({
    content:contenido 
        });
  
  marker.addListener('click', function() {
    infowindow.open(map, marker);
  });
       
   });
  
 
}

function graficasyReporte(data)
{
    
      var latitud=data;
                          var rta="<font color=\"white\"> <h2> Reporte </h2> </font> ";
                          rta+="<br> <br>";
                          var promedios="";
                          var veces=0 ;
                          var masRapidoA ;
                          var masRapidoB ;
                          var masRapidoC ;
                          
                           var proA ;
                          var proB ;
                          var proC ;
                          
                          
                          var menosRapidoA ;
                          var menosRapidoB ;
                          var menosRapidoC ;
                          
                          $.each(data, function(index,value){
                         
                  
                        
                           var n = value.includes("mas efectivo");
                           var d = value.includes("menos efectivo")
                            var e = value.includes("El trayecto A")
                            
                            
                            if(veces<4)
                            {
                                promedios+= "<font color=\"white\"> <h4 align=\"center\" > "+value+" </h4> </font> ";
                                veces++;
                            }
                            
                            if(e)
                            {
                                 var res = value.split(" ");
                             proA=res[4];   
                           
                            }
                            
                              var f = value.includes("El trayecto B")
                            
                            if(f)
                            {
                             var res = value.split(" ");
                             proB=res[4]; 
                            }
                            
                              var g = value.includes("El trayecto C")
                            
                            if(g)
                            {
                             var res = value.split(" ");
                             proC=res[4];   
                            }
                           
                           if(n)
                              {
                                  if(value.includes("ruta A"))
                                   {
                                        
                                        
                                        
                                        var res = value.split(" ");
                                        masRapidoA= parseFloat(res[17]) ;
                                        //rta+=res[17] ;
                                        // rta+=value ;
                                        
                                   }
                                   if(value.includes("ruta B"))
                                   {
                                        
                                        
                                        
                                        var res = value.split(" ");
                                        masRapidoB=parseFloat(res[17]) ;
                                        //rta+=res[17] ;
                                        
                                   }
                                   if(value.includes("ruta C"))
                                   {
                                        
                                        
                                        
                                        var res = value.split(" ");
                                        masRapidoC=parseFloat(res[17]) ;
                                        //rta+=res[17] ;
                                        
                                   }
                                   
                                 
                              } 
                              
                              
                              if(d)
                              {
                                  if(value.includes("ruta A"))
                                   {
                                        
                                        
                                        
                                        var res = value.split(" ");
                                        menosRapidoA=parseFloat(res[17]) ;
                                        //rta+=res[17] ;
                                        
                                   }
                                   if(value.includes("ruta B"))
                                   {
                                        
                                        
                                        
                                        var res = value.split(" ");
                                        menosRapidoB=parseFloat(res[17]) ;
                                        //rta+=res[17] ;
                                        
                                   }
                                   if(value.includes("ruta C"))
                                   {
                                        
                                        
                                        
                                        var res = value.split(" ");
                                        menosRapidoC=parseFloat(res[17]) ;
                                        //rta+=res[17] ;
                                         //rta+=value ;
                                   }
                                   
                                 
                              } 
                           
                           
                           
                     });
                     
                     
                     
                     
                     var a3 = parseFloat(proA);
                     var b3 = parseFloat(proB);
                     var c3 = parseFloat(proC);
                     
                     var suma3= a3+b3+c3 ;
                      var pproA = a3*100/(suma3);
                          var pproB= b3*100/(suma3);
                          var pproC =c3*100/(suma3);;
                          
                          
                          
                                   
                                 
                                   
                                   
                                   
                          
                     
                     rta+="<h2 align=\"center\" > Cantidad de problemas por ruta</h2>" ;
                     rta+="<meta http-equiv=\"content-type\" content=\"text/html; charset=ISO-8859-1\">";
                     rta+="<table align=\"center\" cellpadding=\"2\" cellspacing=\"2\" border=\"0\"> <tbody align=\"center\"><tr>";
                     rta+="<td valign=\"bottom\"><div class=\"barrasv\" style=\"height:"+pproA+"px; background-color:#BDDA4C\">&nbsp;</div></td>";
                     rta+="<td valign=\"bottom\"><div class=\"barrasv\" style=\"height:"+pproB+"px; background-color:#FF9A68\">&nbsp;</div></td>";
                     rta+="<td valign=\"bottom\"><div class=\"barrasv\" style=\"height:"+pproC+"px; background-color:#69ABBF\">&nbsp;</div></td>";
                     rta+=" </tr> <tr>";
                     rta+="<td>"+proA+"</td>";
                     rta+="<td>"+proB+"</td>";
                     rta+="<td>"+proC+"</td>";
                     rta+=" </tr><tr>";
                     rta+="<td><strong><div class=\"verticalmente\">Ruta A</div></strong></td>";
                     rta+="<td><strong><div class=\"verticalmente\">Ruta B</div></strong></td>";
                     rta+="<td><strong><div class=\"verticalmente\">Ruta C</div></strong></td>";
                     rta+=" </tr></tbody></table><br><br><br> <br> <br>  <br> <br>";
                     
                     
                  
                     var a = parseFloat(masRapidoA);
                     var b = parseFloat(masRapidoB);
                     var c = parseFloat(masRapidoC);
                     
                     var suma= a+b+c ;
                      var pmasRapidoA = a*200/(suma);
                          var pmasRapidoB= b*200/(suma);
                          var pmasRapidoC =c*200/(suma);;
                          
                          
                             masRapidoA=masRapidoA.toFixed(3);
                              masRapidoB=  masRapidoB.toFixed(3);
                                   masRapidoC=masRapidoC.toFixed(2);
                                   
                                   
                                 
                                   
                                   
                                   
                          
                     
                     rta+="<h2 align=\"center\" > Tiempo conductor mas efectivo por ruta </h2>" ;
                     rta+="<meta http-equiv=\"content-type\" content=\"text/html; charset=ISO-8859-1\">";
                     rta+="<table align=\"center\" cellpadding=\"2\" cellspacing=\"2\" border=\"0\"> <tbody align=\"center\"><tr>";
                     rta+="<td valign=\"bottom\"><div class=\"barrasv\" style=\"height:"+pmasRapidoA+"px; background-color:#BDDA4C\">&nbsp;</div></td>";
                     rta+="<td valign=\"bottom\"><div class=\"barrasv\" style=\"height:"+pmasRapidoB+"px; background-color:#FF9A68\">&nbsp;</div></td>";
                     rta+="<td valign=\"bottom\"><div class=\"barrasv\" style=\"height:"+pmasRapidoC+"px; background-color:#69ABBF\">&nbsp;</div></td>";
                     rta+=" </tr> <tr>";
                     rta+="<td>"+masRapidoA+"</td>";
                     rta+="<td>"+masRapidoB+"</td>";
                     rta+="<td>"+masRapidoC+"</td>";
                     rta+=" </tr><tr>";
                     rta+="<td><strong><div class=\"verticalmente\">Ruta A</div></strong></td>";
                     rta+="<td><strong><div class=\"verticalmente\">Ruta B</div></strong></td>";
                     rta+="<td><strong><div class=\"verticalmente\">Ruta C</div></strong></td>";
                     rta+=" </tr></tbody></table><br><br><br> <br> <br>  <br> <br>";
                     
                     
                     
                     
                     
                     var a2 = parseFloat(menosRapidoA);
                     var b2 = parseFloat(menosRapidoB);
                     var c2 = parseFloat(menosRapidoC);
                     
                     var suma2= a2+b2+c2 ;
                      var pmenosRapidoA = a2*200/(suma2);
                          var pmenosRapidoB= b2*200/(suma2);
                          var pmenosRapidoC =c2*200/(suma2);;
                          
                          
                          menosRapidoA=menosRapidoA.toFixed(3);
                              menosRapidoB=  menosRapidoB.toFixed(3);
                                   menosRapidoC=menosRapidoC.toFixed(2);
                          
                          
                     
                     rta+="<h2 align=\"center\" > Tiempo conductor menos efectivo por ruta </h2>" ;
                     rta+="<meta http-equiv=\"content-type\" content=\"text/html; charset=ISO-8859-1\">";
                     rta+="<table align=\"center\" cellpadding=\"2\" cellspacing=\"2\" border=\"0\"> <tbody align=\"center\"><tr>";
                     rta+="<td valign=\"bottom\"><div class=\"barrasv\" style=\"height:"+pmenosRapidoA+"px; background-color:#BDDA4C\">&nbsp;</div></td>";
                     rta+="<td valign=\"bottom\"><div class=\"barrasv\" style=\"height:"+pmenosRapidoB+"px; background-color:#FF9A68\">&nbsp;</div></td>";
                     rta+="<td valign=\"bottom\"><div class=\"barrasv\" style=\"height:"+pmenosRapidoC+"px; background-color:#69ABBF\">&nbsp;</div></td>";
                     rta+=" </tr> <tr>";
                     rta+="<td>"+menosRapidoA+"</td>";
                     rta+="<td>"+menosRapidoB+"</td>";
                     rta+="<td>"+menosRapidoC+"</td>";
                     rta+=" </tr><tr>";
                     rta+="<td><strong><div class=\"verticalmente\">Ruta A</div></strong></td>";
                     rta+="<td><strong><div class=\"verticalmente\">Ruta B</div></strong></td>";
                     rta+="<td><strong><div class=\"verticalmente\">Ruta C</div></strong></td>";
                     rta+=" </tr></tbody></table><br><br><br> <br> <br>  <br> <br>";
                     
                     
                     
                     rta+=promedios;
                     
                     
                     
               
                     
                     
                     
                       document.getElementById("reporte").innerHTML=rta;    
    
}

function generarReporte()
{
    
    
       $.ajax({
                    url: '../mobibuses.servicios/webresources/Tranvia/tranvias/generarReportes',
                    type : "GET",
                    
                    
                  
                     contentType: 'application/json',
                }).done(function(data) {
                    
                   
                    graficasyReporte(data);
                          
                        
                          
                          
                          
                      
                   
                 
                    
                
                    console.log(data);
                }, this).error(function(data) {
                    alert(data);
                }, this);
    
    
    
    
}

function calculateAndDisplayRoute(directionsService, directionsDisplay , lat1,ing1,lat2,ing2) {
  var selectedMode = "DRIVING";
  var latitud1=lat1;
   var longitud1=ing1;
   var latitud2=lat2;
    var longitud2=ing2;
  directionsService.route({
    origin: {lat: lat1, lng: ing1},  // Haight.
    destination: {lat: lat2, lng: ing2},  // Ocean Beach.

    // Note that Javascript allows us to access the constant
    // using square brackets and a string value as its
    // "property."
    travelMode: google.maps.TravelMode[selectedMode]
  }, function(response, status) {
    if (status == google.maps.DirectionsStatus.OK) {
      directionsDisplay.setDirections(response);
    } else {
      window.alert('Directions request failed due to ' + status);
    }
  });
}

function cambiarEstadoTranvia()
{
    var identificador=document.getElementById('nombreTranvia').value;
    var emer=document.getElementById('emergenciaTranvia').value;
    var numero=document.getElementById('valorTranvia').value;
    
     $.ajax({
                    url: '../mobibuses.servicios/webresources/Tranvia/tranvias/cambiar/'+identificador+"/"+emer+"/"+numero,
                    type : "PUT",
                  
                    contentType: 'application/json',
                }).done(function(data) {
                    
                   var x =emer;
                    
                    verRutasTranvia();
                   
                 
                    
                
                    console.log(data);
                }, this).error(function(data) {
                    alert(data);
                }, this);
}


function handleLocationError(browserHasGeolocation, infoWindow, pos) {
  infoWindow.setPosition(pos);
  infoWindow.setContent(browserHasGeolocation ?
                        'Error: The Geolocation service failed.' :
                        'Error: Your browser doesn\'t support geolocation.');
}
    

   
    
   