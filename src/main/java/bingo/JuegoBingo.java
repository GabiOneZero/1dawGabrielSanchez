/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

/**
 *
 * @author Gabriel
 */
public class JuegoBingo {

    public static void main(String[] args) {
        //Creamos el bombo y el cartón
        Bombo bombo = new Bombo();
        Carton carton = new Carton();

        //Variable que necesitaremos
        int bolaSacada;
        int turno = 1;
        
        //Comenzamos enseñando el cartón
        System.out.println("Este es su cartón:");
        carton.imprimirCarton();

        //Introducimos todos los sucesos de un turno dentro de un bucle DO-WHILE, que se repetirá hasta que se cante BINGO
        do {
            
            //SACAR BOLA
            System.out.println("**************************TURNO " + turno + "********************************");
            bolaSacada = bombo.sacarBola();
            System.out.println("Ha salido el número: " + bolaSacada);

            //TACHAR CASILLA
            if (carton.tacharCasilla(bolaSacada)) {
                System.out.println("Se ha tachado el número " + bolaSacada);

                //COMPROBAR LINEAS O BINGO
                if (carton.comprobarSiLinea(0)) {
                    System.out.println("LINEA - en la línea: " + 1);

                }
                if (carton.comprobarSiLinea(1)) {
                    System.out.println("LINEA - en la línea: " + 2);

                }
                if (carton.comprobarSiLinea(2)) {
                    System.out.println("LINEA - en la línea: " + 3);

                }

                if (carton.comprobarSiBingo()) {
                    System.out.println("BINGO!!!!!!!!!!!");
                    System.out.println("ENHORABUENA!!!!!");
                    break;
                }
            } else {
                System.out.println("No hubo suerte con esta bola");
            }

            //ENSEÑAR CARTÓN MARCADO
            carton.imprimirCarton();

            //AVANZAR TURNO Y REPETIR
            turno++;
            System.out.println("******************************************************************");
        } while (!carton.comprobarSiBingo());

    }

}
