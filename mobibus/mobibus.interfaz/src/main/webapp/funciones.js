/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//public/prueba.js
 function prueba()
    {
        
         
                
                $.ajax({
                    url: '../mueblesdelosalpes.servicios/webresources/Catalogo/muebles',
                    type : "GET",
                  
                    contentType: 'application/json',
                }).done(function(data) {
                    
                    
                    
                    
                    
                    
                    
                    
                    
                
                    console.log(data);
                }, this).error(function(data) {
                    alert(data);
                }, this);
        
        
    }