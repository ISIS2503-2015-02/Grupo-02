/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mueblesdelosalpes.logica.ejb;

import co.edu.uniandes.csw.mueblesdelosalpes.dto.Mobibus;
import co.edu.uniandes.csw.mueblesdelosalpes.dto.Vcub;
import co.edu.uniandes.csw.mueblesdelosalpes.excepciones.OperacionInvalidaException;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioMobibusLocal;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioPersistenciaMockLocal;
import co.edu.uniandes.csw.mueblesdelosalpes.persistencia.mock.ServicioPersistenciaMock;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author pa.sarmiento10
 * @author sd.sarmiento3156
 */
@Stateless
public class ServicioMobibus implements IServicioMobibusLocal{

    private IServicioPersistenciaMockLocal persistencia;

    public ServicioMobibus()
    {
        persistencia=new ServicioPersistenciaMock();
  
    }
    
    @Override
    public List<Mobibus> darMobibuses() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("pide los mobibuses");
     return persistencia.findAll(Mobibus.class);
    }
    
    
    
    
    @Override
    public Mobibus darMobibusMasCercano(double cordenada1, double cordenada2) {
    
        List<Mobibus> lista = darMobibuses();
        
        Mobibus rta=null;
        
        double menorDistanciaEncontrada =10000000;
        
        for(Mobibus m:lista)
        {
           double latitud= m.getposicionLatitud();
           double longitud=m.getposicionLongitud();
           
           double distancia= Math.sqrt((cordenada1-latitud)*(cordenada1-latitud)+(cordenada2-longitud)*(cordenada2-longitud));
           
           if(distancia<menorDistanciaEncontrada)
           {
               menorDistanciaEncontrada=distancia;
               rta=m;
           }
            
            
        }
                
        return rta;
    
    }

    @Override
    public void alquilarMobibus(int id) throws OperacionInvalidaException {
        Mobibus mb =(Mobibus) persistencia.findById(Mobibus.class, id);
        if(mb.getReservado()==false)
        {
            mb.setReservado(true);
        }
        else
        {
            throw new OperacionInvalidaException("El Mobibus con id "+id+ " se encuentra reservado.");
        }
    }

    @Override
    public void liberarMobibus(int id) throws OperacionInvalidaException {
         Mobibus mb =(Mobibus) persistencia.findById(Mobibus.class, id);
        if(mb.getReservado()==true)
        {
            mb.setReservado(false);
        }
        else
        {
            throw new OperacionInvalidaException("El Mobibus con id "+id+ " se encuentra desocupado.");
        }
    }
   
   
}
