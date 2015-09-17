/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ ServicioPersistenciaMock.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * Autor: Juan Sebastián Urrego
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package co.edu.uniandes.csw.mueblesdelosalpes.persistencia.mock;


import co.edu.uniandes.csw.mueblesdelosalpes.dto.EstacionVcub;
import co.edu.uniandes.csw.mueblesdelosalpes.dto.ExperienciaVendedor;
import co.edu.uniandes.csw.mueblesdelosalpes.dto.Mueble;
import co.edu.uniandes.csw.mueblesdelosalpes.dto.RegistroVenta;
import co.edu.uniandes.csw.mueblesdelosalpes.dto.TipoMueble;
import co.edu.uniandes.csw.mueblesdelosalpes.dto.TipoUsuario;
import co.edu.uniandes.csw.mueblesdelosalpes.dto.Tranvia;
import co.edu.uniandes.csw.mueblesdelosalpes.dto.Usuario;
import co.edu.uniandes.csw.mueblesdelosalpes.dto.Vcub;
import co.edu.uniandes.csw.mueblesdelosalpes.dto.Mobibus;
import co.edu.uniandes.csw.mueblesdelosalpes.dto.Ruta;
import co.edu.uniandes.csw.mueblesdelosalpes.dto.Vendedor;
import co.edu.uniandes.csw.mueblesdelosalpes.excepciones.OperacionInvalidaException;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioPersistenciaMockLocal;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioPersistenciaMockRemote;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
/**
 * Implementación de los servicios de persistencia
 * @author Juan Sebastián Urrego
 */

public class ServicioPersistenciaMock implements IServicioPersistenciaMockRemote, IServicioPersistenciaMockLocal {

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

   
    /**
     * Lista con los vendedores del sistema
     */
    private static ArrayList<Vendedor> vendedores;

    /**
     * Lista con los muebles del sistema
     */
    private static ArrayList<Mueble> muebles;

    /**
     * Lista con los usuarios del sistema
     */
    private static ArrayList<Usuario> usuarios;

    /**
     * Lista con los registros de ventas
     */
    private static ArrayList<RegistroVenta> registrosVentas;
    
    
    //lista de los tranvias
    
    private static ArrayList<Tranvia> tranvias;
    
    /**
     * Lista con los Vcubs
     */
    private static ArrayList<Vcub> vcubes;
    
     /**
     * Lista con los Vcubs
     */
    private static ArrayList<Mobibus> mobibuses;
    
    /**
     * Lista de Estacion Vcub
     */
    private static ArrayList<EstacionVcub> estacionesVcub;
    public final static int NUMERO_ESTACIONES= 20;
 
    @PersistenceContext(unitName = "pm")
    public EntityManager entityManager; 

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------

    /**
     * Constructor de la clase. Inicializa los atributos.
     */
     @PostConstruct
    public void init() {
        try {
            entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
            System.out.println("Se ha iniciado el entity manager Cristian"+entityManager.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
    
    public ServicioPersistenciaMock()
    {
          entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
            System.out.println("Se ha iniciado el entity manager Cristian"+entityManager.toString());
        
        
//        if(estacionesVcub==null)
//        {
//            estacionesVcub = new ArrayList<EstacionVcub>();
//           
//            for(int i = 0 ; i<NUMERO_ESTACIONES;i++)
//            {
//                double longitud = 0 ;
//                double latitud = 0;
//                
//               EstacionVcub nueva = new EstacionVcub(i,longitud,latitud);
//               estacionesVcub.add(nueva);
//            }
//        }
//        
        if(vcubes==null)
        {
            vcubes = new ArrayList<Vcub>();
            int indiceEstacion = 0 ;
            int numeroMax = (int)(1+Math.random())*200;
            for(int b=0;b<4000;b++)
            {
                EstacionVcub est = estacionesVcub.get(indiceEstacion);
                if(numeroMax==est.getVcubsEstacion().size())
                {
                    indiceEstacion++;
                    numeroMax = (int)(1+Math.random())*200;
                }
                if(indiceEstacion>=estacionesVcub.size())
                {
                    indiceEstacion = 0;
                    numeroMax = 700;
                }
                EstacionVcub actual = estacionesVcub.get(indiceEstacion);
                Vcub nuevo = new Vcub(b,actual.getId());
                vcubes.add(nuevo);
                actual.getVcubsEstacion().add(nuevo);
                VcubEntity vc= new VcubEntity();
                vc.setEstacion(indiceEstacion);
                               
            }
            
        }
//        
//        if(tranvias== null)
//        {
//           
//            
//            tranvias=new ArrayList<Tranvia>() ;
//            
//            for(int i = 0 ; i<250 ; i++)
//            {
//                int linea=(int)(Math.random()*3);
//                
//                String ruta="";
//                
//                if(linea==1)
//                {
//                    ruta="A";
//                }
//                if(linea==2)
//                {
//                    ruta="B";
//                }
//                if(linea==3 || linea==0){
//                    ruta="C";
//                }
//                double numero=0;
//                double numero2=0;
//                double tiempoTrayecto=0;
//                
//                if(linea==1)
//                {
//                      numero=(Math.random()*0.41)+4.43;
//                 numero2=0-74.068;
//                 tiempoTrayecto=(Math.random()*2)+2;
//                    
//                }
//                if(linea==2)
//                {
//                      numero=4.63;
//                 numero2=(Math.random()*(-0.213))-74.001;
//                  tiempoTrayecto=(Math.random()*1.5)+1.5;
//                }
//                if(linea==3 || linea==0){
//                      numero=4.69;
//                 numero2=(Math.random()*(-0.213))-74.001;
//                  tiempoTrayecto=(Math.random()*1.5)+2;
//                }
//                
//                
//                double kilometraje ;
//                
//                
//                kilometraje=Math.random()*10000+1000 ;
//                
//              String  nombreConductor="conductor"+i;
//               
//                Tranvia x = new Tranvia("tranvia"+(i), ruta, numero, numero2, 3, 3, 3, kilometraje,nombreConductor,tiempoTrayecto) ;
//                
//                tranvias.add(x);
//                
//            }
//            
//            
//        }
        
        
        
    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------
    
    /**
     * Permite crear un objeto dentro de la persistencia del sistema.
     * @param obj Objeto que representa la instancia de la entidad que se quiere crear.
     */
    @Override
    public void create(Object obj) throws OperacionInvalidaException
    {
        if(obj instanceof EstacionVcub)
        {
           EstacionVcub v = (EstacionVcub) obj;
            v.setId(estacionesVcub.size()+1);
            estacionesVcub.add(v);
        }
        else if(obj instanceof Vcub)
        {
            Mobibus mb = (Mobibus) obj;
            mb.setID(mobibuses.size()+1);
            mb.setReservado(false);
            mobibuses.add(mb);
        }
        else if(obj instanceof Mobibus)
        {
            Mobibus mb = (Mobibus) obj;
            mb.setID(mobibuses.size()+1);
            mb.setReservado(false);
            mobibuses.add(mb);
        }
        else if(obj instanceof Tranvia)
        {
            Mobibus mb = (Mobibus) obj;
            mb.setID(mobibuses.size()+1);
            mb.setReservado(false);
            mobibuses.add(mb);
        }
        else if(obj instanceof Ruta)
        {
            Mobibus mb = (Mobibus) obj;
            mb.setID(mobibuses.size()+1);
            mb.setReservado(false);
            mobibuses.add(mb);
        }
       
    }

    /**
     * Permite modificar un objeto dentro de la persistencia del sistema.
     * @param obj Objeto que representa la instancia de la entidad que se quiere modificar.
     */
    @Override
    public void update(Object obj)
    {
       
        if (obj instanceof Vcub)
        {
            Vcub editar = (Vcub) obj;
            Vcub vc;
            for (int i = 0; i < vcubes.size(); i++)
            {
                vc = vcubes.get(i);
                if (vc.getId() == editar.getId())
                {
                    vcubes.set(i, editar);
                    break;
                }
            }
        }
          
          else if(obj instanceof EstacionVcub)
        {
            EstacionVcub editar= (EstacionVcub) obj;
            EstacionVcub evc;
            for(int i = 0 ; i<estacionesVcub.size();i++)
            {
                evc = estacionesVcub.get(i);
                if(evc.getId()==editar.getId())
                {
                    estacionesVcub.set(i, editar);
                    break;
                }
            }
        }
        
        else if (obj instanceof Mobibus)
        {
            Mobibus editar = (Mobibus) obj;
            Mobibus mb;
            for (int i = 0; i < mobibuses.size(); i++)
            {
                mb = mobibuses.get(i);
                if (mb.getID() == editar.getID())
                {
                    mobibuses.set(i, editar);
                    break;
                }
            }
        }
        else if (obj instanceof Tranvia)
        {
            Mobibus editar = (Mobibus) obj;
            Mobibus mb;
            for (int i = 0; i < mobibuses.size(); i++)
            {
                mb = mobibuses.get(i);
                if (mb.getID() == editar.getID())
                {
                    mobibuses.set(i, editar);
                    break;
                }
            }
        }
        else if (obj instanceof Ruta)
        {
            Mobibus editar = (Mobibus) obj;
            Mobibus mb;
            for (int i = 0; i < mobibuses.size(); i++)
            {
                mb = mobibuses.get(i);
                if (mb.getID() == editar.getID())
                {
                    mobibuses.set(i, editar);
                    break;
                }
            }
        }
    }

    /**
     * Permite borrar un objeto dentro de la persistencia del sistema.
     * @param obj Objeto que representa la instancia de la entidad que se quiere borrar.
     */
    @Override
    public void delete(Object obj) throws OperacionInvalidaException
    {
        if (obj instanceof Ruta)
        {
            Vendedor vendedorABorrar = (Vendedor) obj;

            for (int e = 0; e < vendedores.size(); e++)
            {
                Vendedor ven = (Vendedor) vendedores.get(e);
                if (ven.getIdentificacion() == vendedorABorrar.getIdentificacion())
                {
                    vendedores.remove(e);
                    break;
                }
            }

        } 
        else if (obj instanceof Mobibus)
        {
            Mueble mueble;
            Mueble eliminar = (Mueble) obj;
            for (int i = 0; i < muebles.size(); i++)
            {
                mueble = muebles.get(i);
                if (eliminar.getReferencia() == mueble.getReferencia())
                {
                    muebles.remove(i);
                    break;
                }

            }

        } 
        else if (obj instanceof Tranvia)
        {
            Usuario usuarioABorrar = (Usuario) obj;
            for (RegistroVenta rv : registrosVentas)
            {
                if (rv.getComprador().getLogin().equals(usuarioABorrar.getLogin()))
                {
                    System.out.print("no borrado");
                    throw new OperacionInvalidaException("El usuario ha realizado comprar y por lo tanto no puede ser eliminado del sistema.");
                }
            }
            if (usuarioABorrar != null && usuarioABorrar.getLogin() != null)
            {
                for (int e = 0; e < usuarios.size(); e++)
                {
                    Usuario ven = (Usuario) usuarios.get(e);
                    if (ven.getLogin().equals(usuarioABorrar.getLogin()))
                    {
                        usuarios.remove(e);
                        System.out.print("borrado");
                        break;
                    }
                }
            }
        }
           else if (obj instanceof Vcub)
        {
            Vcub eliminar = (Vcub) obj;
            Vcub vc;
            for (int i = 0; i < vcubes.size(); i++)
            {
                vc = vcubes.get(i);
                if (vc.getId() == eliminar.getId())
                {
                    vcubes.remove(i);
                    break;
                }
            }
        }
           else if (obj instanceof EstacionVcub)
        {
            EstacionVcub eliminar = (EstacionVcub) obj;
            EstacionVcub vc;
            for (int i = 0; i < estacionesVcub.size(); i++)
            {
                vc = estacionesVcub.get(i);
                if (vc.getId() == eliminar.getId())
                {
                    vcubes.remove(i);
                    break;
                }
            }
        }
    }

    /**
     * Retorna la lista de todos los elementos de una clase dada que se encuentran en el sistema.
     * @param c Clase cuyos objetos quieren encontrarse en el sistema.
     * @return list Listado de todos los objetos de una clase dada que se encuentran en el sistema.
     */
    @Override
    public List findAll(Class c)
    {
         if (c.equals(Tranvia.class))
        {
//             if(tranvias== null)
//        {             
//            tranvias=new ArrayList<Tranvia>() ;
//            
//            for(int i = 0 ; i<250 ; i++)
//            {
//                int linea=(int)(Math.random()*3);
//                
//                String ruta="";
//                
//                if(linea==1)
//                {
//                    ruta="A";
//                }
//                if(linea==2)
//                {
//                    ruta="B";
//                }
//                if(linea==3 || linea==0){
//                    ruta="C";
//                }
//                double numero=0;
//                double numero2=0;
//                double tiempoTrayecto=0;
//                
//                if(linea==1)
//                {
//                      numero=(Math.random()*0.41)+4.43;
//                 numero2=0-74.068;
//                 tiempoTrayecto=(Math.random()*2)+2;
//                    
//                }
//                if(linea==2)
//                {
//                      numero=4.63;
//                 numero2=(Math.random()*(-0.213))-74.001;
//                  tiempoTrayecto=(Math.random()*1.5)+1.5;
//                }
//                if(linea==3 || linea==0){
//                      numero=4.69;
//                 numero2=(Math.random()*(-0.213))-74.001;
//                  tiempoTrayecto=(Math.random()*1.5)+2;
//                }
//                
//                
//                double kilometraje ;
//                
//                
//                kilometraje=Math.random()*10000+1000 ;
//                
//              String  nombreConductor="conductor"+i;
//               
//                Tranvia x = new Tranvia("tranvia"+(i), ruta, numero, numero2, 3, 3, 3, kilometraje,nombreConductor,tiempoTrayecto) ;
//                TranviaEntity t = new TranviaEntity();
//                t.setKilometraje(kilometraje);
//                t.setLinea(ruta);
//                t.setNivelChoque(x.getNivelChoque());
//                t.setNivelPanico(x.getNivelPanico());
//                t.setNivelTemperatura(x.getNivelTemparatura());
//                t.setNombre(x.getNombre());
//                t.setNombreConductor(x.getNombreConductor());
//                t.setPosicionLatitud(x.getposicionLatitud());
//                t.setPosicionLongitud(x.getposicionLongitud());
//                t.setTiempoTrayecto(tiempoTrayecto);
//                
//                try {
//                    entityManager.persist(t);
//                    System.out.println("Persiste tranvia");
//                } catch (Exception e) {
//                    System.out.println("NO Persiste tranvia: "+e.getMessage());
//                }
//
//
// tranvias.add(x);
//   
// }
// }
            
            
            return tranvias;
        
        } 
         if (c.equals(Mobibus.class))
        {
//            mobibuses=new ArrayList<Mobibus>() ;
//            
//            for(int i = 0 ; i<250 ; i++)            {
//                
//               double numero = (Math.random()*0.41)+4.43;
//                
//                double numero2=(Math.random()*(-0.213))-74.001;
//                
//            
//                Mobibus m= new Mobibus("Mobibus"+i, numero, numero2, 56+i, "ss",i);
//                
//                MobiBusEntity mo= new MobiBusEntity();
//                mo.setFechaReservacion(m.getFechaReservacion());
//                mo.setId(mo.getId());
//                mo.setNombre(m.getNombre());
//                mo.setPosicionLatitud(m.getposicionLatitud());
//                mo.setPosicionLongitud(m.getposicionLongitud());
//                mo.setReservado(m.getReservado());
//           
//                
//                      try {
//            entityManager.persist(mo);
//            System.out.println("Se persistio correctamente");
//           
//        } catch (Exception t) {
//            System.out.println("Se toteo "+t.getMessage());
//     
//            t.printStackTrace();
//            
//        }
//                  
//            
//           
//                
//                mobibuses.add(m);
//                
//            
//            }
            
            
            return mobibuses;
        
        } 
       
        else if(c.equals(Vcub.class))
        {
            return vcubes;
        }
        else if(c.equals(EstacionVcub.class))
        {
            return estacionesVcub;
        }
        else if(c.equals(Ruta.class))
        {
            return estacionesVcub;
        }
        else
        {
            return null;
        }
    }

    /**
     * Retorna la instancia de una entidad dado un identificador y la clase de la entidadi.
     * @param c Clase de la instancia que se quiere buscar.
     * @param id Identificador unico del objeto.
     * @return obj Resultado de la consulta.
     */
    @Override
    public Object findById(Class c, Object id)
    {
        if (c.equals(Vendedor.class))
        {
            entityManager.find(c, id);
            for (Object v : findAll(c))
            {
                Vendedor ven = (Vendedor) v;
                if (ven.getIdentificacion() == Long.parseLong(id.toString()))
                {
                    return ven;
                }
            }
        } 
        else if (c.equals(Mueble.class))
        {
            for (Object v : findAll(c))
            {
                Mueble mue = (Mueble) v;
                if (Long.parseLong(id.toString())== mue.getReferencia())
                {
                    return mue;
                }
            }
        } 
        else if (c.equals(Usuario.class))
        {
            for (Object v : findAll(c))
            {
                Usuario mue = (Usuario) v;
                if (mue.getLogin().equals(id))
                {
                    return mue;
                }
            }
        }
        else if(c.equals(Vcub.class)){
            for(Object v:findAll(c))
            {
                Vcub vc = (Vcub)v;
                if(vc.getId()==Integer.parseInt(id.toString()))
                {
                    return vc;
                }
            }
        }
         else if(c.equals(EstacionVcub.class)){
            for(Object v:findAll(c))
            {
                EstacionVcub vc = (EstacionVcub)v;
                if(vc.getId()==Integer.parseInt(id.toString()))
                {
                    return vc;
                }
            }
        }
        
        
         else if(c.equals(Tranvia.class)){
            for(Object v:findAll(c))
            {
                Tranvia tranvia = (Tranvia)v;
                if(tranvia.getNombre().equals(id.toString()))
                {
                    return tranvia; 
                }
            }
        }
        
        else if(c.equals(Mobibus.class)){
            for(Object v:findAll(c))
            {
                Mobibus mb = (Mobibus)v;
                if(mb.getID()==Integer.parseInt(id.toString()))
                {
                    return mb; 
                }
            }
        }
        return null;
    }
}
