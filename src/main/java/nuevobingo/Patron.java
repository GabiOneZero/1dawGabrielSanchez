/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevobingo;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public enum Patron {

    CARTON_LLENO(cartonLleno(), "Cartón lleno", "Cartón con números en todas las casillas."),
    MARCO(marco(), "Marco", "Cartón con números solo en el borde exterior del cartón"),
    FORMA_CRUZ(cruz(),"Cruz", "Cartón con números formando una +"),
    FORMA_X(cartonX(), "X", "Cartón con números formando una X."),
    FORMA_Y(cartonY(), "Y", "Cartón con números formando una Y.");

    private ArrayList<Point> casillas;
    private String descripcion;
    private String nombre;

    Patron(ArrayList<Point> casillas, String nombre, String descripcion) {
        this.casillas = casillas;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    private static ArrayList<Point> cartonLleno() {
        ArrayList<Point> listaPuntos = new ArrayList<>();

        listaPuntos.add(new Point(0, 0));
        listaPuntos.add(new Point(0, 1));
        listaPuntos.add(new Point(0, 2));
        listaPuntos.add(new Point(0, 3));
        listaPuntos.add(new Point(0, 4));

        listaPuntos.add(new Point(1, 0));
        listaPuntos.add(new Point(1, 1));
        listaPuntos.add(new Point(1, 2));
        listaPuntos.add(new Point(1, 3));
        listaPuntos.add(new Point(1, 4));

        listaPuntos.add(new Point(2, 0));
        listaPuntos.add(new Point(2, 1));
        listaPuntos.add(new Point(2, 2));
        listaPuntos.add(new Point(2, 3));
        listaPuntos.add(new Point(2, 4));

        listaPuntos.add(new Point(3, 0));
        listaPuntos.add(new Point(3, 1));
        listaPuntos.add(new Point(3, 2));
        listaPuntos.add(new Point(3, 3));
        listaPuntos.add(new Point(3, 4));

        listaPuntos.add(new Point(4, 0));
        listaPuntos.add(new Point(4, 1));
        listaPuntos.add(new Point(4, 2));
        listaPuntos.add(new Point(4, 3));
        listaPuntos.add(new Point(4, 4));

        return listaPuntos;
    }

    private static ArrayList<Point> marco() {
        ArrayList<Point> listaPuntos = new ArrayList<>();

        listaPuntos.add(new Point(0, 0));
        listaPuntos.add(new Point(0, 1));
        listaPuntos.add(new Point(0, 2));
        listaPuntos.add(new Point(0, 3));
        listaPuntos.add(new Point(0, 4));

        listaPuntos.add(new Point(1, 0));
        listaPuntos.add(new Point(1, 4));

        listaPuntos.add(new Point(2, 0));
        listaPuntos.add(new Point(2, 4));

        listaPuntos.add(new Point(3, 0));
        listaPuntos.add(new Point(3, 4));

        listaPuntos.add(new Point(4, 0));
        listaPuntos.add(new Point(4, 1));
        listaPuntos.add(new Point(4, 2));
        listaPuntos.add(new Point(4, 3));
        listaPuntos.add(new Point(4, 4));

        return listaPuntos;
    }

    private static ArrayList<Point> cruz() {
        ArrayList<Point> listaPuntos = new ArrayList<>();

        listaPuntos.add(new Point(0, 2));

        listaPuntos.add(new Point(1, 2));

        listaPuntos.add(new Point(2, 0));
        listaPuntos.add(new Point(2, 1));
        listaPuntos.add(new Point(2, 2));
        listaPuntos.add(new Point(2, 3));
        listaPuntos.add(new Point(2, 4));

        listaPuntos.add(new Point(3, 2));

        listaPuntos.add(new Point(4, 2));

        return listaPuntos;
    }

    private static ArrayList<Point> cartonX() {
        ArrayList<Point> listaPuntos = new ArrayList<>();

        listaPuntos.add(new Point(0, 0));
        listaPuntos.add(new Point(0, 4));

        listaPuntos.add(new Point(1, 1));     
        listaPuntos.add(new Point(1, 3));  

        listaPuntos.add(new Point(2, 2));
        
   
        listaPuntos.add(new Point(3, 1));   
        listaPuntos.add(new Point(3, 3));

        listaPuntos.add(new Point(4, 0));
        listaPuntos.add(new Point(4, 4));

        return listaPuntos;
    }
    
      private static ArrayList<Point> cartonY(){
        ArrayList<Point> listaPuntos = new ArrayList<>();
        
        listaPuntos.add(new Point (0, 0));
        listaPuntos.add(new Point (0, 4));        
    
        listaPuntos.add(new Point (1, 1));
        listaPuntos.add(new Point (1, 3));
        
        listaPuntos.add(new Point (2, 2));
        
        listaPuntos.add(new Point (3, 2));
        
        listaPuntos.add(new Point (4, 2));
       
        return listaPuntos;
    }

    public ArrayList<Point> getCasillas() {
        return casillas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }
    

}
