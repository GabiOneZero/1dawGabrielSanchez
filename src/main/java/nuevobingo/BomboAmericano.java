/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevobingo;

import java.util.Collections;
import java.util.List;

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

    //=======================MÉTODOS=================================
    @Override
    public void llenarBombo() {
        List<Integer> lista = null;

        for (int i = 0; i < CANTIDAD_BOLAS; i++) {
            lista.add(i);
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
