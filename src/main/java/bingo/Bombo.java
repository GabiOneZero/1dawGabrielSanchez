/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

import java.util.Random;

/**
 *
 * @author Gabriel
 */
public class Bombo {

    //Atributo
    private int[] bolas;

    //Constructor
    //No necesitamos pasarle parámetros e inicializamos su único atributo y
    //lo rellenamos con "bolas"
    //Ya que todos los bombos que creemos serán iguales y se crearán llenos
    public Bombo() {
        this.bolas = new int[90];
        this.llenarBombo();
    }

    //MÉTODOS 
    //Rellena el array de bolas con un bucle for con números del 1 al 90 que
    //representarán las bolas del bombo
    private void llenarBombo() {
        for (int i = 0; i < this.bolas.length; i++) {
            this.bolas[i] = i + 1;
        }
    }

    //Obtenemos un número aleatorio dentro del rango (1-90)
    //Y la posición correspondiente al número obtenido lo cambiamos por 0
    //simulando que esta bola ya no está en el bombo y devuelve la bola en cuestión
    //@return - la bola que está en la posición seleccionada aleatoriamente
    public int sacarBola() {
        Random varRandom = new Random();
        int bolaSeleccionada;
        int bola;
        do {
            bola = varRandom.nextInt(90) + 1; //Escogemos aleatoriamente una posición
        } while (this.bolas[bola - 1] == 0); //Repetimos en caso de que esa bola ya haya salido anteriormente (su valor sea 0)
        
        bolaSeleccionada = this.bolas[bola - 1];//Metemos en una variable la bola escogida aleatoriamente
        this.bolas[bola - 1] = 0; //Igualamos a 0 representando que la bola ha salido
        return bolaSeleccionada; 
    }

    //Recorremos con un bucle for el array de bolas comprobando en cada iteración
    //si hay número o hay un 0, sabiendo así el número de bolas restantes
    public int saberNumeroBolas() {
        int numeroBolas = 0;

        for (int i = 0; i < this.bolas.length; i++) {
            if (this.bolas[i] != 0) {
                numeroBolas++;
            }
        }
        return numeroBolas;
    }

    //Setter & Getter
    public int[] getBolas() {
        return bolas;
    }

    public void setBolas(int[] bolas) {
        this.bolas = bolas;
    }

    @Override
    public String toString() {
        return "Bombo{" + "bolas=" + bolas + '}';
    }

}
