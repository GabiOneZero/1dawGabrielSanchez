/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevobingo;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Gabriel
 */
public final class BomboAmericano extends Bombo {

    //======================ATRIBUTOS================================
    public static final int CANTIDAD_BOLAS = 90;

    //====================CONSTRUCTORES==============================
    public BomboAmericano() {
        super();
        llenarBombo();
    }
    
    public BomboAmericano(ArrayList<Integer> listaBolas){
        super(listaBolas);
    }

    //=======================MÉTODOS=================================
    @Override
    public void llenarBombo() {
        ArrayList<Integer> lista = new ArrayList<>();

        for (int i = 0; i < CANTIDAD_BOLAS; i++) {
            lista.add(i + 1);
        }
        Collections.shuffle(lista);
        super.setListaBolas(lista);

    }

    //==================GETTERS & SETTERS============================
    public static int getCantidadBolas() {
        return CANTIDAD_BOLAS;
    }

    //======================TO STRING================================
    @Override
    public String toString() {
        return "BomboAmericano{" + '}';
    }

}
