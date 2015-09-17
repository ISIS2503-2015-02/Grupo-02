/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mueblesdelosalpes.persistencia.mock;

import co.edu.uniandes.csw.mueblesdelosalpes.dto.EstacionVcub;
import co.edu.uniandes.csw.mueblesdelosalpes.dto.Mobibus;
import co.edu.uniandes.csw.mueblesdelosalpes.dto.Ruta;
import co.edu.uniandes.csw.mueblesdelosalpes.dto.Tranvia;
import co.edu.uniandes.csw.mueblesdelosalpes.dto.Vcub;

/**
 *
 * @author cf.brochero10
 */
public class TransformadorEntityDto {
    public void crearMobibibuses(){
        
    }
    public void crearTranvias(){
        
    }
    public void crearVcubes(){
        
    }
    public void crearRutas(){
        
    }
    public VcubEntity DtoAEntityVcube(Vcub dto)
     {
       VcubEntity en= new VcubEntity();
       
       return en;  
     }
    public EstacionVcubEntity DtoAEntityEstacionVcube(EstacionVcub dto)
     {
         EstacionVcubEntity en= new EstacionVcubEntity();
         
         return en;
     }
//    public RutaEntity DtoAEntityRutaEntity(Ruta dto)
//     {
//         RutaEntity
//         
//     }
//    public MobiBusEnt en=ity DtoAEntityMobibus(Mobibus dto)
//     {
//                MobiBusEntity mo= new MobiBusEntity();
//                mo.setFechaReservacion(dto.getFechaReservacion());
//                mo.setId(dto.getID());
//                mo.setNombre(dto.getNombre());
//                mo.setPosicionLatitud(dto.getposicionLatitud());
//                mo.setPosicionLongitud(dto.getposicionLongitud());
//                mo.setReservado(dto.getReservado());
//                return mo;
//           
//     }
//    public TranviaEntity DtoAEntityTranvia(Tranvia dto)
//     {
//                TranviaEntity t = new TranviaEntity();
//                t.setKilometraje(dto.getKilometraje());
//                t.setLinea(dto.getLinea());
//                t.setNivelChoque(dto.getNivelChoque());
//                t.setNivelPanico(dto.getNivelPanico());
//                t.setNivelTemperatura(dto.getNivelTemparatura());
//                t.setNombre(dto.getNombre());
//                t.setNombreConductor(dto.getNombreConductor());
//                t.setPosicionLatitud(dto.getposicionLatitud());
//                t.setPosicionLongitud(dto.getposicionLongitud());
//                t.setTiempoTrayecto(dto.getTimepoPromedio());
//                return t;
//     }
//    
//    
//    public Vcub EntityADtoVcube(VcubEntity entity)
//     {
//         
//     }
//    public EstacionVcub EntityADtoEstacionVcube(EstacionVcubEntity entity)
//     {
//         
//     }
//    public Ruta EntityADtoRutaEntity(RutaEntity entity)
//     {
//         
//     }
//    public Mobibus EntityADtoMobibus(MobiBusEntity entity)
//     {
//         
//     }
//    public Tranvia EntityADtoTranvia(TranviaEntity entity)
//     {
//         
//     }
    
}
