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
    
    private int id;
    
    private boolean ocupado;

    public Vcub(int id) {
        this.id = id;
        ocupado=false;
    }

    
    
    public int getId() {
        return id;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    
}
