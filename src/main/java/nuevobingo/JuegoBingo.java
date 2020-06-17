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

//      ATRIBUTOS QUE NECESITAREMOS
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        Boolean validInput = true;
        Boolean salir = false;
        BingoAmericano bingo = null;
        int bolaSacada;
        int turno = 1;

        //MENÚ PRINCIPAL
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
                    bingo = nuevaPartida();
                    break;
                case 2:
                    bingo = cargarPartida();
                    break;
                default:
                    salir = true;
            }

            if (bingo != null) {

                //TURNO
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

    //MÉTODOS ESTÁTICOS
    /**
     * Crea un nuevo Bingo a partir de un nombre introducido
     * @return devuelve el BingoAmericano que se crea
     */
    public static BingoAmericano nuevaPartida() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca su nombre:");
        String idJugador = teclado.nextLine();
        BingoAmericano bingo = new BingoAmericano(new CartonAmericano(), new BomboAmericano(), LocalDate.now(), idJugador);
        System.out.println("Hola, " + idJugador);
        System.out.println("Jugaremos con el patrón : " + bingo.getCarton().getPatron().getNombre());
        System.out.println("Este es su cartón");
        bingo.getCarton().mostrarCarton();

        return bingo;
    }

    /**
     * Carga una bingo guardado en la base de datos mediante un código introducido por teclado
     * @return el bingo seleccionado, devuelve null si no hay ninguno
     */
    public static BingoAmericano cargarPartida() {
        Scanner teclado = new Scanner(System.in);
        BingoDAO bDAO = new BingoDAO();
        String id;

        do {
            System.out.println("Introduzca un codigo de guardado válido o pulse 0 para salir:");
            id = teclado.nextLine();
            if (id.equals("0")) {
                break;
            }
        } while (Metodos.buscarPartida(Integer.valueOf(id)) == null);

        BingoAmericano bingo = Metodos.buscarPartida(Integer.valueOf(id));
        bingo.getCarton().mostrarCarton();

        bDAO.deleteBingo(Integer.valueOf(id));

        return bingo;
    }

}
