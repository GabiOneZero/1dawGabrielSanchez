/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevobingo;

import java.time.LocalDate;

/**
 *
 * @author Gabriel
 */
public abstract class Bingo {
 //=========================ATRIBUTOS=====================================
    private String id;
    private LocalDate fecha;
    private String idJugador; 
    
 //========================CONSTRUCTOR====================================
    public Bingo(){
        
    }
    
    public Bingo(LocalDate fecha, String idJugador) {
        this.fecha = fecha;
        this.idJugador = idJugador;
    }

 //======================GETTERS & SETTERS================================
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(String idJugador) {
        this.idJugador = idJugador;
    }
 //=========================TOSTRING()==================================

    @Override
    public String toString() {
        return "Bingo{" + "id=" + id + ", fecha=" + fecha + ", idJugador=" + idJugador + '}';
    }
    
    
}
