/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedatos;

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
import nuevobingo.*;

/**
 *
 * @author Gabriel
 * @version 1.0
 * @since 16 jun. 2020
 */
public class BingoDAO implements InterfaceBingo {

    //======================ATRIBUTOS================================
    private Connection con = null;

    //====================CONSTRUCTORES==============================
    public BingoDAO() {
        con = Conexion.getInstance();
    }

    //=======================MÉTODOS=================================
    /**
     * Obtiene todos los bingos registrados en la base de datos
     * @return devuelve todos los resultados en una lista
     */
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
                // Recogemos los datos del bingo, guardamos en un objeto
                bVO.setPk(res.getInt("pk"));
                bVO.setFecha(res.getDate("fecha").toLocalDate());
                bVO.setIdJugador(res.getString("idJugador"));
                bVO.setTipo(res.getInt("tipo"));
                bVO.setBombo(res.getString("bombo"));
                bVO.setCarton(res.getString("carton"));

                //Añadimos el objeto a la lista
                lista.add(bVO);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BingoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    /**
     * Busca una partida registrada en la base de datos, buscándola por la PK
     * @param pk o código de la partida guardada
     * @return el bingo guardado seleccionado
     */
    @Override
    public BingoAmericano findByPk(int pk) {

        ResultSet res = null;
        BingoAmericano bingo = new BingoAmericano();

        String sql = "select * from bingo where pk=?";

        try (PreparedStatement prest = con.prepareStatement(sql)) {
            // Preparamos la sentencia parametrizada
            prest.setInt(1, pk);

            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            res = prest.executeQuery();

            // Nos posicionamos en el primer registro del Resultset. Sólo debe haber una fila
            // si existe esa pk
            if (res.next()) {
                // Recogemos los datos del bingo, guardamos en un objeto
                bingo.setId(String.valueOf(res.getInt("pk")));
                bingo.setFecha(res.getDate("fecha").toLocalDate());
                bingo.setIdJugador(res.getString("idJugador"));
                bingo.setBombo(new BomboAmericano(Metodos.arrayDeString(res.getString("bombo"))));
                bingo.setCarton(Metodos.cartonDeArray(Metodos.arrayDeString(res.getString("carton"))));
                return bingo;
            }

            return null;
        } catch (SQLException ex) {
            Logger.getLogger(BingoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Inserta un solo registro en la tabla bingo de nuestra base de datos
     * @param bingo
     * @return el número de filas total de registros
     */
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
                prest.setString(5, bingo.getBombo());
                prest.setString(6, bingo.getCarton());

                numFilas = prest.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(BingoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return numFilas;
        }

    }

    /**
     * Inserta varios registros en la base de datos pero desde una lista
     * @param lista
     * @return el número de filas total
     */
    @Override
    public int insertBingo(List<BingoVO> lista) {
        int numFilas = 0;

        for (BingoVO tmp : lista) {
            numFilas += insertBingo(tmp);
        }

        return numFilas;
    }

    /**
     * Borra todos los registros existentes en la tabla bingo de la base de datos
     * @return el número de filas que han sido borradas
     */
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

    /**
     * Borra un solo registro de la tabla
     * @param pk perteneciente al registro que queremos borrar
     * @return el número de filas afectadas
     */
    @Override
    public int deleteBingo(int pk) {
        int numFilas = 0;

        String sql = "delete from bingo where pk = ?";

        // Sentencia parametrizada
        try (PreparedStatement prest = con.prepareStatement(sql)) {

            // Establecemos los parámetros de la sentencia
            prest.setInt(1, pk);
            // Ejecutamos la sentencia
            numFilas = prest.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BingoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numFilas;
    }

    /**
     * Actualiza un registro en la tabla bingo de nuestra base de datos
     * @param pk del bingo en cuestión
     * @param nuevosDatos los nuevos datos que queremos cambiar
     * @return el numero de filas total
     */
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
                prest.setString(5, nuevosDatos.getBombo());
                prest.setString(6, nuevosDatos.getCarton());

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
