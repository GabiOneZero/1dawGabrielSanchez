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
public final class BingoAmericano extends Bingo {

    private CartonAmericano carton;
    public BomboAmericano bombo;

    public BingoAmericano(CartonAmericano carton, BomboAmericano bombo, LocalDate fecha, String idJugador) {
        super(fecha, idJugador);
        this.carton = carton;
        this.bombo = bombo;

    }

    public CartonAmericano getCarton() {
        return carton;
    }

    public void setCarton(CartonAmericano carton) {
        this.carton = carton;
    }

    public BomboAmericano getBombo() {
        return bombo;
    }

    public void setBombo(BomboAmericano bombo) {
        this.bombo = bombo;
    }

}
