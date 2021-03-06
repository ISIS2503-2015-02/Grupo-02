/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mobibuses.servicios;

import co.edu.uniandes.csw.mobibuses.dto.EstacionVcub;
import co.edu.uniandes.csw.mobibuses.dto.Vcub;
import co.edu.uniandes.csw.mobibuses.excepciones.OperacionInvalidaException;
import co.edu.uniandes.csw.mobibuses.logica.interfaces.IServicioEstacionVcubMockLocal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author s.correa12
 */
@Path("/Estacion")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EstacionVcubService 
{

    @EJB
    private IServicioEstacionVcubMockLocal estacionesEjb;
    
    @GET
    @Path("estaciones/")
    public List<EstacionVcub> darEstaciones(@Context HttpHeaders headers)
    {
        return estacionesEjb.darEstacionesVcub();
    }
     @GET
    @Path("vcubes/")
     @PermitAll
    public List<Vcub> darVcubes(@Context HttpHeaders headers)
    {
        return estacionesEjb.darTodosVcub();
    }
    
    @PUT
    @Path("estacion/{id}/alquilar")
    public Vcub alquilarVcub(@PathParam("id") int id,@Context HttpHeaders headers)
    {
        try {
           return estacionesEjb.alquilarVcub(id);
        } catch (OperacionInvalidaException ex) {
            Logger.getLogger(EstacionVcubService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @PUT
    @Path("estacion/{id}/liberar/{idvcub}")
    public Vcub liberarVcub(@PathParam("id") int id, @PathParam("idvcub") int idvcub,@Context HttpHeaders headers)
    {
        try {
          return  estacionesEjb.liberarVcub(id, idvcub);
        } catch (OperacionInvalidaException ex) {
            Logger.getLogger(EstacionVcubService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     @GET
    @Path("vcubes/{id}")
    public List<Vcub> darVcubesEstacion(@PathParam("id") int idest,@Context HttpHeaders headers)
    {
        return estacionesEjb.darVcubesEstacion(idest);
    }
    
    @PUT
    @Path("estacion/{id}/reducir")
    public void reducirCapacidadEstacionEspecifica(@PathParam("id") int idest,@Context HttpHeaders headers)
    {
        estacionesEjb.reducirVcubesEspecifica(idest);
    }
    
    @PUT
    @Path("estacion/reducir")
    public void reducirCapacidadEstaciones(@Context HttpHeaders headers)
    {
        estacionesEjb.reducirVcubesTodas();
    }
     @GET
    @Path("vcubes/disponibles/{id}")
    public List<Vcub> darVcubesDisponiblesEstacion(@PathParam("id") int idest,@Context HttpHeaders headers)
    {
        return estacionesEjb.darVcubesDisponiblesEstacion(idest);
    }
    @GET
    @Path("vcubes/ocupados/{id}")
    public List<Vcub> darVcubesOcupadosEstacion(@PathParam("id") int idest,@Context HttpHeaders headers)
    {
        return estacionesEjb.darVcubesOcupadosEstacion(idest);
    }
    @GET
    @Path("vcubes/nodisponibles/{id}")
    public List<Vcub> darVcubesNoDisponiblesEstacion(@PathParam("id") int idest,@Context HttpHeaders headers)
    {
 
        return estacionesEjb.darVcubesNoDisponiblesEstacion(idest);
    }
    
     @PUT
    @Path("vcub/{id}/{longitud}_{latitud}")
    public Vcub cambiarPosVcub(@PathParam("id") int idest,@PathParam("longitud")double longi,@PathParam("latitud") double lati,@Context HttpHeaders headers)
    {
 
        return estacionesEjb.modificarPosVcub(idest, longi, lati);
    }
}
