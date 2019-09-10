/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Categoria;
import persistencia.CategoriaFacadeLocal;

/**
 *
 * @author Kevin
 */
@Stateless
public class CategoriaLogica implements CategoriaLogicaLocal {

    @EJB
    private CategoriaFacadeLocal categoriaDAO;
    
    @Override
    public List<Categoria> consultarCategorias() {
        return categoriaDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Categoria consultarxCodigo(int codigo) {
        Categoria objCategoria = categoriaDAO.find(codigo);
        return objCategoria;
    }
}
