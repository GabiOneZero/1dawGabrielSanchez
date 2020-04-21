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
        this.numerosCarton = new int[3][9];
        generarCarton();
    }

    private void generarCarton() {
        Random varRandom = new Random();
        int nuevoNumero;
        int[] filaAnterior = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < this.numerosCarton.length; i++) { //FILAS

            for (int j = 0; j < this.numerosCarton[i].length; j++) { //COLUMNAS

                switch (j) {
                    case 0:
                        if (filaAnterior[j] == 9) {
                            this.numerosCarton[i][j] = 0;
                            break;
                        }
                        do {
                            nuevoNumero = varRandom.nextInt(9) + 1;
                        } while (nuevoNumero <= filaAnterior[j]);
                        filaAnterior[j] = nuevoNumero;
                        this.numerosCarton[i][j] = nuevoNumero;
                        break;

                    case 8:
                        if (filaAnterior[j] == 90) {
                            this.numerosCarton[i][j] = 0;
                            break;
                        }
                        do {
                            nuevoNumero = varRandom.nextInt(11) + 80;
                        } while (nuevoNumero <= filaAnterior[j] || nuevoNumero == 90);
                        filaAnterior[j] = nuevoNumero;
                        this.numerosCarton[i][j] = nuevoNumero;
                        break;

                    default:
                        if (filaAnterior[j] == ((j * 10) + 9)) {
                            this.numerosCarton[i][j] = 0;
                            break;
                        }
                        do {
                            nuevoNumero = varRandom.nextInt(10) + (j * 10);
                        } while (nuevoNumero <= filaAnterior[j]);
                        filaAnterior[j] = nuevoNumero;
                        this.numerosCarton[i][j] = nuevoNumero;
                        break;
                }

            }
        }

    }

    public void imprimirCarton() {

        for (int[] aux : this.numerosCarton) {
            for (int i : aux) {

                switch (i) {

                    case 0:
                        System.out.print(" \t");
                        break;
                    case -1:
                        System.out.print("X\t");
                        break;
                    default:
                        System.out.print(i + "\t");
                        break;
                }
            }
            System.out.println("");
        }

    }

}
