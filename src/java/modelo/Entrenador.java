/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kevin
 */
@Entity
@Table(name = "entrenador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entrenador.findAll", query = "SELECT e FROM Entrenador e")
    , @NamedQuery(name = "Entrenador.findByIdEntrenador", query = "SELECT e FROM Entrenador e WHERE e.idEntrenador = :idEntrenador")
    , @NamedQuery(name = "Entrenador.findByGrado", query = "SELECT e FROM Entrenador e WHERE e.grado = :grado")})
public class Entrenador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEntrenador")
    private Integer idEntrenador;
    @Size(max = 10)
    @Column(name = "Grado")
    private String grado;
    @JoinColumn(name = "Usuario_idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario usuarioidUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entrenadoridEntrenador")
    private List<Clase> claseList;

    public Entrenador() {
    }

    public Entrenador(Integer idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public Integer getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(Integer idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public Usuario getUsuarioidUsuario() {
        return usuarioidUsuario;
    }

    public void setUsuarioidUsuario(Usuario usuarioidUsuario) {
        this.usuarioidUsuario = usuarioidUsuario;
    }

    @XmlTransient
    public List<Clase> getClaseList() {
        return claseList;
    }

    public void setClaseList(List<Clase> claseList) {
        this.claseList = claseList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntrenador != null ? idEntrenador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entrenador)) {
            return false;
        }
        Entrenador other = (Entrenador) object;
        if ((this.idEntrenador == null && other.idEntrenador != null) || (this.idEntrenador != null && !this.idEntrenador.equals(other.idEntrenador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Entrenador[ idEntrenador=" + idEntrenador + " ]";
    }
    
}
