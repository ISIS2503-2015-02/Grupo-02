/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mobibuses.logica.ejb;

import co.edu.uniandes.csw.mobibuses.dto.Tranvia;
import co.edu.uniandes.csw.mobibuses.logica.interfaces.IServicioTranviaLocal;
import co.edu.uniandes.csw.mobibuses.persistencia.mock.PersistenceManager;
import co.edu.uniandes.csw.mobibuses.persistencia.mock.TransformadorEntityDto;
import co.edu.uniandes.csw.mobibuses.persistencia.mock.TranviaEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author fj.ricaurte10
 */

@Stateless
@Local
public class ServicioTranvia implements IServicioTranviaLocal, Serializable{

       @PersistenceContext
    private EntityManager em;
  
    public ServicioTranvia()
    {
        em = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
        if(darTranvias().isEmpty())
          TransformadorEntityDto.getInstance().crearTranvias(em);
  
    }
    
    
    /**
     * da los tranvis
     * @return  lista de tranvias
     */
       @Override
    public List<Tranvia> darTranvias() 
    {
    Query q = em.createQuery("SELECT u FROM TranviaEntity u");
     List<TranviaEntity> l = q.getResultList();
     List<Tranvia> ltr = new ArrayList();
     for(TranviaEntity te: l)
     {
         ltr.add(TransformadorEntityDto.getInstance().entityADtoTranvia(te));
     }
     return ltr;
    }

    
    /**
     * cambia un estado de emergencia de un tranvia
     * @param id del tranvia al que se desea cambiar el estado
     * @param emergencia emergencia a la que se le desea cambiar el estado
     * @param valor nuevo valor de la emergencia
     * @param token que garantiza autenticacion del usuario para usar el servicio
     */
    
    @Override
    public void cambiarEstado(String id, int emergencia, int valor) {

   TranviaEntity tranvia =em.find(TranviaEntity.class, Long.parseLong(id));
         
         //modifico el nivel de choque
        if(emergencia==1)
        {
            tranvia.setNivelChoque(valor);
            
        }
        
        //modifico el nivel de temperatura
        if(emergencia==2)
        {
            tranvia.setNivelTemperatura(valor);
        }
        
        // el boton de panico
        if(emergencia==3 || emergencia==0){
            
            tranvia.setNivelPanico(valor);
            
        }
        em.persist(tranvia);
    }

    
    /**
     * genera un reporte de todos los tranvias
     * @return un string que contiene todo el reporte sobre los tranvias
     */
    
    @Override
    public List<String> generarReporte() {

        
        List<String> enviar = new ArrayList<String>();
        
    String rta="";
    
    List<Tranvia> lista =darTranvias();
    
    Tranvia conductorMasEFectivoA=null;
    Tranvia conductorMenosEFectivoA=null;
    double tiempoMenosEfectivoA=0;
    double tiempoMasEfectivoA=10000;
    
    
    Tranvia conductorMasEFectivoB=null;
    Tranvia conductorMenosEFectivoB=null;
    double tiempoMenosEfectivoB=0;
    double tiempoMasEfectivoB=10000;
    
    
        
    Tranvia conductorMasEFectivoC=null;
    Tranvia conductorMenosEFectivoC=null;
    double tiempoMenosEfectivoC=0;
    double tiempoMasEfectivoC=10000;
    
    int problemaTipoA=0;
    int problemaTipoB=0;
    int problemaTipoC=0;
    
    int problemasTemperatura=0 ;
    int problemasPanico=0;
    int problemasChoque=0;

    
    for(Tranvia tra:lista)
    {

       String  meter="El tiempo promedio del tranvia " + tra.getNombre()+ " es " + tra.getTimepoPromedio() +"<p>";
        enviar.add(meter);
        //ruta A
        
      
        if("A".equals(tra.getLinea()) && tra.getTimepoPromedio()<tiempoMasEfectivoA)
        {
                        tiempoMasEfectivoA=tra.getTimepoPromedio();
            conductorMasEFectivoA=tra;
            
        }
        if("A".equals(tra.getLinea()) &&tra.getTimepoPromedio()>tiempoMenosEfectivoA)
        {
            tiempoMenosEfectivoA=tra.getTimepoPromedio();
            conductorMenosEFectivoA=tra;
        }
        
        
        //ruta B
        
         if("B".equals(tra.getLinea()) && tra.getTimepoPromedio()<tiempoMasEfectivoB)
        {
            tiempoMasEfectivoB=tra.getTimepoPromedio();
            conductorMasEFectivoB=tra;
        }
        if("B".equals(tra.getLinea()) &&tra.getTimepoPromedio()>tiempoMenosEfectivoB)
        {
            tiempoMenosEfectivoB=tra.getTimepoPromedio();
            conductorMenosEFectivoB=tra;
        }
        
         //ruta C
        
         if("C".equals(tra.getLinea()) && tra.getTimepoPromedio()<tiempoMasEfectivoC)
        {
            tiempoMasEfectivoC=tra.getTimepoPromedio();
            conductorMasEFectivoC=tra;
        }
        if("C".equals(tra.getLinea()) &&tra.getTimepoPromedio()>tiempoMenosEfectivoC)
        {
            tiempoMenosEfectivoC=tra.getTimepoPromedio();
            conductorMenosEFectivoC=tra;
        }
        
        if("A".equals(tra.getLinea()))
        {
            if(tra.getNivelChoque()>50){
                problemaTipoA++;
                problemasChoque++;
            }
            if(tra.getNivelPanico()>50){
                 problemaTipoA++;
                 problemasPanico++;
                 
            }
            if(tra.getNivelTemparatura()>50){
                 problemaTipoA++;
                 problemasTemperatura++;
            }
        }
        
        if("B".equals(tra.getLinea()))
        {
            if(tra.getNivelChoque()>50){
                problemaTipoB++;
                 problemasChoque++;
            }
            if(tra.getNivelPanico()>50){
                 problemaTipoB++;
                  problemasPanico++;
            }
            if(tra.getNivelTemparatura()>50){
                 problemaTipoB++;
                    problemasTemperatura++;
            }
        }
        
        if("C".equals(tra.getLinea()))
        {
            if(tra.getNivelChoque()>50){
                problemaTipoC++;
                 problemasChoque++;
            }
            if(tra.getNivelPanico()>50){
                 problemaTipoC++;
                  problemasPanico++;
            }
            if(tra.getNivelTemparatura()>50){
                 problemaTipoC++;
                    problemasTemperatura++;
            }
        }
        
    
    }
    String mas = "El conductor mas efectivo  ";
    String menos = "El conductor menos efectivo  ";
    String tran = " con el tranvia";
    String tiempo =" con un tiempo de ";
    String met1=mas+"de la ruta A "+ conductorMasEFectivoA.getNombre() +tran + conductorMasEFectivoA.getNombre()+ tiempo + conductorMasEFectivoA.getTimepoPromedio()+"<p>";
     enviar.add(met1);
     String met2=menos+"de la ruta A "+ conductorMenosEFectivoA.getNombre() +tran + conductorMenosEFectivoA.getNombre()+ tiempo + conductorMenosEFectivoA.getTimepoPromedio()+"<p>";
    enviar.add(met2);
     String met3=mas+"de la ruta B "+ conductorMasEFectivoB.getNombre() +tran + conductorMasEFectivoB.getNombre()+ tiempo+ conductorMasEFectivoB.getTimepoPromedio()+"<p>";
    enviar.add(met3);
     String met4=menos+"de la ruta B "+ conductorMenosEFectivoB.getNombre() +tran + conductorMenosEFectivoB.getNombre()+ tiempo+ conductorMenosEFectivoB.getTimepoPromedio()+"<p>";
   enviar.add(met4);
    
     String met5=mas+"de la ruta C "+ conductorMasEFectivoC.getNombre() +tran+ conductorMasEFectivoC.getNombre()+ tiempo + conductorMasEFectivoC.getTimepoPromedio()+"<p>";
    enviar.add(met5);
     String met6=menos+"de la ruta C "+ conductorMenosEFectivoC.getNombre() +tran + conductorMenosEFectivoC.getNombre()+ tiempo + conductorMenosEFectivoC.getTimepoPromedio()+"<p>";
   enviar.add(met6);
    
   int maso =  Math.max(problemaTipoA, problemaTipoB);
   
   int mayorProblema = Math.max(maso, problemaTipoC);
   
   String ta = "El trayecto A presenta ";
   
   String pp = " problemas <p>" ;
   
    String met7=ta+ problemaTipoA +pp ;
    enviar.add(met7);
   
     String met8=ta+ problemaTipoB +pp ;
    enviar.add(met8);
      String met9=ta+ problemaTipoC +pp ;
     enviar.add(met9);
       String met10="El trayecto que mas presenta problemas tiene "+ mayorProblema +" problemas <p>" ;
   enviar.add(met10);
     int masoEmer =  Math.max(problemasChoque, problemasPanico);
   
   int mayorProblemaEmer = Math.max(masoEmer, problemasTemperatura);
   
   String ha = "Ha habido  ";
      
    String met11=ha+ problemasTemperatura +" emergencias por temperatura <p>" ;
   enviar.add(met11);
     String met12=ha+ problemasChoque +" emergencias por choque <p>" ;
    enviar.add(met12);
      String met13=ha+ problemasPanico +" emergencias por panico <p>" ;
     enviar.add(met13);
      String met14="La emergencia mas concurrida ha sucedido "+mayorProblemaEmer + " veces" ;
     enviar.add(met14);

    return enviar ;
    }

    
    
    /**
     * cambia la posicion geografica de un tranvia
     * @param id del tranvia al que se desea cambiar la posicion geografica
     * @param co1 latidud geografica
     * @param co2 longitud geografica
     */
    
    @Override
    public void cambiarCoord(String id, double co1, double co2) {
        /* Query qu = em.createQuery("SELECT u FROM UserEntity u WHERE u.rol='admin' and u.token ='"+token+"'");
     if( !qu.getResultList().isEmpty())*/
     {
          TranviaEntity tranvia =em.find(TranviaEntity.class, Long.parseLong(id));
         tranvia.setPosicionLatitud(co1);
           tranvia.setPosicionLongitud(co2);
        em.persist(tranvia);
     }
        
    }

   
    
    
    
    
    
}
