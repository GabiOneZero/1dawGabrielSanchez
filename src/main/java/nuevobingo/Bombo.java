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
    //=======================MÉTODOS=================================

    public int sacarBola() {
        int numeroBola = 0;

        return numeroBola;
    }

    public abstract void llenarBombo();

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
        return "Bombo{" + "listaBolas=" + listaBolas + '}';
    }

}
