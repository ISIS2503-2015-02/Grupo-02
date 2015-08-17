/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mueblesdelosalpes.logica.ejb;

import co.edu.uniandes.csw.mueblesdelosalpes.dto.Tranvia;
import co.edu.uniandes.csw.mueblesdelosalpes.dto.Usuario;
import co.edu.uniandes.csw.mueblesdelosalpes.dto.Vcub;
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
    
     
     return persistencia.findAll(Tranvia.class);
    
    }

    @Override
    public void cambiarEstado(String id, int emergencia, int valor) {
       
   Tranvia tranvia =(Tranvia) persistencia.findById(Tranvia.class, id);
        
         //modifico el nivel de choque
        if(emergencia==1)
        {
            tranvia.setNivelChoque(valor);
            
        }
        
        //modifico el nivel de temperatura
        if(emergencia==2)
        {
            tranvia.setNivelTemparatura(valor);
        }
        
        // el boton de panico
        else{
            
            tranvia.setNivelPanico(valor);
            
        }
        
    }

   
    
    
    
    
    
}
