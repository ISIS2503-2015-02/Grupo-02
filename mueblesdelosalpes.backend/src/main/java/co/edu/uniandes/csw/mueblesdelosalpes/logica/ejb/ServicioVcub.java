/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mueblesdelosalpes.logica.ejb;

import co.edu.uniandes.csw.mueblesdelosalpes.dto.Vcub;
import co.edu.uniandes.csw.mueblesdelosalpes.excepciones.OperacionInvalidaException;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioPersistenciaMockLocal;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioVcubLocal;
import co.edu.uniandes.csw.mueblesdelosalpes.persistencia.mock.ServicioPersistenciaMock;
import java.util.List;

/**
 *
 * @author s.correa12
 */
public class ServicioVcub implements IServicioVcubLocal
{
    
    private IServicioPersistenciaMockLocal persistencia;

    public ServicioVcub() {
        this.persistencia = new ServicioPersistenciaMock();
    }

    
    
    @Override
    public List<Vcub> darVcubes() {
       return persistencia.findAll(Vcub.class);
    }

    @Override
    public void alquilarVcub(int id)  throws OperacionInvalidaException
    {
        Vcub vc =(Vcub) persistencia.findById(Vcub.class, id);
        if(vc.isOcupado()==false)
        {
            vc.setOcupado(true);
        }
        else
        {
            throw new OperacionInvalidaException("El VCub con id "+id+ " se encuentra ocupado.");
        }
    }

    @Override
    public void liberarVcub(int id)throws OperacionInvalidaException {
          Vcub vc =(Vcub) persistencia.findById(Vcub.class, id);
        if(vc.isOcupado()==true)
        {
            vc.setOcupado(false);
        }
        else
        {
            throw new OperacionInvalidaException("El VCub con id "+id+ " se encuentra desocupado.");
        }
    }
    
    
    
}
