/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevobingo;

import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public abstract class Bombo {

    //======================ATRIBUTOS================================
    private ArrayList<Integer> listaBolas;

    //====================CONSTRUCTORES==============================
    public Bombo() {
    }

    public Bombo(ArrayList<Integer> listaBolas){
        this.listaBolas = listaBolas;
    }
    //=======================MÉTODOS=================================
    /**
     * Elimina el primer numero del bombo, que al estar mezclado será aleatorio
     * @return devuelve el numero eleiminado
     */
    public int sacarBola() {
        
        return this.listaBolas.remove(0);
    }

    /**
     * Método abstracto para llenar el bombo según el numero de bolas que éste tenga
     */
    public abstract void llenarBombo();

    
    /**
     * Cuenta las bolas que aun no han salido
     * @return devuelve el número de bolas restante en el bombo
     */
    public int bolasDentro() {
        int numeroBolas = 0;

        for (int i = 0; i < this.listaBolas.size(); i++) {
            if (this.listaBolas.get(i) != 0) {
            } else {
                numeroBolas++;
            }
        }
        return numeroBolas;
    }

    /**
     * comprueba si el bombo está o no vacío
     * @return devuelve true si lo está
     */
    public boolean vacio() {

        return this.listaBolas.isEmpty();
    }

    //==================GETTERS & SETTERS============================
    public ArrayList getListaBolas() {
        return this.listaBolas;
    }

    public void setListaBolas(ArrayList listaBolas) {
        this.listaBolas = listaBolas;
    }

    //======================TO STRING================================
    @Override
    public String toString() {
        String cadenaNumeros = "";

        for (int i = 0; i < listaBolas.size(); i++) {
                cadenaNumeros += this.listaBolas.get(i);
                cadenaNumeros += ",";
            
        }
        cadenaNumeros = cadenaNumeros.substring(0, cadenaNumeros.length() - 1);
        return cadenaNumeros;
    }

}
