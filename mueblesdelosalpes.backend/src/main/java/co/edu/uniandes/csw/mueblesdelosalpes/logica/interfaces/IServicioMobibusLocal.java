/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces;

import co.edu.uniandes.csw.mueblesdelosalpes.dto.Mobibus;
import co.edu.uniandes.csw.mueblesdelosalpes.dto.Ruta;
import co.edu.uniandes.csw.mueblesdelosalpes.dto.Tranvia;
import co.edu.uniandes.csw.mueblesdelosalpes.excepciones.OperacionInvalidaException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author pa.sarmiento10
 * @author sd.sarmiento3156
 */

@Local

public interface IServicioMobibusLocal {
     public List<Mobibus> darMobibuses();
     
     public Mobibus darMobibusMasCercano(double cordenada1, double cordenada2);
     
      public void alquilarMobibus(int id)  throws OperacionInvalidaException;
      
      public void liberarMobibus(int id) throws OperacionInvalidaException;
      
      public void agregarRuta(int idMobibus, int pDist, int Ptiempo);
      
      public void eliminarRuta(int idMobibus, int idRuta);
      
      public String darReporteRutas(int id);
     
}
