/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kevin
 */
@Entity
@Table(name = "alumno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alumno.findAll", query = "SELECT a FROM Alumno a")
    , @NamedQuery(name = "Alumno.findByIdAlumno", query = "SELECT a FROM Alumno a WHERE a.idAlumno = :idAlumno")
    , @NamedQuery(name = "Alumno.findByDocumento", query = "SELECT a FROM Alumno a WHERE a.documento = :documento")
    , @NamedQuery(name = "Alumno.findByNombre", query = "SELECT a FROM Alumno a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Alumno.findByApellido", query = "SELECT a FROM Alumno a WHERE a.apellido = :apellido")
    , @NamedQuery(name = "Alumno.findByFechaNacimiento", query = "SELECT a FROM Alumno a WHERE a.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Alumno.findByGrado", query = "SELECT a FROM Alumno a WHERE a.grado = :grado")
    , @NamedQuery(name = "Alumno.findByFechaIngreso", query = "SELECT a FROM Alumno a WHERE a.fechaIngreso = :fechaIngreso")
    , @NamedQuery(name = "Alumno.findByTelefono", query = "SELECT a FROM Alumno a WHERE a.telefono = :telefono")
    , @NamedQuery(name = "Alumno.findByDireccion", query = "SELECT a FROM Alumno a WHERE a.direccion = :direccion")
    , @NamedQuery(name = "Alumno.findByEps", query = "SELECT a FROM Alumno a WHERE a.eps = :eps")})
public class Alumno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAlumno")
    private Integer idAlumno;
    @Column(name = "Documento")
    private BigInteger documento;
    @Size(max = 20)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 20)
    @Column(name = "Apellido")
    private String apellido;
    @Column(name = "FechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Size(max = 20)
    @Column(name = "Grado")
    private String grado;
    @Column(name = "FechaIngreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Column(name = "Telefono")
    private BigInteger telefono;
    @Size(max = 30)
    @Column(name = "Direccion")
    private String direccion;
    @Size(max = 10)
    @Column(name = "Eps")
    private String eps;
    @JoinTable(name = "asistencia", joinColumns = {
        @JoinColumn(name = "Alumno_idAlumno", referencedColumnName = "idAlumno")}, inverseJoinColumns = {
        @JoinColumn(name = "Clase_idClase", referencedColumnName = "idClase")})
    @ManyToMany
    private List<Clase> claseList;
    @JoinColumn(name = "Categoria_idCategoria", referencedColumnName = "idCategoria")
    @ManyToOne(optional = false)
    private Categoria categoriaidCategoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno")
    private List<Mensualidad> mensualidadList;

    public Alumno() {
    }

    public Alumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public BigInteger getDocumento() {
        return documento;
    }

    public void setDocumento(BigInteger documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public BigInteger getTelefono() {
        return telefono;
    }

    public void setTelefono(BigInteger telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    @XmlTransient
    public List<Clase> getClaseList() {
        return claseList;
    }

    public void setClaseList(List<Clase> claseList) {
        this.claseList = claseList;
    }

    public Categoria getCategoriaidCategoria() {
        return categoriaidCategoria;
    }

    public void setCategoriaidCategoria(Categoria categoriaidCategoria) {
        this.categoriaidCategoria = categoriaidCategoria;
    }

    @XmlTransient
    public List<Mensualidad> getMensualidadList() {
        return mensualidadList;
    }

    public void setMensualidadList(List<Mensualidad> mensualidadList) {
        this.mensualidadList = mensualidadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlumno != null ? idAlumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.idAlumno == null && other.idAlumno != null) || (this.idAlumno != null && !this.idAlumno.equals(other.idAlumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Alumno[ idAlumno=" + idAlumno + " ]";
    }
    
}
