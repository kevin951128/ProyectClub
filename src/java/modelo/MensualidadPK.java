/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Kevin
 */
@Embeddable
public class MensualidadPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idMensualidad")
    private int idMensualidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Alumno_idAlumno")
    private int alumnoidAlumno;

    public MensualidadPK() {
    }

    public MensualidadPK(int idMensualidad, int alumnoidAlumno) {
        this.idMensualidad = idMensualidad;
        this.alumnoidAlumno = alumnoidAlumno;
    }

    public int getIdMensualidad() {
        return idMensualidad;
    }

    public void setIdMensualidad(int idMensualidad) {
        this.idMensualidad = idMensualidad;
    }

    public int getAlumnoidAlumno() {
        return alumnoidAlumno;
    }

    public void setAlumnoidAlumno(int alumnoidAlumno) {
        this.alumnoidAlumno = alumnoidAlumno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idMensualidad;
        hash += (int) alumnoidAlumno;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MensualidadPK)) {
            return false;
        }
        MensualidadPK other = (MensualidadPK) object;
        if (this.idMensualidad != other.idMensualidad) {
            return false;
        }
        if (this.alumnoidAlumno != other.alumnoidAlumno) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.MensualidadPK[ idMensualidad=" + idMensualidad + ", alumnoidAlumno=" + alumnoidAlumno + " ]";
    }
    
}
