/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mueblesdelosalpes.dto;

import java.util.Date;

/**
 *
 * @author pa.sarmiento10
 */
public class Mobibus {
    
    private String nombre ;
    
    private double posicionLatitud ;
    
    private double posicionLongitud ;
    
    private double kilometraje;
    
    private boolean reservado;
    
    private String fechaReservacion;


    public Mobibus(String nombreP,double posicionLatitudP, double posicionLongitudP,double pKilometraje, String pFecha)
    {
     nombre=nombreP;
     
     posicionLatitud=posicionLatitudP;
     
     posicionLongitud=posicionLongitudP;
     
     kilometraje=pKilometraje;
     
     reservado=false;
     
     fechaReservacion=pFecha;
        
    }

    public Mobibus(String string, double d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public String getNombre()
    {
        return nombre;
    }
    
    public double getposicionLatitud()
    {
        return posicionLatitud;
    }
    
    public double getposicionLongitud()
    {
        return posicionLongitud;
    } 
    
    public double getKilometraje()
    {
        return kilometraje;
    }
    
    public boolean getReservado()
    {
        return reservado;
        
    }

    public String getFechaReservacion()
    {
        return fechaReservacion;
    }

    public void setNombre(String pNombre)
    {
      nombre=pNombre;
    }
    
    public void setPosicionLongitud(double pPos)
    {
       posicionLongitud=pPos;
    }
    
     public void setPosicionLatitud(double pPos)
    {
       posicionLatitud=pPos;
    }
    
    public void setKilometraje(double pKilometrajee)
    {
        kilometraje=pKilometrajee;
    }
    
    public void setReservado(boolean pReservado)
    {
        reservado=pReservado;
        
    }

    public void setFechaReservacion(String pFecha)
    {
     fechaReservacion=pFecha;
    }



}
