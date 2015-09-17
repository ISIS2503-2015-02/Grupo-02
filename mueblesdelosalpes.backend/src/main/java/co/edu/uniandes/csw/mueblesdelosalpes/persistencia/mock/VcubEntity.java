/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mueblesdelosalpes.persistencia.mock;

import java.io.Serializable;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author cf.brochero10
 */
@Entity
public class VcubEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
        
    private String ocupado;
    
    private int estacion;
    
    private double longitud;
    
    private double latitud;
    
     @ManyToOne(cascade=ALL)
    private EstacionVcubEntity estacionVcub;

    public String getOcupado() {
        return ocupado;
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

    public EstacionVcubEntity getEstacionVcub() {
        return estacionVcub;
    }

    public void setEstacionVcub(EstacionVcubEntity estacionVcub) {
        this.estacionVcub = estacionVcub;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VcubEntity)) {
            return false;
        }
        VcubEntity other = (VcubEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniandes.csw.mueblesdelosalpes.persistencia.mock.VcubEntity[ id=" + id + " ]";
    }
    
}
