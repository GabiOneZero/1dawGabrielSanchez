/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevobingo;

import java.awt.Point;

/**
 *
 * @author Gabriel
 */
public abstract class Carton {

    //======================ATRIBUTOS================================
    private int[][] matriz;

    //====================CONSTRUCTORES==============================
    public Carton(int filas, int columnas) {
        this.matriz = new int[filas][columnas];
    }

    //=======================MÉTODOS=================================
    public abstract void generarCarton();
    
    
    /**
     * Cambia por un -1 el número tachado
     * @param numero que acaba de salir en el bombo
     * @return devuelve un Point con las coordenadas del número tachado
     */
    public Point tacharNumero(int numero) {
        Point punto = null;
        
         for (int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz[i].length; j++) {

                if (this.matriz[i][j] == numero) {
                    this.matriz[i][j] = -1;
                    return new Point(i, j);
                }
            }
        }

        return punto;

    }

    /**
     * Comprueba si todos los numeros de la fila han sido tachados
     * @param numeroFila en la que nos encontramos
     * @return devuelve true si efectivamente se canta línea
     */
    public boolean esLinea(int numeroFila) {

       for (int i = 0; i < this.matriz[numeroFila].length; i++) {
            if (this.matriz[numeroFila][i] != -1 && this.matriz[numeroFila][i] != 0) {
                return false;
            }
        }
        return true;

    }

    /**
     * Se comprueba si todos los numeros han sido tachados
     * @return devuelve true si se canta Bingo
     */
    public boolean esBingo() {
        
        
         for (int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz[i].length; j++) {

                if (this.matriz[i][j] != -1 && this.matriz[i][j] != 0) {
                return false;
            }
            }
        }
        return false;

    }

    //==================GETTERS & SETTERS============================
    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }
    
}
