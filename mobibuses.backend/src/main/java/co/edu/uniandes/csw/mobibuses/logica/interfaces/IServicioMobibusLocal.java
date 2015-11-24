/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mobibuses.logica.interfaces;

import co.edu.uniandes.csw.mobibuses.dto.Mobibus;
import co.edu.uniandes.csw.mobibuses.excepciones.OperacionInvalidaException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author pa.sarmiento10
 * @author sd.sarmiento3156
 */

@Local

public interface IServicioMobibusLocal {
    
    
    /**
     * interface
     * @return 
     */
    
    public List<Mobibus> darMobibuses();
    
  
     
     /**
      * interface
      * @param cordenada1
      * @param cordenada2
      * @return 
      */
     
     public Mobibus darMobibusMasCercano(double cordenada1, double cordenada2);
     
     /**
      * interface
      * @param cordenada1
      * @param cordenada2
      * @return 
      */
     
      public List<Mobibus> darMobibusMasCercanoBono(double cordenada1, double cordenada2);
      
      
      /**
       * interface
       * @param id
       * @throws OperacionInvalidaException 
       */
     
      public void alquilarMobibus(int id)  throws OperacionInvalidaException;
      
      
      /**
       * interface
       * @param id
       * @throws OperacionInvalidaException 
       */
      
      public void liberarMobibus(int id) throws OperacionInvalidaException;
      
      /**
       * interface
       * @param idMobibus
       * @param pDist
       * @param ptiempo 
       */
      
      public void agregarRuta(int idMobibus, int pDist, int ptiempo);
      
      /**
       * interface
       * @param idMobibus
       * @param idRuta
       */
      
      public void eliminarRuta(int idMobibus, int idRuta);
      
      /**
       * interface
       * @param id
       * @return 
       */
      
      public String darReporteRutas(int id);
      
      
      /**
       * interface
       * @param id
       * @param longi
       * @param lat
       * @return 
       */
      
      public Mobibus cambiarPosicion(int id,double longi , double lat);
      
      
      /**
       * interface
       * @param id
       * @param kilo

       * @return 
       */
      
      public Mobibus cambiarKilo(int id,double kilo);
     
}
