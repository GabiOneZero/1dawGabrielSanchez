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
        BingoAmericano bingo;
        String idJugador;
        
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
                    System.out.println("Introduzca un identificador guardado");
                    break;
                default:
                    salir = true;
            }
        } while (!salir);
    }
    
}
