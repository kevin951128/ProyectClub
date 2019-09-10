/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Categoria;

/**
 *
 * @author Kevin
 */
@Local
public interface CategoriaLogicaLocal {
    public List<Categoria> consultarCategorias();
}
