/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevobingo;

import basedatos.BingoDAO;
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
        String id;
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
                    teclado.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, introduzca un número válido");
                    teclado.next();
                    validInput = false;
                }

            } while (opcion > 3 && opcion < 1 || !validInput);

            switch (opcion) {

                case 1:
                    System.out.println("Introduzca su nombre:");
                    idJugador = teclado.nextLine();
                    bingo = new BingoAmericano(new CartonAmericano(), new BomboAmericano(), LocalDate.now(), idJugador);
                    System.out.println("Hola, " + idJugador);
                    System.out.println("Jugaremos con el patrón : " + bingo.getCarton().getPatron().getNombre());
                    System.out.println("Este es su cartón");
                    bingo.getCarton().mostrarCarton();
                    break;
                case 2:
                    do {
                        System.out.println("Introduzca un codigo de guardado válido o pulse 0 para salir:");
                        id = teclado.nextLine();
                        if (id.equals("0")) {
                            break;
                        }
                    } while (Metodos.cargarPartida(Integer.valueOf(id)) == null);
                    bingo = Metodos.cargarPartida(Integer.valueOf(id));
                    bingo.getCarton().mostrarCarton();
                    BingoDAO bDAO = new BingoDAO();
                    bDAO.deleteBingo(Integer.valueOf(id));
                    break;
                default:
                    salir = true;
            }

            if (bingo != null) {

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
                    bingo.getCarton().mostrarCarton();

                    //AVANZAR TURNO Y REPETIR
                    turno++;
                    System.out.println("******************************************************************");

                    System.out.println("Presiona G si quieres guardar la partida o ENTER para continuar");
                    if (teclado.nextLine().equalsIgnoreCase("g")) {

                        System.out.println("Su código de guardado es: " + Metodos.guardarPartida(bingo));
                        break;
                    }

                } while (!bingo.getCarton().esBingo());
            }

        } while (!salir);
    }

}
