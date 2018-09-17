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
        public int[][] creaVida(int tam)
            {                
               int[][] inicio = new int[tam + 2][tam + 2];
               Random r = new Random();
               for(int i = 1; i <= tam; i++)
               {
                   for(int j = 1; j <= tam; j++)
                    {
                        inicio[i][j] = r.nextInt(3);                        
                    }
               }
               return inicio;
            }
          public int[][] destruyeVida(int tam)
            {               
               int[][] fin = new int[tam + 2][tam + 2];
               for(int i = 1; i <= tam; i++)
               {
                   for(int j = 1; j <= tam; j++)
                    {
                        fin[i][j] = 0;
                    }
               }
               return fin;
            }
       
    }
