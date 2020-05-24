/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevobingo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Gabriel
 */
public final class CartonAmericano extends Carton {

    //======================ATRIBUTOS================================
    private final Patron premio;

    public final static int FILAS = 5;
    public final static int COLUMNAS = 5;

    //====================CONSTRUCTORES==============================
    public CartonAmericano(Patron premio) {
        super(FILAS, COLUMNAS);
        this.premio = premio;

        generarCarton();
    }

    //=======================MÉTODOS=================================
    @Override
    public void generarCarton() {
        int[] listaNumeros = new int[5];

        for (int i = 0; i < COLUMNAS; i++) {

            switch (i) {
                case 0:
                    listaNumeros = generarColumna(1, 15);
                    rellenarMatriz(i, listaNumeros);
                    break;
                case 1:
                    listaNumeros = generarColumna(16, 30);
                    rellenarMatriz(i, listaNumeros);
                    break;
                case 2:
                    listaNumeros = generarColumna(31, 45);
                    rellenarMatriz(i, listaNumeros);
                    break;
                case 3:
                    listaNumeros = generarColumna(46, 60);
                    rellenarMatriz(i, listaNumeros);
                    break;
                default:
                    listaNumeros = generarColumna(61, 75);
                    rellenarMatriz(i, listaNumeros);
                    break;
            }

        }

        this.getMatriz()[2][2] = 0;

    }

    public int[] generarColumna(int minimo, int maximo) {
        Random varRandom = new Random();
        ArrayList<Integer> listaNumeros = new ArrayList<>();
        int[] columna = new int[COLUMNAS];
        int numero;

        for (int i = 0; i < COLUMNAS; i++) {

            do {
                numero = varRandom.ints(minimo, 0, maximo).findFirst().getAsInt();
            } while (listaNumeros.contains(numero));

            listaNumeros.add(numero);

        }

        Collections.sort(listaNumeros);

        for (int i = 0; i < listaNumeros.size(); i++) {
            columna[i] = listaNumeros.get(i);
        }

        return columna;
    }

    public void rellenarMatriz(int columna, int[] numeros) {

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {

                this.getMatriz()[i][columna] = numeros[i];

            }
        }

    }

    //==================GETTERS & SETTERS============================
    public Patron getPatron() {
        return premio;
    }
    //======================TO STRING================================

   
}
