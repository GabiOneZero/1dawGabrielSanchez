/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedatos;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 * @version 1.0
 * @since 16 jun. 2020
 */
public class BingoVO {

    private int pk;
    private LocalDate fecha;
    private String idJugador;
    private int tipo;
    private ArrayList<Integer> bombo;
    private ArrayList<Integer> carton;

    public BingoVO(int pk, LocalDate fecha, String idJugador, int tipo, ArrayList<Integer> bombo, ArrayList<Integer> carton) {
        this.pk = pk;
        this.fecha = fecha;
        this.idJugador = idJugador;
        this.tipo = tipo;
        this.bombo = bombo;
        this.carton = carton;
    }

    public BingoVO() {

    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
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

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Integer> getBombo() {
        return bombo;
    }

    public void setBombo(ArrayList<Integer> bombo) {
        this.bombo = bombo;
    }

    public ArrayList<Integer> getCarton() {
        return carton;
    }

    public void setCarton(ArrayList<Integer> carton) {
        this.carton = carton;
    }

    @Override
    public String toString() {
        return "BingoVO{" + "pk=" + pk + ", fecha=" + fecha + ", idJugador=" + idJugador + ", tipo=" + tipo + ", bombo=" + bombo + ", carton=" + carton + '}';
    }
    
    
}