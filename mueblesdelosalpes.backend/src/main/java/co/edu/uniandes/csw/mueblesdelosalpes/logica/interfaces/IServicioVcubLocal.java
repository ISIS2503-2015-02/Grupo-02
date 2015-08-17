/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces;

import co.edu.uniandes.csw.mueblesdelosalpes.dto.Vcub;
import co.edu.uniandes.csw.mueblesdelosalpes.excepciones.OperacionInvalidaException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author s.correa12
 */
@Local
public interface IServicioVcubLocal 
{
    
    public List<Vcub> darVcubes();
    
    public void alquilarVcub(int id)throws OperacionInvalidaException;
    
    public void liberarVcub(int id)throws OperacionInvalidaException;
    
}
