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
        public int[][] creaVida(int tam, int densidad)
            {                
               int[][] inicio = new int[tam + 2][tam + 2];
              // int dens, contDens, probador = 4;
              // dens = (int) Math.round((tam*tam) * ((double)densidad / 100)); //cuantos debo pintar
            //   contDens = 0;
               Random r = new Random();

                   // contDens = 0;                                                                                
                     for(int i = 1; i <= tam; i++)               
                          {
                              for(int j = 1; j <= tam; j++)
                               {                                                       
                                      inicio[i][j] = r.nextInt(100);      
                                      if(inicio[i][j] <=  densidad)
                                        {
                                            inicio[i][j] = 1;
                                           // contDens++;
                                        }
                                      else
                                      {
                                          inicio[i][j] = 0;
                                      }
                                    
                                          //System.out.println("Debo pintar " + contDens +"/"+dens);      
                               } //for 2
                        
                          
                     //System.out.println("Vale " + contDens);
               
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
