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
        BingoAmericano bA = bDAO.findByPk(codigo);

    }

    public void guardarPartida(BingoAmericano bingo) {
        BingoDAO bDAO = new BingoDAO();
        BingoVO bVO = new BingoVO();
        try {

            bVO.setFecha(bingo.getFecha());
            bVO.setIdJugador(bingo.getIdJugador());
            bVO.setTipo(1);
            bVO.setBombo(bingo.getBombo().getListaBolas());
            bVO.setBombo(arrayDeCarton(bingo));

            bDAO.insertBingo(bVO);
        } catch (Exception ex) {
            System.out.println("No se ha podido realizar la operación:");
        }
    }

    public ArrayList<Integer> arrayDeCarton(BingoAmericano bingo) {
        ArrayList<Integer> array = new ArrayList<>();
        for (int[] aux : bingo.getCarton().getMatriz()) {
            for (int i : aux) {
                array.add(i);
            }
        }

        return array;
    }

    public static void mostrarIdGuardados() {

    }
    
    
}
