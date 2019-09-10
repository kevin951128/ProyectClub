/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import logica.AlumnoLogicaLocal;
import modelo.Alumno;

/**
 *
 * @author Kevin
 */
@Named(value = "alumnoVista")
@RequestScoped
public class AlumnoVista {
    
    @EJB
    private AlumnoLogicaLocal alumnoLogica;
            
    private List<Alumno> listaAlumnos;

    /**
     * Creates a new instance of AlumnoVista
     */
    public AlumnoVista() {
    }

    public List<Alumno> getListaAlumnos() {
        listaAlumnos = alumnoLogica.consultarAlumnos();
        return listaAlumnos;
    }

    public void setListaAlumnos(List<Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }
    
    
    public void cerrarSesion() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("usuario");
            FacesContext.getCurrentInstance().getExternalContext().redirect("../index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(UsuarioVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
