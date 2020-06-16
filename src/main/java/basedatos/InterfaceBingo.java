/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedatos;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public interface InterfaceBingo {
    List<BingoVO> getAll() throws SQLException;
    
    // Méodo para obtener un registro a partir de la PK
    BingoVO findByPk(int pk);
    
    // Método para insertar un registro
    int insertPersona (BingoVO persona);
    
    // Método para insertar varios registros
    int insertPersona (List<BingoVO> lista);
    
    // Método para borrar una persona
    int deletePersona (BingoVO p);
    
    // Método para borrar toda la tabla
    int deletePersona();
    
    // Método para modificar una persona. Se modifica a la persona que tenga esa 'pk'
    // con los nuevos datos que traiga la persona 'nuevosDatos'
    int updatePersona (int pk, BingoVO nuevosDatos);
}
