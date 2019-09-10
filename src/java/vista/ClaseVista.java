/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import logica.CategoriaLogicaLocal;
import logica.ClaseLogicaLocal;
import logica.EntrenadorLogicaLocal;
import modelo.Categoria;
import modelo.Clase;
import modelo.Entrenador;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;

/**
 *
 * @author Kevin
 */
@Named(value = "claseVista")
@RequestScoped
public class ClaseVista {

    @EJB
    private ClaseLogicaLocal claseLogica;
    
    @EJB
    private EntrenadorLogicaLocal entrenadorLogica;
    
    @EJB
    private CategoriaLogicaLocal categoriaLogica;
    
    private List<Clase> listaClases;
    private Calendar fecha;
    private Calendar hora;
    private SelectOneMenu cmbEntrenador;
    private SelectOneMenu cmbCategoria;
    private List<String> listaEntrenadores;
    private List<String> listaCategorias;
    private InputText txtDescripcion;
    private InputText txtLugar;
    private Entrenador e;
    private Categoria c;
    /**
     * Creates a new instance of ClaseVista
     */
    public ClaseVista() {
    }

    public List<Clase> getListaClases() {
        listaClases = claseLogica.consultarClases();
        return listaClases;
    }

    public void setListaClases(List<Clase> listaClases) {
        this.listaClases = listaClases;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public Calendar getHora() {
        return hora;
    }

    public void setHora(Calendar hora) {
        this.hora = hora;
    }

    public SelectOneMenu getCmbEntrenador() {
        return cmbEntrenador;
    }

    public void setCmbEntrenador(SelectOneMenu cmbEntrenador) {
        this.cmbEntrenador = cmbEntrenador;
    }

    public SelectOneMenu getCmbCategoria() {
        return cmbCategoria;
    }

    public void setCmbCategoria(SelectOneMenu cmbCategoria) {
        this.cmbCategoria = cmbCategoria;
    }

    public List<String> getListaEntrenadores() {
        listaEntrenadores = new ArrayList<>();
        List<Entrenador> listica = entrenadorLogica.consultarEntrenadores();
        for (int i = 0; i < listica.size(); i++) {
                listaEntrenadores.add(listica.get(i).getUsuarioidUsuario().getNombre() + " " + listica.get(i).getUsuarioidUsuario().getApellido());
        }
        return listaEntrenadores;
    }

    public void setListaEntrenadores(List<String> listaEntrenadores) {
        this.listaEntrenadores = listaEntrenadores;
    }

    public List<String> getListaCategorias() {
        listaCategorias = new ArrayList<>();
        List<Categoria> listica = categoriaLogica.consultarCategorias();
        for (int i = 0; i < listica.size(); i++) {
                listaCategorias.add(listica.get(i).getNombre());
            
        }
        return listaCategorias;
    }

    public void setListaCategorias(List<String> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    public InputText getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(InputText txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }

    public InputText getTxtLugar() {
        return txtLugar;
    }

    public void setTxtLugar(InputText txtLugar) {
        this.txtLugar = txtLugar;
    }
    
    public void registrarClase() throws Exception{
        Clase nuevaClase = new Clase();
        nuevaClase.setDescripcion(txtDescripcion.getValue().toString());
        nuevaClase.setLugar(txtLugar.getValue().toString());
        nuevaClase.setHorario((Date) hora.getValue());
        nuevaClase.setFecha((Date) fecha.getValue());
        
        if(cmbEntrenador.getValue().equals("Kevin Vargas")){
            e = entrenadorLogica.consultarxCodigo(1);
        }
        if(cmbEntrenador.getValue().equals("Ivan Reyes")){
            e = entrenadorLogica.consultarxCodigo(2);
        }
        nuevaClase.setEntrenadoridEntrenador(e);
        
        
        if(cmbCategoria.getValue().toString().equals("Infantil")){
            c = categoriaLogica.consultarxCodigo(1);
        }
        if(cmbCategoria.getValue().toString().equals("Juvenil")){
            c = categoriaLogica.consultarxCodigo(2);
        }
        if(cmbCategoria.getValue().toString().equals("Mayores")){
            c = categoriaLogica.consultarxCodigo(3);
        }
        
        
        nuevaClase.setCategoriaidCategoria(c);
        
        claseLogica.RegistrarClase(nuevaClase);
        
        
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
