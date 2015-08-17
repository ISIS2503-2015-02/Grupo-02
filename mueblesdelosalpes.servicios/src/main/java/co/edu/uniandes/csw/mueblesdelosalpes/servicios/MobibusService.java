/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mueblesdelosalpes.servicios;

import co.edu.uniandes.csw.mueblesdelosalpes.dto.Mobibus;
import co.edu.uniandes.csw.mueblesdelosalpes.dto.Tranvia;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioMobibusLocal;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioTranviaLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author pa.sarmiento10
 */
@Path("/mobibus")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class MobibusService {
    
     @EJB
    private IServicioMobibusLocal mobibusEjb;
    
    
     @GET
    @Path("mobibuses/")
     
    public List<Mobibus> getTodosLosUsuarios() {
        
      
       return mobibusEjb.darMobibuses();
 
    }
    
    
    
    
}
