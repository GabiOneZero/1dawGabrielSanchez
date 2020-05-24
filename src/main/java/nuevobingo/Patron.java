/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevobingo;

import java.awt.Point;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public enum Patron {
    
    CARTON_LLENO(),
    FORMA_X(),
    FORMA_Y();
    
    private List<Point> casillas;
    private String descripcion;
    
    Patron(){
        
    }
    
    Patron(List<Point>casillas, String descripcion){
        this.casillas = casillas;
        this.descripcion = descripcion;
    }

    public List<Point> getCasillas() {
        return casillas;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    
}
