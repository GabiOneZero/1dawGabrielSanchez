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
        
        Bombo bombo = new Bombo();
        Carton carton = new Carton();
        
        int bolaSacada;
        
        System.out.println("Este es su cartón:");
       
        carton.imprimirCarton();
        
        do{
            bolaSacada = bombo.sacarBola();
            System.out.println("Ha salido el número: " + bolaSacada);
            System.out.println("-------------");            
            
            if(carton.tacharCasilla(bolaSacada)){
                System.out.println("Se ha tachado el número " + bolaSacada);
                
               if(carton.comprobarSiLinea(0)){
                   System.out.println("LINEA - en la línea: " + 1);
                   
                   if(carton.comprobarSiBingo()){
                       System.out.println("BINGO!!!!!!!!!!!");
                       System.out.println("ENHORABUENA!!!!!");
                       break;
                   }
               }
               if(carton.comprobarSiLinea(1)){
                   System.out.println("LINEA - en la línea: " + 2);
                    if(carton.comprobarSiBingo()){
                       System.out.println("BINGO!!!!!!!!!!!");
                       System.out.println("ENHORABUENA!!!!!");
                       break;
                   }
               }
               if(carton.comprobarSiLinea(2)){
                   System.out.println("LINEA - en la línea: " + 3);
                    if(carton.comprobarSiBingo()){
                       System.out.println("BINGO!!!!!!!!!!!");
                       System.out.println("ENHORABUENA!!!!!");
                       break;
                   }
               }
            }else{
                System.out.println("No hubo suerte con esta bola");
            }
            
            carton.imprimirCarton();
            
        }while(!carton.comprobarSiBingo());
    }
    
}
