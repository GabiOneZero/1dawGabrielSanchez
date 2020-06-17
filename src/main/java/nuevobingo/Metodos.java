/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevobingo;

import basedatos.BingoDAO;
import basedatos.BingoVO;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 * @version 1.0
 * @since 17 jun. 2020
 */
public class Metodos {

    public static BingoAmericano cargarPartida(int codigo) {
        BingoDAO bDAO = new BingoDAO();
        BingoAmericano bingo = bDAO.findByPk(codigo);       
        bDAO.deleteBingo(codigo);
        
        return bingo;
    }

    public static void guardarPartida(BingoAmericano bingo) {
        BingoDAO bDAO = new BingoDAO();
        BingoVO bVO = new BingoVO();
        try {
            bVO.setPk(generarPK());
            bVO.setFecha(bingo.getFecha());
            bVO.setIdJugador(bingo.getIdJugador());
            bVO.setTipo(1);
            bVO.setBombo(bingo.getBombo().getListaBolas());
            bVO.setCarton(arrayDeCarton(bingo));
            
            bDAO.insertBingo(bVO);
        } catch (Exception ex) {
            System.out.println("No se ha podido guardar la partida");
            System.out.println(ex.getMessage());
        }
    }

    public static ArrayList<Integer> arrayDeCarton(BingoAmericano bingo) {
        ArrayList<Integer> array = new ArrayList<>();
        for (int[] aux : bingo.getCarton().getMatriz()) {
            for (int i : aux) {
                array.add(i);
            }
        }

        return array;
    }

    public static CartonAmericano cartonDeArray(ArrayList<Integer> listaNumeros) {
        CartonAmericano carton = new CartonAmericano();

        for (int i = 0; i < CartonAmericano.COLUMNAS; i++) {
            for (int j = 0; j < CartonAmericano.FILAS; j++) {
                    carton.getMatriz()[i][j] = listaNumeros.get(i + j);
            }
        }
        return carton;
    }

    public static int generarPK(){
        return (int) (Math.random()* 9999999 + 1);
    }
    public static void mostrarIdGuardados() {

    }

}
