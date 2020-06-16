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
    int insertBingo (BingoVO bingo);
    
    // Método para insertar varios registros
    int insertBingo (List<BingoVO> lista);
    
    // Método para borrar una persona
    int deleteBingo (BingoVO bVO);
    
    // Método para borrar toda la tabla
    int deleteBingo();
    
    // Método para modificar una persona. Se modifica a la persona que tenga esa 'pk'
    // con los nuevos datos que traiga la persona 'nuevosDatos'
    int updateBingo (int pk, BingoVO nuevosDatos);
}
