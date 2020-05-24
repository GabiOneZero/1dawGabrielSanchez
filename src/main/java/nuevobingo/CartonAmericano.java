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
public final class CartonAmericano extends Carton {

    //======================ATRIBUTOS================================
    private final Patron premio;

    public final static int FILAS = 5;
    public final static int COLUMNAS = 5;

    //====================CONSTRUCTORES==============================
    public CartonAmericano(Patron premio) {
        super(FILAS, COLUMNAS);
        this.premio = premio;
    }

    //=======================MÉTODOS=================================
    @Override
    public void generarCarton() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //==================GETTERS & SETTERS============================
    public Patron getPatron() {
        return premio;
    }
    //======================TO STRING================================

    @Override
    public String toString() {
        return "CartonAmericano{" + "premio=" + premio + '}';
    }

}
