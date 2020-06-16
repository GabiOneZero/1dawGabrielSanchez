/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedatos;

import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 * @version 1.0
 * @since 16 jun. 2020
 */
public class BingoDAO implements InterfaceBingo {

    private Connection con = null;

    public BingoDAO() {
        con = Conexion.getInstance();
    }

    @Override
    public List<BingoVO> getAll() {
        List<BingoVO> lista = new ArrayList<>();

        // Preparamos la consulta de datos mediante un objeto Statement
        // ya que no necesitamos parametrizar la sentencia SQL
        try (Statement st = con.createStatement()) {
            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            ResultSet res = st.executeQuery("select * from bingo");
            // Ahora construimos la lista, recorriendo el ResultSet y mapeando los datos
            while (res.next()) {
                BingoVO bVO = new BingoVO();
                // Recogemos los datos de la persona, guardamos en un objeto
                bVO.setPk(res.getInt("pk"));
                bVO.setFecha(res.getDate("fecha").toLocalDate());
                bVO.setIdJugador(res.getString("jugador"));
                bVO.setTipo(res.getInt("tipo"));
                bVO.setBombo((ArrayList<Integer>) res.getArray("bombo"));
                bVO.setBombo((ArrayList<Integer>) res.getArray("carton"));

                //Añadimos el objeto a la lista
                lista.add(bVO);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BingoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    @Override
    public BingoVO findByPk(int pk) {

        ResultSet res = null;
        BingoVO bingo = new BingoVO();

        String sql = "select * from bingo where pk=?";

        try (PreparedStatement prest = con.prepareStatement(sql)) {
            // Preparamos la sentencia parametrizada
            prest.setInt(1, pk);

            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            res = prest.executeQuery();

            // Nos posicionamos en el primer registro del Resultset. Sólo debe haber una fila
            // si existe esa pk
            if (res.next()) {
                // Recogemos los datos de la persona, guardamos en un objeto
                bingo.setPk(res.getInt("pk"));
                bingo.setFecha(res.getDate("fecha").toLocalDate());
                bingo.setIdJugador(res.getString("jugador"));
                bingo.setTipo(res.getInt("tipo"));
                bingo.setBombo((ArrayList<Integer>) res.getArray("bombo"));
                bingo.setBombo((ArrayList<Integer>) res.getArray("carton"));
                return bingo;
            }

            return null;
        } catch (SQLException ex) {
            Logger.getLogger(BingoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int insertBingo(BingoVO bingo) {

        int numFilas = 0;
        String sql = "insert into bingo values (?,?,?,?,?,?)";

        if (findByPk(bingo.getPk()) != null) {
            // Existe un registro con esa pk
            // No se hace la inserción
            return numFilas;
        } else {
            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try (PreparedStatement prest = con.prepareStatement(sql)) {

                // Establecemos los parámetros de la sentencia
                prest.setInt(1, bingo.getPk());
                prest.setDate(2, Date.valueOf(bingo.getFecha()));
                prest.setString(3, bingo.getIdJugador());
                prest.setInt(4, bingo.getTipo());
                prest.setArray(5, (Array) bingo.getBombo());
                prest.setArray(5, (Array) bingo.getCarton());

                numFilas = prest.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(BingoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return numFilas;
        }

    }

    @Override
    public int insertBingo(List<BingoVO> lista) {
        int numFilas = 0;

        for (BingoVO tmp : lista) {
            numFilas += insertBingo(tmp);
        }

        return numFilas;
    }

    @Override
    public int deleteBingo() {

        String sql = "delete from bingo";

        int nfilas = 0;

        // Preparamos el borrado de datos  mediante un Statement
        // No hay parámetros en la sentencia SQL
        try (Statement st = con.createStatement()) {
            // Ejecución de la sentencia
            nfilas = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(BingoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        // El borrado se realizó con éxito, devolvemos filas afectadas
        return nfilas;

    }

    @Override
    public int deleteBingo(BingoVO bingo) {
        int numFilas = 0;

        String sql = "delete from bingo where pk = ?";

        // Sentencia parametrizada
        try (PreparedStatement prest = con.prepareStatement(sql)) {

            // Establecemos los parámetros de la sentencia
            prest.setInt(1, bingo.getPk());
            // Ejecutamos la sentencia
            numFilas = prest.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BingoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numFilas;
    }

    @Override
    public int updateBingo(int pk, BingoVO nuevosDatos) {

        int numFilas = 0;
        String sql = "update bingo set fecha = ?, idJugador = ?, tipo = ?, bombo = ?, carton = ? where pk = ?";

        if (findByPk(pk) == null) {
            // La persona a actualizar no existe
            return numFilas;
        } else {
            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try (PreparedStatement prest = con.prepareStatement(sql)) {

                // Establecemos los parámetros de la sentencia
                prest.setInt(1, pk);
                prest.setDate(2, Date.valueOf(nuevosDatos.getFecha()));
                prest.setString(3, nuevosDatos.getIdJugador());
                prest.setInt(4, nuevosDatos.getTipo());
                prest.setArray(5, (Array) nuevosDatos.getBombo());
                prest.setArray(5, (Array) nuevosDatos.getCarton());

                numFilas = prest.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(BingoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return numFilas;
        }
    }

//    public int cambiarNombres(String newName, String oldName){
//
//        int res = 0;
//        // Dos ?, uno para newName y otro para oldName
//
//        String sql = "{call cambiar_nombres (?,?)}";
//
//        // Preparamos la llamada al procedimiento almacenado
//        try (CallableStatement call = con.prepareCall(sql)) {
//            // Establecemos parámetros a pasar al procedimiento
//            call.setString(1, newName);
//            call.setString(2, oldName);
//            // Ejecutamos el procedimiento
//            res = call.executeUpdate();
//
//        }
//        return res;
//    }

}
