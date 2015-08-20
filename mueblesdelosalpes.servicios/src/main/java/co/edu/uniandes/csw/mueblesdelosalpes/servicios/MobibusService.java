/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mueblesdelosalpes.servicios;

import co.edu.uniandes.csw.mueblesdelosalpes.dto.Mobibus;
import co.edu.uniandes.csw.mueblesdelosalpes.dto.Ruta;
import co.edu.uniandes.csw.mueblesdelosalpes.dto.Tranvia;
import co.edu.uniandes.csw.mueblesdelosalpes.excepciones.OperacionInvalidaException;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioMobibusLocal;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioTranviaLocal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    
    @GET
    @Path("mobibuses/{coordenada1}/{coordenada2}")
    
    public Mobibus darMobiBusMasCercanoA(@PathParam("coordenada1") double coordenada1,@PathParam("coordenada2")double coordenada2)
    {
        
        return mobibusEjb.darMobibusMasCercano(coordenada1, coordenada2);
        
    }
    
    @PUT
    @Path("mobibuses/{id}/alquilar")
    public void alquilarMobibus(@PathParam("id") int id)
    {
        try {
            mobibusEjb.alquilarMobibus(id);
        } catch (OperacionInvalidaException ex) {
            Logger.getLogger(MobibusService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     @PUT
    @Path("mobibuses/{id}/liberar")
    public void liberarMobibus(@PathParam("id") int id)
    {
        try {
            mobibusEjb.liberarMobibus(id);
        } catch (OperacionInvalidaException ex) {
            Logger.getLogger(MobibusService.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    @POST 
    @Path("mobibuses/{id}/{distancia}/{tiempo}/agregarRuta")
    public void agregarRuta(@PathParam("id") int id,@PathParam("distancia") int pDist,@PathParam("tiempo") int pTiempo)
    {
        mobibusEjb.agregarRuta(id, pDist, pTiempo); 
    }
    
    @PUT 
    @Path("mobibuses/{id}/{id2}/eliminarRuta")
    public void eliminarRuta(@PathParam("id") int idMobibus,@PathParam("id2") int idRuta)
    {
        mobibusEjb.eliminarRuta(idMobibus, idRuta); 
    }
    
    @GET
    @Path("mobibuses/{id}/reporteRutas")
    public String generarReporteRutas(@PathParam("id") int id)
    {
        
        return mobibusEjb.darReporteRutas(id);
        
    }
    
}
