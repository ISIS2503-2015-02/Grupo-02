/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mobibuses.dto;

import java.util.ArrayList;

/**
 *
 * @author s.correa12
 */
public class EstacionVcub {
    
    private long id;
    
    private ArrayList<Vcub> vcubsEstacion;
    
    private double longitudEstacion;
    
    private double latitudEstacion;
    
    private int prestados;

    public EstacionVcub(long id, double longitudEstacio, double latitudEstacion) {
        this.id = id;
        this.longitudEstacion = longitudEstacio;
        this.latitudEstacion = latitudEstacion;
        vcubsEstacion = new ArrayList<Vcub>(); 
        prestados = 0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ArrayList<Vcub> getVcubsEstacion() {
        return vcubsEstacion;
    }

    public void setVcubsEstacion(ArrayList<Vcub> vcubsEstacion) {
        this.vcubsEstacion = vcubsEstacion;
    }

    public double getLongitudEstacion() {
        return longitudEstacion;
    }

    public void setLongitudEstacion(double longitudEstacion) {
        this.longitudEstacion = longitudEstacion;
    }

    public double getLatitudEstacion() {
        return latitudEstacion;
    }

    public void setLatitudEstacion(double latitudEstacio) {
        this.latitudEstacion = latitudEstacio;
    }

    public int getPrestados() {
        return prestados;
    }

    public void setPrestados(int prestados) {
        this.prestados = prestados;
    }
 
    
}
