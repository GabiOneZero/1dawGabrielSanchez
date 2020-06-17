/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevobingo;

import basedatos.BingoDAO;
import basedatos.BingoVO;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Gabriel
 * @version 1.0
 * @since 17 jun. 2020
 */
public class Metodos {

    /**
     * Método que busca una partida guardada en la base de datos
     * @param codigo por el cual buscaremos la partida a cargar
     * @return devuelve el bingo cargado o null is no se encuentra ninguno
     */
    public static BingoAmericano buscarPartida(int codigo) {
        BingoDAO bDAO = new BingoDAO();
        BingoAmericano bingo = bDAO.findByPk(codigo);

        return bingo;
    }

    /**
     * Guarda una partida en curso en la base de datos para continuar en otro momento
     * @param bingo con la partida actual
     * @return el codigo de la partida para poder recuparla más tarde
     */
    public static int guardarPartida(BingoAmericano bingo) {
        BingoDAO bDAO = new BingoDAO();
        BingoVO bVO = new BingoVO();
        try {
            bVO.setPk(generarPK());
            bVO.setFecha(bingo.getFecha());
            bVO.setIdJugador(bingo.getIdJugador());
            bVO.setTipo(1);
            bVO.setBombo(bingo.getBombo().toString());
            bVO.setCarton(bingo.getCarton().toString());

            bDAO.insertBingo(bVO);

        } catch (Exception ex) {
            System.out.println("No se ha podido guardar la partida");
            System.out.println(ex.getMessage());
        }

        return bVO.getPk();
    }

    /**
     * Convierte un objeto carton en un arrayList de numeros
     * @param bingo que contiene el cartón que queremos convertir
     * @return devuelve un arraylist con los numeros que contenía ese cartón
     */
    public static ArrayList<Integer> arrayDeCarton(BingoAmericano bingo) {
        ArrayList<Integer> array = new ArrayList<>();
        for (int[] aux : bingo.getCarton().getMatriz()) {
            for (int i : aux) {
                array.add(i);
            }
        }

        return array;
    }

    /**
     * Convierte un arrayList de numeros en un objeto carton
     * @param listaNumeros que contiene los numeros que queremos convertir
     * @return devuelve un objeto carton que contiene los números de la lista
     */
    public static CartonAmericano cartonDeArray(ArrayList<Integer> listaNumeros) {
        CartonAmericano carton = new CartonAmericano();
        int iterador = 0;

        for (int i = 0; i < CartonAmericano.COLUMNAS; i++) {
            for (int j = 0; j < CartonAmericano.FILAS; j++) {
                carton.getMatriz()[i][j] = listaNumeros.get(iterador);
                iterador++;
            }
        }
        return carton;
    }

    /**
     * Genera aleatoriamente un número para usarlo como ID
     * @return devuelve el número creado, que será el código de la partida y la PK en la base de datos
     */
    public static int generarPK() {
        return (int) (Math.random() * 9999999 + 1);
    }

    /**
     * Crea una ArrayList de enteros a partir de un String
     * @param cadena el string que contendrá los números guardados del bombo o del carton 
     * @return devuelve un ArrayList que usaremos para volver a llenar el bombo o el carton
     */
    public static ArrayList<Integer> arrayDeString(String cadena) {
        ArrayList<String> cadenaNumeros = new ArrayList<>(Arrays.asList(cadena.split(",")));
        ArrayList<Integer> listaNumeros = new ArrayList<>();

        for (String aux : cadenaNumeros) {
            listaNumeros.add(Integer.valueOf(aux));
        }

        return listaNumeros;

    }

}
