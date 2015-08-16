/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mueblesdelosalpes.servicios;

import co.edu.uniandes.csw.mueblesdelosalpes.dto.Vcub;
import co.edu.uniandes.csw.mueblesdelosalpes.excepciones.OperacionInvalidaException;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioVcubLocal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author s.correa12
 */
@Path("/Vcub")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VcubService {
    @EJB
    private IServicioVcubLocal vcubEjb;
    
    @GET
    @Path("vcubes/")
    public List<Vcub> getTodosVcubes()
    {
       return vcubEjb.darVcubes();
    }
    
    @PUT
    @Path("vcubes/{id}")
    public void alquilarVcub(@PathParam("id") int id)
    {
        try {
            vcubEjb.alquilarVcub(id);
        } catch (OperacionInvalidaException ex) {
            Logger.getLogger(VcubService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     @PUT
    @Path("vcubes/{id}")
    public void liberarVcub(@PathParam("id") int id)
    {
        try {
            vcubEjb.liberarVcub(id);
        } catch (OperacionInvalidaException ex) {
            Logger.getLogger(VcubService.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
