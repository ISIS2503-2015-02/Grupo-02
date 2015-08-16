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
    
    private Date fechaReservacion;


    public Mobibus(String nombreP,double posicionLatitudP, double posicionLongitudP,double pKilometraje, Date pFecha)
    {
     nombre=nombreP;
     
     posicionLatitud=posicionLatitudP;
     
     posicionLongitud=posicionLongitudP;
     
     kilometraje=pKilometraje;
     
     reservado=false;
     
     fechaReservacion=pFecha;
        
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

    public Date getFechaReservacion()
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
    
    public void setKilometraje(double pKilometraje)
    {
        kilometraje=pKilometraje;
    }
    
    public void setReservado(boolean pReservado)
    {
        reservado=pReservado;
        
    }

    public void setFechaReservacion(Date pFecha)
    {
     fechaReservacion=pFecha;
    }



}
