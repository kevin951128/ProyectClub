/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Usuario;
import persistencia.UsuarioFacadeLocal;

/**
 *
 * @author Kevin
 */
@Stateless
public class UsuarioLogica implements UsuarioLogicaLocal {

        @EJB
    public UsuarioFacadeLocal usuarioDAO;
    @Override
    public Usuario ingresar(Usuario usuario) throws Exception {
         if (usuario == null) {
            throw new Exception("Error, los campos son obligatorios");
        }
        if (usuario.getCedula() == null) {
            throw new Exception("Nombre de usuario obligatorio");
        }
        if (usuario.getClave().equals("")) {
            throw new Exception("Contraseña obligatoria");
        }

        Usuario objUsuario = usuarioDAO.findxCedula(usuario.getCedula());

        if (objUsuario == null) {
            throw new Exception("Usuario no registrado");
        }
        if (!objUsuario.getClave().equals(usuario.getClave())) {
            throw new Exception("Clave incorrecta");
        }
        return objUsuario;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
