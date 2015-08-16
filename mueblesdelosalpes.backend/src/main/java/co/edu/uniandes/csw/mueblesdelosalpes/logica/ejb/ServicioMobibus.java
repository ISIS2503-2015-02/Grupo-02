/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mueblesdelosalpes.logica.ejb;

import co.edu.uniandes.csw.mueblesdelosalpes.dto.Mobibus;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioMobibusLocal;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioPersistenciaMockLocal;
import co.edu.uniandes.csw.mueblesdelosalpes.persistencia.mock.ServicioPersistenciaMock;
import java.util.List;

/**
 *
 * @author pa.sarmiento10
 */
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
    
}
