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
public final class CartonEuropeo extends Carton {

    //======================ATRIBUTOS================================
    public static final int FILAS = 3;
    public static final int COLUMNAS = 9;

    //====================CONSTRUCTORES==============================
    public CartonEuropeo() {
        super(FILAS, COLUMNAS);
    }

    //=======================MÉTODOS=================================
    @Override
    public void generarCarton() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //==================GETTERS & SETTERS============================
    //======================TO STRING================================

    @Override
    public String toString() {
        return "CartonEuropeo{" + '}';
    }
    
}
