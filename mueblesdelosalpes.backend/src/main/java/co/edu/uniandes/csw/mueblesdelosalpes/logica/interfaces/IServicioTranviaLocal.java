/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces;

import co.edu.uniandes.csw.mueblesdelosalpes.dto.Tranvia;
import co.edu.uniandes.csw.mueblesdelosalpes.dto.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fj.ricaurte10
 */

@Local

public interface IServicioTranviaLocal {
    
    public List<Tranvia> darTranvias();
    
    
    
}