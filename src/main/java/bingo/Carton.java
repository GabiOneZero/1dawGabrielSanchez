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

    //Como los cartones serán siempre iguales en tamaño usaremos solo un Constructor sin parámetros
    //estableciendo el tamaño (3 x 9) y rellenando la matriz haciendo uso de otro método (generarCarton())
    public Carton() {
        this.numerosCarton = new int[3][9];
        generarCarton();
    }

    //En este método se generarán los números aleatoriamente para el cartón en cuestión, 
    //siguiendo las directrices establecidas en cuanto a la colocación de los números
    //Es un método "private" ya que solo querremos tener acceso a él desde la propia clase
    //para usarlo en el constructor
    private void generarCarton() {
        Random varRandom = new Random();

        int nuevoNumero;  //El número que generaremos y colocaremos en cada posición del cartón
        int[] filaAnterior = {0, 0, 0, 0, 0, 0, 0, 0, 0}; //Array que contendrá los números de la fila anterior para comprobaciones
        for (int i = 0; i < this.numerosCarton.length; i++) { //Recorremos las 3 FILAS

            for (int j = 0; j < this.numerosCarton[i].length; j++) { //Recorremos las 9 COLUMNAS

                //Dependiendo de en qué columna nos encontremos establecemos los número de una forma u otra
                switch (j) {

                    case 0: //1ª Columna
                        //Comprobamos que no haya salido ya el máximo número permitido para la columna actual (9)
                        //Si ya ha salido el máximo número posible para la columna establecemos un hueco (0)
                        if (filaAnterior[j] == 9) {
                            this.numerosCarton[i][j] = 0;
                            break;
                        }
                        //Establecemos un número aleatoriamente en el rango permitido para la columna (entre 1 y 9)
                        //y controlando que sea mayor que el número superior
                        do {
                            nuevoNumero = varRandom.nextInt(9) + 1;
                        } while (nuevoNumero <= filaAnterior[j]);
                        filaAnterior[j] = nuevoNumero; //Actualizamos los número de la fila anterior
                        this.numerosCarton[i][j] = nuevoNumero; //Puesto que es correcto establecemos el número en la posición del cartón correspondiente
                        break;

                    case 8: //9ª columna
                        //Comprobamos que no haya salido ya el máximo número permitido para la columna actual (90)
                        //Si ya ha salido el máximo número posible para la columna establecemos un hueco (0)
                        if (filaAnterior[j] == 90) {
                            this.numerosCarton[i][j] = 0;
                            break;
                        }
                        //Establecemos un número aleatoriamente en el rango permitido para la columna (80 y el 90)
                        //y controlando que sea mayor que el número superior
                        do {
                            nuevoNumero = varRandom.nextInt(11) + 80;
                        } while (nuevoNumero <= filaAnterior[j] || nuevoNumero == 90);
                        filaAnterior[j] = nuevoNumero; //Actualizamos los número de la fila anterior
                        this.numerosCarton[i][j] = nuevoNumero; //Puesto que es correcto establecemos el número en la posición del cartón correspondiente
                        break;

                    default: //El resto de columnas (2ª a 8ª)
                        //Comprobamos que no haya salido ya el máximo número permitido para la columna actual(19, 29, 39, 49, 59, 69 ó 79)
                        //Si ya ha salido el máximo número posible para la columna establecemos que hay un hueco (0)
                        if (filaAnterior[j] == ((j * 10) + 9)) {
                            this.numerosCarton[i][j] = 0;
                            break;
                        }
                        //Establecemos un número aleatoriamente en el rango permitido para la columna, la decena correspondiente dependiendo de la columna actual)
                        //y controlando que sea mayor que el número superior
                        do {
                            nuevoNumero = varRandom.nextInt(10) + (j * 10);
                        } while (nuevoNumero <= filaAnterior[j]);
                        filaAnterior[j] = nuevoNumero; //Actualizamos los número de la fila anterior
                        this.numerosCarton[i][j] = nuevoNumero; //Puesto que es correcto establecemos el número en la posición del cartón correspondiente
                        break;
                }

            }
        }

    }

    //Imrpimimos los números guardados en el cartón
    //y le damos formato
    public void imprimirCarton() {

        //Doble bucle for-each para recorrer la matriz
        for (int[] aux : this.numerosCarton) {
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
            System.out.println(""); //Salto después de cda lína imprimida para dar formato
        }

    }

}
