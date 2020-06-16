/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevobingo;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Gabriel
 */
public class JuegoBingo {

    public static void main(String[] args) {

//        CartonAmericano cartonPrueba1 = new CartonAmericano();
//        
//        BomboAmericano bomboPrueba1 = new BomboAmericano();
//        
//        System.out.println(bomboPrueba1);
//        System.out.println(cartonPrueba1);
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        Boolean validInput = true;
        Boolean salir = false;
        BingoAmericano bingo = null;
        String idJugador;
        int bolaSacada;
        int turno = 1;
        char guardar;

        do {
            do {
                System.out.println("=========BINGO AMERICANO==========");
                System.out.println("      1.- Nueva Partida");
                System.out.println("      2.- Cargar Partida");
                System.out.println("      3.- Salir");
                System.out.println("==================================");
                try {
                    opcion = teclado.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, introduzca un número válido");
                    teclado.next();
                    validInput = false;
                }

            } while (opcion > 3 || opcion < 1 || !validInput);

            switch (opcion) {

                case 1:
                    System.out.println("Introduzca un identificador único:");
                    idJugador = teclado.nextLine();
                    bingo = new BingoAmericano(new CartonAmericano(), new BomboAmericano(), LocalDate.now(), idJugador);
                    break;
                case 2:
                    // cargarPartida();
                    System.out.println("Introduzca un identificador guardado:");
                    // mostrarIdGuardados();
                    idJugador = teclado.nextLine();
                    bingo = null;
                    break;
                default:
                    salir = true;
            }

            do {

                //SACAR BOLA
                System.out.println("**************************TURNO " + turno + "********************************");
                bolaSacada = bingo.getBombo().sacarBola();
                System.out.println("Ha salido el número: " + bolaSacada);

                //TACHAR CASILLA
                if (bingo.getCarton().tacharNumero(bolaSacada) != null) {
                    System.out.println("Se ha tachado el número " + bolaSacada);

                    //COMPROBAR BINGO          
                    if (bingo.getCarton().esBingo()) {
                        System.out.println("BINGO!!!!!!!!!!!");
                        System.out.println("ENHORABUENA!!!!!");
                        break;
                    }
                } else {
                    System.out.println("No hubo suerte con esta bola");
                }

                //ENSEÑAR CARTÓN MARCADO
                System.out.println(bingo.getCarton());

                //AVANZAR TURNO Y REPETIR
                turno++;
                System.out.println("******************************************************************");

                System.out.println("Presiona G si quieres guardar la partida");
                if (teclado.nextLine().equalsIgnoreCase("g")) {

                    //guardarPartida();
                }

            } while (!bingo.getCarton().esBingo());

        } while (!salir);
    }

}
