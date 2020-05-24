/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevobingo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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

        generarCarton();
    }

    //=======================MÉTODOS=================================
    @Override
    public void generarCarton() {

        int nuevoNumero;
        int[] columna = new int[5];

        for (int i = 0; i < this.getMatriz().length; i++) {

            for (int j = 0; j < this.getMatriz()[i].length; j++) {

                switch (j) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    default:
                        break;
                }
            }

        }

    }

    public ArrayList<Integer> generarColumna(int minimo, int maximo) {
        Random varRandom = new Random();
        ArrayList<Integer> columna = new ArrayList<>();
        int numero;

        for (int i = 0; i < COLUMNAS; i++) {

            do {
                numero = varRandom.ints(minimo, 0, maximo).findFirst().getAsInt();
            } while (columna.contains(numero));
            
            columna.add(numero);

        }
        
        Collections.sort(columna);

        return columna;
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
