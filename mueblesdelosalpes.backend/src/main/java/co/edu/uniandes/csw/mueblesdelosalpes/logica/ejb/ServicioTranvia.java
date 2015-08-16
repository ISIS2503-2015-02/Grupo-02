/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mueblesdelosalpes.logica.ejb;

import co.edu.uniandes.csw.mueblesdelosalpes.dto.Tranvia;
import co.edu.uniandes.csw.mueblesdelosalpes.dto.Usuario;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioPersistenciaMockLocal;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioTranviaLocal;
import co.edu.uniandes.csw.mueblesdelosalpes.persistencia.mock.ServicioPersistenciaMock;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author fj.ricaurte10
 */

@Stateless
public class ServicioTranvia implements IServicioTranviaLocal{

    
    private IServicioPersistenciaMockLocal persistencia;

    public ServicioTranvia()
    {
        persistencia=new ServicioPersistenciaMock();
  
    }
    
    
    
    @Override
    
    
    public List<Tranvia> darTranvias() {
    
        System.out.println("pide los tranvia");
     return persistencia.findAll(Tranvia.class);
    
    }
    
    
    
    
    
}
