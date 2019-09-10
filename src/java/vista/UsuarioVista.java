/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import logica.UsuarioLogicaLocal;
import modelo.Usuario;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.password.Password;

/**
 *
 * @author Kevin
 */
@Named(value = "usuarioVista")
@RequestScoped
public class UsuarioVista {

    @EJB
    private UsuarioLogicaLocal usuarioLogica;

    private InputText txtUsuario;
    private Password txtClave;
    private CommandButton btnIngresar;

    /**
     * Creates a new instance of UsuarioVista
     */
    public UsuarioVista() {
    }

    public InputText getTxtUsuario() {
        return txtUsuario;
    }

    public void setTxtUsuario(InputText txtUsuario) {
        this.txtUsuario = txtUsuario;
    }

    public Password getTxtClave() {
        return txtClave;
    }

    public void setTxtClave(Password txtClave) {
        this.txtClave = txtClave;
    }

    public CommandButton getBtnIngresar() {
        return btnIngresar;
    }

    public void setBtnIngresar(CommandButton btnIngresar) {
        this.btnIngresar = btnIngresar;
    }

    public void ingresar() {
        try {
            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setCedula(BigInteger.valueOf(Long.parseLong(txtUsuario.getValue().toString())));
            nuevoUsuario.setClave(getMD5(txtClave.getValue().toString()));
            Usuario usuarioLogueado = usuarioLogica.ingresar(nuevoUsuario);
            //Se guarda al usuario en la sesión
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuarioLogueado);
            //Redireccionamiento a pagina
            FacesContext.getCurrentInstance().getExternalContext().redirect("entrenador/paginaEntrenador.xhtml");
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", ex.getMessage()));
            Logger.getLogger(UsuarioVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cerrarSesion() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("usuario");
            FacesContext.getCurrentInstance().getExternalContext().redirect("../index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(UsuarioVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
