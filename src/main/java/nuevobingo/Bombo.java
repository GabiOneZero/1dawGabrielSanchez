/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevobingo;

import java.util.List;

/**
 *
 * @author Gabriel
 */
public abstract class Bombo {

    //======================ATRIBUTOS================================
    private List listaBolas;

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
        int bolas = 0;

        return bolas;
    }

    public boolean vacio() {
        boolean vacio = false;
        return vacio;
    }

    //==================GETTERS & SETTERS============================
    public List getListaBolas() {
        return listaBolas;
    }

    public void setListaBolas(List listaBolas) {
        this.listaBolas = listaBolas;
    }

    //======================TO STRING================================
    @Override
    public String toString() {
        return "Bombo{" + "listaBolas=" + listaBolas + '}';
    }

}
