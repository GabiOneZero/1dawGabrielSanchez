/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevobingo;

import java.awt.Point;
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
    public CartonAmericano() {
        super(FILAS, COLUMNAS);
        premio = establecerPatron();
        generarCarton();
    }

    //=======================MÉTODOS=================================
    /**
     * Generamos un carton, generando las columnas una a una con numeros aleatorios
     */
    @Override
    public void generarCarton() {
        int[] listaNumeros;

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

    }

    /**
     * Genera una lista de números con la que llenaremos una sola columna
     * @param minimo el valor mínimo que podrá tomar una casilla en la columna actual
     * @param maximo valor máximo que podrá tener una casilla en la columna actual
     * @return la lista de números para rellenar la columna
     */
    public int[] generarColumna(int minimo, int maximo) {
        Random varRandom = new Random();
        ArrayList<Integer> listaNumeros = new ArrayList<>();
        int[] columna = new int[COLUMNAS];
        int numero;

        for (int i = 0; i < COLUMNAS; i++) {

            do {
                numero = varRandom.ints(minimo, maximo + 1).findFirst().getAsInt();
            } while (listaNumeros.contains(numero));

            listaNumeros.add(numero);

        }

        Collections.sort(listaNumeros);

        for (int i = 0; i < listaNumeros.size(); i++) {
            columna[i] = listaNumeros.get(i);
        }

        return columna;
    }

    /**
     * Rellena la matriz del cartón respetando el patrón establecido
     * @param columna la columna en la que nos encontramos
     * @param numeros la lista de numeros para la columna previamente generada
     */
    public void rellenarMatriz(int columna, int[] numeros) {
//
//        Point point = new Point();
//        point.setLocation(FILAS, FILAS);

        for (int i = 0; i < FILAS; i++) {
            if (this.premio.getCasillas().contains(new Point(i, columna))) {
                this.getMatriz()[i][columna] = numeros[i];
            } else {
                this.getMatriz()[i][columna] = 0;
            }
        }

    }

    /**
     * Establecemos de forma aleatoria uno de los patrones de números creados en el enum
     * @return devuelve el patrón escogido
     */
    public Patron establecerPatron() {
        Patron patron;
        int opcionPatron = (int) (Math.random() * 5 + 1);

        switch (opcionPatron) {
            case 1:
                patron = Patron.FORMA_CRUZ;
                break;
            case 2:
                patron = Patron.FORMA_X;
                break;
            case 3:
                patron = Patron.FORMA_Y;
                break;
            case 4:
                patron = Patron.MARCO;
                break;
            default:
                patron = Patron.CARTON_LLENO;
                break;

        }

        return patron;

    }

    /**
     * método con que el que mostraremos por consola el cartón con un formato concreto
     */
    public void mostrarCarton() {
        System.out.println("....................................................................");
        
        System.out.println("B\tI\tN\tG\tO");
        //Doble bucle for-each para recorrer la matriz
        for (int[] aux : this.getMatriz()) {
            for (int i : aux) {
                //Dependiendo del valor actual imprimiremos una cosa u otra
                switch (i) {

                    case 0: //Equivale a un hueco, por tanto imprimimos un espacio en blanco
                        System.out.print(" \t");
                        break;
                    case -1: //Quiere decir que es un número que ha salido en el bombo y ha sido marcado, entonces lo representamos con una X
                        System.out.print("X\t");
                        break;
                    default: //Por defecto se imprimirá en consola el número correspondiente
                        System.out.print(i + "\t");
                        break;
                }
            }
            System.out.println(""); //Salto después de cda lína para dar formato

        }
        System.out.println("....................................................................");

    }

    //==================GETTERS & SETTERS============================
    public Patron getPatron() {
        return premio;
    }
    //======================TO STRING================================

    @Override
    public String toString() {
        String cadenaNumeros = "";

        for (int i = 0; i < CartonAmericano.COLUMNAS; i++) {
            for (int j = 0; j < CartonAmericano.FILAS; j++) {
                cadenaNumeros += this.getMatriz()[i][j];
                cadenaNumeros += ",";
            }
        }
        cadenaNumeros = cadenaNumeros.substring(0, cadenaNumeros.length() - 1);
        return cadenaNumeros;
    }
}
