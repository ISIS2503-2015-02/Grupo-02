/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mueblesdelosalpes.logica.ejb;

import co.edu.uniandes.csw.mueblesdelosalpes.dto.EstacionVcub;
import co.edu.uniandes.csw.mueblesdelosalpes.dto.Vcub;
import co.edu.uniandes.csw.mueblesdelosalpes.excepciones.OperacionInvalidaException;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioEstacionVcubMockLocal;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioPersistenciaMockLocal;
import co.edu.uniandes.csw.mueblesdelosalpes.persistencia.mock.ServicioPersistenciaMock;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author s.correa12
 */
@Stateless
public class ServicioEstacionVcub implements IServicioEstacionVcubMockLocal{

     private IServicioPersistenciaMockLocal persistencia;

    public ServicioEstacionVcub() {
         this.persistencia = new ServicioPersistenciaMock();
    }
     
    @Override
    public List<EstacionVcub> darEstacionesVcub()
    {
        return persistencia.findAll(EstacionVcub.class);
    }

    @Override
    public List<Vcub> darVcubesEstacion(int IDestacion) {
        EstacionVcub evc= (EstacionVcub) persistencia.findById(EstacionVcub.class, IDestacion);
        return evc.getVcubsEstacion();
    }

    @Override
    public List<Vcub> darTodosVcub() {
        ArrayList<Vcub> vcubes = new ArrayList<Vcub>();
        ArrayList<EstacionVcub> estsvc= (ArrayList<EstacionVcub>) persistencia.findAll(EstacionVcub.class);
         for (EstacionVcub actual : estsvc) {
             vcubes.addAll(actual.getVcubsEstacion());
         }
        return vcubes;
    }

    @Override
    public Vcub alquilarVcub(int IDestacion) throws OperacionInvalidaException
    {
                 EstacionVcub est = (EstacionVcub) persistencia.findById(EstacionVcub.class, IDestacion);
                Vcub resp = null;
                 ArrayList<Vcub> vcubes = est.getVcubsEstacion();
         for (Vcub actual : vcubes) {
             if(actual.isOcupado().equals(Vcub.DISPONIBLE))
             {
                 actual.setOcupado(Vcub.OCUPADO);
                 resp = actual;
                 est.setPrestados(est.getPrestados()+1);
                 break;
             }
         }
                 if(resp == null)
                 {
                     throw new OperacionInvalidaException("No hay vcubs disponibles en la estacion: "+ IDestacion);
                 }
                 else if(resp!=null && est.getPrestados()==(int)(est.getVcubsEstacion().size()*(0.1)))
                 {
                     for (Vcub actual : vcubes) {
                         if(actual.isOcupado().equals(Vcub.NO_DISPONIBLE))
                         {
                             actual.setOcupado(Vcub.DISPONIBLE);
                         }
                     }
                 }
                 return resp;
                
    }

    @Override
    public Vcub liberarVcub(int IDestacion,int IDdevolver) throws OperacionInvalidaException 
    {
        EstacionVcub estacion = (EstacionVcub) persistencia.findById(EstacionVcub.class, IDestacion);
        Vcub devolver = (Vcub) persistencia.findById(Vcub.class, IDdevolver);
        EstacionVcub dondeSeAlquilo = (EstacionVcub) persistencia.findById(EstacionVcub.class, devolver.getEstacion());
        Vcub devuelto =null;
        if(dondeSeAlquilo.getId()==estacion.getId())
        {
            ArrayList<Vcub> vcubes = estacion.getVcubsEstacion();
            for (Vcub vc : vcubes) {
                if(vc.getId()==devolver.getId())
                {
                    devuelto=vc;
                    vc.setOcupado(Vcub.DISPONIBLE);
                    estacion.setPrestados(estacion.getPrestados()-1);
                    persistencia.update(vc);
                    break;
                }
            }
        }
        else
        {
            ArrayList<Vcub> nueva  =estacion.getVcubsEstacion();
            ArrayList<Vcub> vieja = ((EstacionVcub) persistencia.findById(EstacionVcub.class, devolver.getEstacion())).getVcubsEstacion();
            vieja.remove(devolver);
            devolver.setOcupado(Vcub.DISPONIBLE);
            devolver.setEstacion(estacion.getId());
            EstacionVcub ant =(EstacionVcub) persistencia.findById(EstacionVcub.class, devolver.getEstacion());
            ant.setPrestados(ant.getPrestados()-1);
            nueva.add(devolver);
            devuelto = devolver;
            persistencia.update(devolver);
        }
        if(devuelto == null)
        {
            throw new OperacionInvalidaException("No de devolvio");
        }
        return devuelto;
    }

    @Override
    public void reducirVcubesTodas() {
    ArrayList<EstacionVcub> estaciones =(ArrayList<EstacionVcub>) persistencia.findAll(EstacionVcub.class);
            {
        for (EstacionVcub est : estaciones) {
            int numero30 = (int) (est.getVcubsEstacion().size()*(0.3));
            int j = 0 ;
            int index = 0 ;
            ArrayList<Vcub> vcubes = est.getVcubsEstacion();
            while(j<=numero30 && index<vcubes.size())
            {
                Vcub actual = vcubes.get(index);
                if(actual.isOcupado().equals(Vcub.DISPONIBLE))
                {
                    j++;
                    actual.setOcupado(Vcub.NO_DISPONIBLE);
                }
                index++;
            }
        }
            }
    }

    @Override
    public void reducirVcubesEspecifica(int IDestacion) {
         EstacionVcub est = (EstacionVcub) persistencia.findById(EstacionVcub.class, IDestacion);
                    int numero30 = (int) (est.getVcubsEstacion().size()*(0.3));
                    int j = 0 ;
                    int index = 0 ;
                    ArrayList<Vcub> vcubes = est.getVcubsEstacion();
                    while(j<=numero30 && index<vcubes.size())
                    {
                        Vcub actual = vcubes.get(index);
                        if(actual.isOcupado().equals(Vcub.DISPONIBLE))
                        {
                            j++;
                            actual.setOcupado(Vcub.NO_DISPONIBLE);
                        }
                        index++;
                    }
    }

    @Override
    public List<Vcub> darVcubesDisponiblesEstacion(int IDestacion) {
        ArrayList<Vcub> sol = new ArrayList<Vcub>();
        EstacionVcub estacion = (EstacionVcub) persistencia.findById(EstacionVcub.class, IDestacion);
        ArrayList<Vcub> arr = estacion.getVcubsEstacion();
        for (Vcub arr1 : arr)
        {
            if(arr1.isOcupado().equals(Vcub.DISPONIBLE))
            {
                sol.add(arr1);
            }
        }
        return sol;
    }

    @Override
    public List<Vcub> darVcubesOcupadosEstacion(int IDestacion) {
    ArrayList<Vcub> sol = new ArrayList<Vcub>();
        EstacionVcub estacion = (EstacionVcub) persistencia.findById(EstacionVcub.class, IDestacion);
        ArrayList<Vcub> arr = estacion.getVcubsEstacion();
        for (Vcub arr1 : arr)
        {
            if(arr1.isOcupado().equals(Vcub.OCUPADO))
            {
                sol.add(arr1);
            }
        }
        return sol;
    }

    @Override
    public List<Vcub> darVcubesNoDisponiblesEstacion(int IDestacion) {

    ArrayList<Vcub> sol = new ArrayList<Vcub>();
        EstacionVcub estacion = (EstacionVcub) persistencia.findById(EstacionVcub.class, IDestacion);
        ArrayList<Vcub> arr = estacion.getVcubsEstacion();
        for (Vcub arr1 : arr)
        {
            if(arr1.isOcupado().equals(Vcub.NO_DISPONIBLE))
            {
                sol.add(arr1);
            }
        }
        return sol;
    }

    @Override
    public Vcub modificarPosVcub(int idVcub, double longitud, double latitud) 
    {
        Vcub vc = (Vcub) persistencia.findById(Vcub.class, idVcub);
        EstacionVcub evc = (EstacionVcub) persistencia.findById(EstacionVcub.class, vc.getEstacion());
        ArrayList<Vcub> arr = evc.getVcubsEstacion();
        Vcub r = null;
        for (Vcub arr1 : arr)
        {
            if(arr1.getId()==idVcub)
            {
                arr1.setLatitud(latitud);
                arr1.setLongitud(longitud);
                persistencia.update(arr1);
                r=arr1;
                break;
            }
        }
        return r;
    }


    
}
