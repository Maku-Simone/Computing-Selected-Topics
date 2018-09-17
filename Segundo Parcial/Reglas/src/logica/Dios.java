/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Random;

/**
 *
 * @author Maku
 */
public class Dios 
    {
        public Dios(){}
        public int[] creaVida(int tam)
            {                
               int[] inicio = new int[tam];
               Random r = new Random();
               for(int i = 0; i < tam; i++)
               {
                        inicio[i] = r.nextInt(2);                        
               }
               return inicio;
            }
          public int[] destruyeVida(int tam)
            {               
               int[] fin = new int[tam];
               for(int i = 0; i < tam; i++)
               {
                        fin[i] = 0;
               }
               return fin;
            }
       
    }
