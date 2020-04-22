/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Gabriel
 */
public class Carton {

    private int[][] numerosCarton;

    //Como los cartones serán siempre iguales en tamaño usaremos solo un Constructor sin parámetros
    //estableciendo el tamaño (3 x 9) y rellenando la matriz haciendo uso de otro método (generarCarton())
    public Carton() {
        this.numerosCarton = new int[3][9];
        generarCarton();
    }

    //Método principal de la clase
    //1ºGenera los números, luego establece los huecos correspondientes 
    //y por último comprueba que todo es correcto, si no es así se vuelve a repetir
    //el proceso hasta que se genera un cartón que tenga todas las caracteristicas
    //que debe.
    private void generarCarton() {

        do {
            generarNumeros();
            generarHuecos();

        } while (!comprobarCarton());

    }

    //1º GENERAR NÚMEROS
    //En este método se generarán los números aleatoriamente para el cartón en cuestión, 
    //siguiendo las directrices establecidas en cuanto a la colocación de los números
    //Es un método "private" ya que solo querremos tener acceso a él desde la propia clase
    //para usarlo en el constructor
    private void generarNumeros() {
        Random varRandom = new Random();

        int nuevoNumero;  //El número que generaremos y colocaremos en cada posición del cartón
        int[] filaAnterior = {0, 0, 0, 0, 0, 0, 0, 0, 0}; //Array que contendrá los números de la fila anterior para comprobaciones
        for (int i = 0; i < this.numerosCarton.length; i++) { //Recorremos las 3 FILAS

            for (int j = 0; j < this.numerosCarton[i].length; j++) { //Recorremos las 9 COLUMNAS

                //Dependiendo de en qué columna nos encontremos establecemos los número de una forma u otra
                switch (j) {

                    case 0: //1ª Columna
                        //Comprobamos que no haya salido ya el máximo número permitido para la columna actual (9)
                        //Si ya ha salido el máximo número posible para la columna establecemos un hueco (0)
                        if (filaAnterior[j] == 9) {
                            this.numerosCarton[i][j] = 0;
                            break;
                        }
                        //Establecemos un número aleatoriamente en el rango permitido para la columna (entre 1 y 9)
                        //y controlando que sea mayor que el número superior
                        do {
                            nuevoNumero = varRandom.nextInt(9) + 1;
                        } while (nuevoNumero <= filaAnterior[j]);
                        filaAnterior[j] = nuevoNumero; //Actualizamos los número de la fila anterior
                        this.numerosCarton[i][j] = nuevoNumero; //Puesto que es correcto, establecemos el número en la posición del cartón correspondiente
                        break;

                    case 8: //9ª columna
                        //Comprobamos que no haya salido ya el máximo número permitido para la columna actual (90)
                        //Si ya ha salido el máximo número posible para la columna establecemos un hueco (0)
                        if (filaAnterior[j] == 90) {
                            this.numerosCarton[i][j] = 0;
                            break;
                        }
                        //Establecemos un número aleatoriamente en el rango permitido para la columna (80 y el 90)
                        //y controlando que sea mayor que el número superior
                        do {
                            nuevoNumero = varRandom.nextInt(11) + 80;
                            if (nuevoNumero == 90) {
                                break;
                            }
                        } while (nuevoNumero <= filaAnterior[j]);
                        filaAnterior[j] = nuevoNumero; //Actualizamos los número de la fila anterior
                        this.numerosCarton[i][j] = nuevoNumero; //Puesto que es correcto establecemos el número en la posición del cartón correspondiente
                        break;

                    default: //El resto de columnas (2ª a 8ª)
                        //Comprobamos que no haya salido ya el máximo número permitido para la columna actual(19, 29, 39, 49, 59, 69 ó 79)
                        //Si ya ha salido el máximo número posible para la columna establecemos que hay un hueco (0)
                        if (filaAnterior[j] == ((j * 10) + 9)) {
                            this.numerosCarton[i][j] = 0;
                            break;
                        }
                        //Establecemos un número aleatoriamente en el rango permitido para la columna, la decena correspondiente dependiendo de la columna actual)
                        //y controlando que sea mayor que el número superior
                        do {
                            nuevoNumero = varRandom.nextInt(10) + (j * 10);
                        } while (nuevoNumero <= filaAnterior[j]);
                        filaAnterior[j] = nuevoNumero; //Actualizamos los número de la fila anterior
                        this.numerosCarton[i][j] = nuevoNumero; //Puesto que es correcto establecemos el número en la posición del cartón correspondiente
                        break;
                }

            }
        }
    }

    //Método que añade los huecos restantes que corresponden 
    //(4 huecos por cada fila en orden aleatorio, teniendo en cuenta los huecos
    //que ya hayan podido generarse al colocar los números)
    private void generarHuecos() {
        Random varRandom = new Random();

        //Creamos una lista con las posiciones que tendrán los huecos para una fila en cuestión
        ArrayList<Integer> posicionesDeLosHuecos = new ArrayList<>();

        for (int i = 0; i < this.numerosCarton.length; i++) { //Recorremos las 3 FILAS

            posicionesDeLosHuecos.removeAll(posicionesDeLosHuecos); //Aseguramos que ña lsita de posiciones esté vacío antes de comenzar a revisar cada fila
            do {
                //Rellenamos la lista con valores aleatorios correspondientes a las posiciones posibles de la fila
                int huecoRandom = varRandom.nextInt(9);
                if (!posicionesDeLosHuecos.contains(huecoRandom)) {//Si el número ya existe en la lista, lo descartamos
                    posicionesDeLosHuecos.add(huecoRandom);
                }
            } while (posicionesDeLosHuecos.size() < 4);//Seguimos sacando numeros aleatorios para la lista hasta tener 4 posiciones
            int huecos = contarHuecos(i); //Establecemos eñl contador de huecos y contamos el número de huecos que ya existian anteriormente para esta línea, para tenerlos en cuenta para el total de 4 huecos por línea

            //Ahora que ya tenemos las 4 posiciones aleatorias para ESTA FILA, recorremos las 9 posiciones
            for (int j = 0; j < this.numerosCarton[0].length; j++) {

                //Si en la posición actual no hay ya un hueco (0) y coincide la posición con una de la lista,
                //establecemos un hueco (0)
                //y sumamos 1 al contador de huecos por linea
                if (this.numerosCarton[i][j] != 0 && posicionesDeLosHuecos.contains(j)) {
                    this.numerosCarton[i][j] = 0;
                    huecos++;
                }
                //En caso de que ya hayamos alcanzado los 4 huecos en esta línea
                //salimos de inmediato del bucle
                if (huecos >= 4) {
                    break;
                }

            }

        }
    }

    //Cuenta los huecos que hay en una línea
    //@param - fila en la que nos encontramos actualmente
    //@return - número de huecos que existen en la línea actual
    private int contarHuecos(int fila) {
        int huecos = 0;

        //Con un bucle contamos los 0 para saber cuántos huecos hay
        for (int i = 0; i < this.numerosCarton[0].length; i++) {
            if (this.numerosCarton[fila][i] == 0) {
                huecos++;
            }
        }
        return huecos;
    }

    //Comprueba que todos los huecos estén colocados debidamente, es decir,
    //que además de que haya 4 huecos por línea, no quede ninguna columna vacía
    // o ninguna columna con tres números
    //@return - si el cartón es correcto o no
    private boolean comprobarCarton() {
        int huecosPorFila;
        int huecosPorColumna;

        
        //Comprobamos primero todo el cartón por filas
        for (int i = 0; i < this.numerosCarton.length; i++) {
            
            huecosPorFila = 0;//resetamos el contador para cada fila
            for (int j = 0; j < this.numerosCarton[0].length; j++) {
                //Añadimos uno al contador por cada  hueco
                if (this.numerosCarton[i][j] == 0) {
                    huecosPorFila++;
                }

            }
            //Si resulta que no hay 4 huecos por cada linea devolvemos false y
            //el cartón no se da por válido
            if (huecosPorFila != 4) {
                return false;
            }
        }

        //Comprobamos todo el cartón por columnas
        for (int i = 0; i < this.numerosCarton[0].length; i++) {
            
            huecosPorColumna = 0; //reseteamos el contador en cada columna
            for (int j = 0; j < this.numerosCarton.length; j++) {

                //En caso de haber un hueco (0) sumamos 1 al contador
                if (this.numerosCarton[j][i] == 0) {
                    huecosPorColumna++;
                }

            }
            //En caso de que en la columna no haya huecos o haya más de 2
            //se dará por mal el cartón y por tanto devolveremos false
            if (huecosPorColumna != 1 && huecosPorColumna != 2) {
                return false;
            }

        }
        //Si ha llegado hasta aquí la ejecución es que todos los huecos son correctos
        //por tanto daremos por válido el cartón y devolvemos true
        return true;
    }
    
    //Este método tacha (convierte en -1) en el cartón los números de las bolas que salgan
    //@param - número dado, correspondiente a la bola sacada
    public void tacharCasilla(int bola){
        //Recorremos el cartón para buscar el número
        for (int i = 0; i < this.numerosCarton.length; i++) {
            for (int j = 0; j < this.numerosCarton[i].length; j++) {
                
                if(this.numerosCarton[i][j] == bola){
                    this.numerosCarton[i][j] = -1;
                }
            }
        }
    }
    
    
    //Se comprueba si existe línea
    //@params - la línea que queremos comprobar
    //@return - si existe línea o no
    public boolean comprobarSiLinea(int linea){
        //Recorremos toda la línea y vamos comrpobando que todos los espacios esté ocupados 
        //por un -1 (osea que estén "tachados")
        for (int i = 0; i < this.numerosCarton[0].length; i++) {
            if(this.numerosCarton[linea][i] != -1){
                return false;
            }
        }
        return true;
    }
    
    //Comprobamos si hay bingo o no
    public boolean comprobarSiBingo(){
        //En caso de que en las 3 líneas se hayan cantado línea, querrá decir que hay bingo
        //por tanto devolverá true
       return comprobarSiLinea(0) && comprobarSiLinea(1) &&  comprobarSiLinea(2);
    }
    
//Imrpimimos los números guardados en el cartón
//y le damos formato

    public void imprimirCarton() {

        //Doble bucle for-each para recorrer la matriz
        for (int[] aux : this.numerosCarton) {
            for (int i : aux) {
                //Dependiendo del valor actual imprimiremos una cosa u otra
                switch (i) {

                    case 0: //Equivale a un hueco, por tanto imprimimos un espacio en blanco
                        System.out.print(" \t");
                        break;
                    case -1: //Quiere decir que es un número que ha salido en el bombo y ha sido marcado, entonces lo representamos con una X
                        System.out.print("X\t");
                        break;
                    default: //Por defecto se imprimirá en consola el número correspondiente
                        System.out.print(i + "\t");
                        break;
                }
            }
            System.out.println(""); //Salto después de cda lína para dar formato
        }

    }

}
