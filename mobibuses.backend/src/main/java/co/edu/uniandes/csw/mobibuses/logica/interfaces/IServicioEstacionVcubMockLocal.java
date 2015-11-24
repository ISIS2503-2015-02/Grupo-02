/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mobibuses.logica.interfaces;

import co.edu.uniandes.csw.mobibuses.dto.EstacionVcub;
import co.edu.uniandes.csw.mobibuses.dto.Vcub;
import co.edu.uniandes.csw.mobibuses.excepciones.OperacionInvalidaException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author s.correa12
 */
@Local
public interface IServicioEstacionVcubMockLocal 
{
    
    
    /**
     * interface
     * @return 
     */
    
    public List<EstacionVcub> darEstacionesVcub( );
    
    /**
     * interface
     * @param idestacion
     * @return 
     */
    
    
    public List<Vcub> darVcubesEstacion(int idestacion);
    
    /**
     * interface
     * @param token
     * @return 
     */
    
    public List<Vcub> darTodosVcub();
    

    /**
     * interface
     * @param idestacion
     * @return
     * @throws OperacionInvalidaException 
     */
    
    public Vcub alquilarVcub(int idestacion)throws OperacionInvalidaException;
    
    
    /**
     * interface
     * @param idestacion
     * @param iddevolver
     * @return
     * @throws OperacionInvalidaException 
     */
    
    public Vcub liberarVcub(int idestacion,int iddevolver) throws OperacionInvalidaException;
    
    /**
     * interface
     */
    
    public void reducirVcubesTodas( );
    
    
    /**
     * interface
     * @param idestacion
     */
    
    public void reducirVcubesEspecifica(int idestacion);
    
    /**
     * interface
     * @param idestacion
     * @param token
     * @return 
     */
    
    public List<Vcub> darVcubesDisponiblesEstacion(int idestacion);
    
    /**
     * interface
     * @param idestacion
     * @return 
     */
    
    public List<Vcub> darVcubesOcupadosEstacion(int idestacion);
    
    /**
     * interface
     * @param idestacion
     * @return 
     */
    
    public List<Vcub> darVcubesNoDisponiblesEstacion(int idestacion);
    
    /**
     * interface
     * @param idVcub
     * @param longitud
     * @param latitud
     * @return 
     */
    
    public Vcub modificarPosVcub(int idVcub, double longitud, double latitud);
}