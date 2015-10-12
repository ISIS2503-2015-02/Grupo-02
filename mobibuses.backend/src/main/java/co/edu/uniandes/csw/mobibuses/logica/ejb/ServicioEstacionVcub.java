/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mobibuses.logica.ejb;

import co.edu.uniandes.csw.mobibuses.dto.EstacionVcub;
import co.edu.uniandes.csw.mobibuses.dto.Mobibus;
import co.edu.uniandes.csw.mobibuses.dto.Vcub;
import co.edu.uniandes.csw.mobibuses.excepciones.OperacionInvalidaException;
import co.edu.uniandes.csw.mobibuses.logica.interfaces.IServicioEstacionVcubMockLocal;
import co.edu.uniandes.csw.mobibuses.logica.interfaces.IServicioPersistenciaMockLocal;
import co.edu.uniandes.csw.mobibuses.persistencia.mock.EstacionVcubEntity;
import co.edu.uniandes.csw.mobibuses.persistencia.mock.MobiBusEntity;
import co.edu.uniandes.csw.mobibuses.persistencia.mock.PersistenceManager;
import co.edu.uniandes.csw.mobibuses.persistencia.mock.ServicioPersistenciaMock;
import co.edu.uniandes.csw.mobibuses.persistencia.mock.TransformadorEntityDto;
import co.edu.uniandes.csw.mobibuses.persistencia.mock.VcubEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author s.correa12
 */
@Stateless
@Local
public class ServicioEstacionVcub implements IServicioEstacionVcubMockLocal, Serializable{

     @PersistenceContext
    private EntityManager em;

    public ServicioEstacionVcub() {
         if(darTodosVcub().size()==0)
          TransformadorEntityDto.getInstance().crearVcubes(em);
    }
     
    @Override
    public List<EstacionVcub> darEstacionesVcub()
    {
            Query q = em.createQuery("SELECT u from EstacionVcubEntity u");
            List<EstacionVcubEntity> estaciones = q.getResultList();
            ArrayList<EstacionVcub> dtos = new ArrayList();
            for (EstacionVcubEntity est : estaciones) {
                dtos.add(TransformadorEntityDto.getInstance().EntityADtoEstacionVcube(est));
            }
            return dtos;
    }

    @Override
    public List<Vcub> darVcubesEstacion(int IDestacion) {
        Query q = em.createQuery("SELECT v from VcubEntity v WHERE v.estacionVcub.id = "+IDestacion);
        List<VcubEntity> vce =q.getResultList();
        ArrayList<Vcub> dtos = new ArrayList();
        for(VcubEntity vc : vce)
        {
            dtos.add(TransformadorEntityDto.getInstance().EntityADtoVcube(vc));
        }
        return dtos;
 
    }

    @Override
    public List<Vcub> darTodosVcub() {
          Query q = em.createQuery("SELECT v from VcubEntity v" );
        List<VcubEntity> vce =q.getResultList();
        ArrayList<Vcub> dtos = new ArrayList();
        for(VcubEntity vc : vce)
        {
            dtos.add(TransformadorEntityDto.getInstance().EntityADtoVcube(vc));
        }
        return dtos;
    }

    @Override
    public Vcub alquilarVcub(int IDestacion) throws OperacionInvalidaException
    {
        EstacionVcubEntity este = em.find(EstacionVcubEntity.class, IDestacion);
       // EstacionVcub est = TransformadorEntityDto.getInstance().EntityADtoEstacionVcube(este);
        Vcub resp = null;
        Set<VcubEntity> vcubes = este.getvCubs();
         for (VcubEntity actual : vcubes) {
             if(actual.getOcupado().equals(Vcub.DISPONIBLE))
             {
                 actual.setOcupado(Vcub.OCUPADO);
                 actual.setOcupado(Vcub.OCUPADO);
                 resp = TransformadorEntityDto.getInstance().EntityADtoVcube(actual);
                 este.setPrestados(este.getPrestados()+1);
                 em.persist(actual);
                 em.persist(este);
                 break;
             }
         }
                 if(resp == null)
                 {
                     throw new OperacionInvalidaException("No hay vcubs disponibles en la estacion: "+ IDestacion);
                 }
                 else if(resp!=null && este.getPrestados()==(int)(este.getvCubs().size()*(0.1)))
                 {
                     for (VcubEntity actual : vcubes) {
                         if(actual.getOcupado().equals(Vcub.NO_DISPONIBLE))
                         {
                             actual.setOcupado(Vcub.DISPONIBLE);
                             em.persist(actual);
                             em.persist(este);
                         }
                     }
                 }
                 return resp;
                
    }

    @Override
    public Vcub liberarVcub(int IDestacion,int IDdevolver) throws OperacionInvalidaException 
    {
        EstacionVcubEntity est = em.find(EstacionVcubEntity.class, IDestacion);
        VcubEntity vcd = em.find(VcubEntity.class, IDdevolver);
        EstacionVcubEntity estValquilo = em.find(EstacionVcubEntity.class, vcd.getEstacionVcub().getId());
        
        Vcub devuelto =null;
        if(estValquilo.getId()==est.getId())
        {
            Set<VcubEntity> vcubes = est.getvCubs();
            for (VcubEntity vc : vcubes) {
                if(vc.getId()==vcd.getId())
                {
                    devuelto=TransformadorEntityDto.getInstance().EntityADtoVcube(vc);
                    vc.setOcupado(Vcub.DISPONIBLE);
                    est.setPrestados(est.getPrestados()-1);
                    em.persist(vc);
                    em.persist(est);
                    break;
                }
            }
        }
        else
        {
            Set<VcubEntity> nueva  =est.getvCubs();
            Set<VcubEntity> vieja = em.find(EstacionVcubEntity.class,estValquilo.getId()).getvCubs();
            vieja.remove(vcd);
            vcd.setOcupado(Vcub.DISPONIBLE);
            vcd.setEstacionVcub(est);
            EstacionVcubEntity ant = em.find(EstacionVcubEntity.class,estValquilo.getId());
            ant.setPrestados(ant.getPrestados()-1);
            nueva.add(vcd);
            devuelto = TransformadorEntityDto.getInstance().EntityADtoVcube(vcd);
           em.persist(vcd);
           em.persist(est);
           em.persist(estValquilo);
        }
        if(devuelto == null)
        {
            throw new OperacionInvalidaException("No de devolvio");
        }
        return devuelto;
    }

    @Override
    public void reducirVcubesTodas() {
        Query q = em.createQuery("SELECT u from EstacionVcubEntity u");
            List<EstacionVcubEntity> estaciones = q.getResultList();
            {
        for (EstacionVcubEntity est : estaciones) {
            int numero30 = (int) (est.getvCubs().size()*(0.3));
            int j = 0 ;
            int index = 0 ;
            Set<VcubEntity> vcubes = est.getvCubs();
            while(j<=numero30 && index<vcubes.size())
            {
                VcubEntity actual = vcubes.toArray(new VcubEntity[vcubes.size()])[index];
                if(actual.getOcupado().equals(Vcub.DISPONIBLE))
                {
                    j++;
                    actual.setOcupado(Vcub.NO_DISPONIBLE);
                    em.persist(actual);
                }
                index++;
            }
            em.persist(est);
        }
            }
    }

    @Override
    public void reducirVcubesEspecifica(int IDestacion) {
         EstacionVcubEntity est = em.find(EstacionVcubEntity.class, IDestacion);
                    int numero30 = (int) (est.getvCubs().size()*(0.3));
            int j = 0 ;
            int index = 0 ;
            Set<VcubEntity> vcubes = est.getvCubs();
            while(j<=numero30 && index<vcubes.size())
            {
                VcubEntity actual = vcubes.toArray(new VcubEntity[vcubes.size()])[index];
                if(actual.getOcupado().equals(Vcub.DISPONIBLE))
                {
                    j++;
                    actual.setOcupado(Vcub.NO_DISPONIBLE);
                    em.persist(actual);
                }
                index++;
            }
            em.persist(est);
    }

    @Override
    public List<Vcub> darVcubesDisponiblesEstacion(int IDestacion) {
        ArrayList<Vcub> sol = new ArrayList<Vcub>();
        List<Vcub> arr = darVcubesEstacion(IDestacion);
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
    public List<Vcub> darVcubesOcupadosEstacion(int IDestacion)
    {
        ArrayList<Vcub> sol = new ArrayList<Vcub>();
        List<Vcub> arr = darVcubesEstacion(IDestacion);
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
        List<Vcub> arr = darVcubesEstacion(IDestacion);
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
        VcubEntity vc = em.find(VcubEntity.class, idVcub);
        EstacionVcubEntity evc = em.find(EstacionVcubEntity.class, vc.getEstacionVcub().getId());
        Set<VcubEntity> arr = evc.getvCubs();
        Vcub r = null;
        for (VcubEntity arr1 : arr)
        {
            if(arr1.getId()==idVcub)
            {
                arr1.setLatitud(latitud);
                arr1.setLongitud(longitud);
                em.persist(arr1);
                em.persist(evc);
                r=TransformadorEntityDto.getInstance().EntityADtoVcube(arr1);
                break;
            }
        }
        return r;
    }


    
}
