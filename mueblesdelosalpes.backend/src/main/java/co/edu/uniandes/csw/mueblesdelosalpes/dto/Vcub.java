/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mueblesdelosalpes.dto;

/**
 *
 * @author s.correa12
 */
public class Vcub {
    
    public final static String OCUPADO = "OCUPADO";
    public final static String DISPONIBLE = "DISPONIBLE";
    public final static String NO_DISPONIBLE = "NO DISPONIBLE";
    
    private int id;
    
    
    private String ocupado;
    
    private int estacion;
    
    private double longitud;
    
    private double latitud;

    public Vcub(int id,int pEstacion) {
        this.id = id;
        ocupado=Vcub.DISPONIBLE;
        estacion = pEstacion;
        longitud = 0;
        latitud =0;
    }

    
    
    public int getId() {
        return id;
    }

    public String isOcupado() {
        if(ocupado.equalsIgnoreCase(Vcub.DISPONIBLE))
        {
            return Vcub.DISPONIBLE;
        }
        else if(ocupado.equalsIgnoreCase(Vcub.NO_DISPONIBLE))
        {
            return Vcub.NO_DISPONIBLE;
        }
        else
        {
            return Vcub.OCUPADO;
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOcupado(String ocupado) {
        this.ocupado = ocupado;
    }

    public int getEstacion() {
        return estacion;
    }

    public void setEstacion(int estacion) {
        this.estacion = estacion;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }
 
}
