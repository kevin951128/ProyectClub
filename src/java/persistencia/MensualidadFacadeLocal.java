/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Mensualidad;

/**
 *
 * @author Kevin
 */
@Local
public interface MensualidadFacadeLocal {

    void create(Mensualidad mensualidad);

    void edit(Mensualidad mensualidad);

    void remove(Mensualidad mensualidad);

    Mensualidad find(Object id);

    List<Mensualidad> findAll();

    List<Mensualidad> findRange(int[] range);

    int count();
    
}
