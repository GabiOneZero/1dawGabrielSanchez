/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevobingo;

/**
 *
 * @author Gabriel
 */
public class BomboEuropeo extends Bombo {

    //======================ATRIBUTOS================================
    public static final int cantidadBolas = 90;

    //====================CONSTRUCTORES==============================
    public BomboEuropeo() {

    }

    //=======================MÉTODOS=================================
    @Override
    public void llenarBombo() {

    }

    //==================GETTERS & SETTERS============================
    public static int getCantidadBolas() {
        return cantidadBolas;
    }

    //======================TO STRING================================
    @Override
    public String toString() {
        return "BomboEuropeo{" + '}';
    }

}
