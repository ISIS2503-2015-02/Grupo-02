
package co.edu.uniandes.csw.mobibuses.servicios;
import co.edu.uniandes.csw.mobibuses.dto.Tranvia;
import co.edu.uniandes.csw.mobibuses.logica.interfaces.IServicioTranviaLocal;
import java.util.List;
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

@Path("/Tranvia")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class TranviaService {
    
   private static final String TOKEN ="token";
    
     @EJB
    private IServicioTranviaLocal tranviaEjb;
    
    
     @GET
    @Path("tranvias/")
     
    public List<Tranvia> getTodosLosUsuarios(@Context HttpHeaders headers) 
    {    
       return tranviaEjb.darTranvias();
 
    }
    
    
    @PUT
    @Path("tranvias/cambiar/{id}/{emergencia}/{valor}")
    
    public void cambiarNiveleDeEmergencia(@PathParam("id")String id ,@PathParam("emergencia") int emergenci , @PathParam("valor")int valor, @Context HttpHeaders headers )
    {

        tranviaEjb.cambiarEstado(id, emergenci, valor);
        
    }
    
    @GET
    @Path("tranvias/generarReportes")
    public List<String> generarReporteDeTranvias( @Context HttpHeaders headers)
    {
   
        return tranviaEjb.generarReporte();
        
    }
    
    
      @PUT
    @Path("tranvias/cambiarCoor/{id}/{coordenada1}/{coordenada2}")
    public void cambiarCoordenadas(@PathParam("id") String id,@PathParam("coordenada1") double coordenada1,@PathParam("coordenada2")double coordenada2,@Context HttpHeaders headers)
    {
   
         tranviaEjb.cambiarCoord(id,coordenada1,coordenada2);

    }
    
    
    
}
