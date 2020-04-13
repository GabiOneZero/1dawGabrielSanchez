/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

import java.util.Random;

/**
 *
 * @author Gabriel
 */
public class Carton {

    private int[][] numerosCarton;

    public Carton() {
        this.numerosCarton = numerosCarton;
    }

    public void generarCarton() {
        Random varRandom = new Random();
        int nuevoNumero;

        for (int i = 0; i < this.numerosCarton.length; i++) {

            for (int j = 0; j < this.numerosCarton[i].length; j++) {

                switch (i) {
                    case 0:
                        nuevoNumero = varRandom.nextInt(9) + 1;
                        break;
                    case 8:
                        nuevoNumero = varRandom.nextInt(11) + 80;
                        break;
                    default:
                        nuevoNumero = varRandom.nextInt(10) + i * 10;
                        break;
                }
//                if (columna.contains(bola)) {
//                    j--;
//                } else {
//                    numeros[j][i] = bola;
//                    marcados[j][i] = false;
//                    columna.add(bola);
//                }
            }
        }
    }

}
