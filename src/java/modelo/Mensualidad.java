/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kevin
 */
@Entity
@Table(name = "mensualidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mensualidad.findAll", query = "SELECT m FROM Mensualidad m")
    , @NamedQuery(name = "Mensualidad.findByIdMensualidad", query = "SELECT m FROM Mensualidad m WHERE m.mensualidadPK.idMensualidad = :idMensualidad")
    , @NamedQuery(name = "Mensualidad.findByAlumnoidAlumno", query = "SELECT m FROM Mensualidad m WHERE m.mensualidadPK.alumnoidAlumno = :alumnoidAlumno")
    , @NamedQuery(name = "Mensualidad.findByFechaDePago", query = "SELECT m FROM Mensualidad m WHERE m.fechaDePago = :fechaDePago")
    , @NamedQuery(name = "Mensualidad.findByMes", query = "SELECT m FROM Mensualidad m WHERE m.mes = :mes")})
public class Mensualidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MensualidadPK mensualidadPK;
    @Column(name = "FechaDePago")
    @Temporal(TemporalType.DATE)
    private Date fechaDePago;
    @Size(max = 10)
    @Column(name = "Mes")
    private String mes;
    @JoinColumn(name = "Alumno_idAlumno", referencedColumnName = "idAlumno", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alumno alumno;

    public Mensualidad() {
    }

    public Mensualidad(MensualidadPK mensualidadPK) {
        this.mensualidadPK = mensualidadPK;
    }

    public Mensualidad(int idMensualidad, int alumnoidAlumno) {
        this.mensualidadPK = new MensualidadPK(idMensualidad, alumnoidAlumno);
    }

    public MensualidadPK getMensualidadPK() {
        return mensualidadPK;
    }

    public void setMensualidadPK(MensualidadPK mensualidadPK) {
        this.mensualidadPK = mensualidadPK;
    }

    public Date getFechaDePago() {
        return fechaDePago;
    }

    public void setFechaDePago(Date fechaDePago) {
        this.fechaDePago = fechaDePago;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mensualidadPK != null ? mensualidadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensualidad)) {
            return false;
        }
        Mensualidad other = (Mensualidad) object;
        if ((this.mensualidadPK == null && other.mensualidadPK != null) || (this.mensualidadPK != null && !this.mensualidadPK.equals(other.mensualidadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Mensualidad[ mensualidadPK=" + mensualidadPK + " ]";
    }
    
}
