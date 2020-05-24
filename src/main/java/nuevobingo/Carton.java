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
    
    public Point tacharNumero(int numero){
        Point punto = null;
        
        return punto;
        
    }
    
    public boolean esLinea(int numeroFila){
        
        return false;
        
    }
    
    public boolean esBingo(){
        return false;
        
    }
    //==================GETTERS & SETTERS============================
    //======================TO STRING================================
}
