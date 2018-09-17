/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Maku
 */        
import java.io.*;
import java.util.*;
public class Vida 
    {
       
            public Vida()   {         }
            
            public int[] binario(int r, int tam)  //entero a binario
                {
                    int[] b = new int[tam];
                    String bin = Integer.toBinaryString(r);
                    while(bin.length() < tam)
                        {
                            bin = "0" + bin;
                        }
                    
                    
                  //  System.out.println("s" + bin);
                    for(int i = 0; i < tam; i++)
                        {
                            b[i] = Character.getNumericValue(bin.charAt(i));
                        }
                    return b;
                }

                
    public int[] existe (int[] an,  int tam, int[] regla)
                    {
                            int vec, k = 0;                             
                            int[][] m  = new int[tam][tam];
                            int[][] aux = new int[tam][tam];
                        	
                            for(int i = 0; i < tam; i++)
                                {
                                    for(int  j = 0; j < tam; j++)
                                        {                                            
                                            m[i][j] = an[k]; //pasar el anillo a matriz
                                            k++;
                                        }
                                }
                                                                                    
                            for(int i = 0; i < tam; i++) //analizar vida
                                    {
                                        for(int j = 0; j < tam; j++)
                                               {
                                                   vec = 0;
                                                       if(i == 0 &&  j  >=  0)
                                                        {
                                                            if(i == 0 && j == 0)
                                                                {                                                                    
                                                                    vec += m[tam-1][tam-1] + m[tam-1][j] + m[tam-1][j+1]; //las de arriba
                                                                    vec += m[i][tam-1]		   + m[i][j+1]; //las de al lado
                                                                    vec += m[i+1][tam-1] + m[i+1][j] + m[i+1][j+1]; //las de abajo   
                                                                }
                                                            else
                                                                {
                                                                    if(i == 0 && j == (tam-1))
                                                                        {
                                                                            vec += m[tam-1][j-1] + m[tam-1][j] + m[tam-1][0]; //las de arriba
                                                                            vec +=  m[i][j-1]   	                 + m[i][0]; //las de al lado
                                                                            vec += m[i+1][j-1] + m[i+1][j] +              m[i+1][0]; //las de abajo   
                                                                        }
                                                                    else
                                                                        {                                                                            
                                                                            vec += m[tam-1][j-1] + m[tam-1][j] + m[tam-1][j+1]; //las de arriba
                                                                            vec += m[i][j-1]          	       + m[i][j+1]; //las de al lado
                                                                            vec += m[i+1][j-1] + m[i+1][j] + m[i+1][j+1]; //las de abajo   
                                                                        }
                                                                }
                                                        }
                                                      else
                                                       { 
                                                                if(i == tam-1 && j >= 0 )   //esquians inferiores a toroide
                                                                   {
                                                                       if(i == tam-1 && j == 0)
                                                                           {
                                                                               vec += m[i-1][tam-1] + m[i-1][j] + m[i-1][j+1]; //las de arriba
                                                                               vec += m[i][tam-1]   			   + m[i][j+1]; //las de al lado
                                                                               vec += m[0][tam-1] + m[0][j] + m[0][j+1]; //las de abajo   
                                                                           }
                                                                       else
                                                                           {
                                                                               if(i == j && j == tam -1)
                                                                                   {
                                                                                       vec += m[i-1][j-1] + m[i-1][j] + m[i-1][0]; //las de arriba
                                                                                       vec += m[i][j-1]   			   + m[i][0]; //las de al lado
                                                                                       vec += m[0][j-1] + m[0][j] + m[0][0]; //las de abajo   
                                                                                   }
                                                                               else
                                                                                   {
                                                                                       vec += m[i-1][j-1] + m[i-1][j] + m[i-1][j+1]; //las de arriba
                                                                                       vec += m[i][j-1]   			   + m[i][j+1]; //las de al lado
                                                                                       vec += m[0][j-1] + m[0][j] + m[0][j+1]; //las de abajo   
                                                                                   }
                                                                           }
                                                                   }
                                                                 else
                                                                           {
                                                                               if(j == 0)
                                                                                {
                                                                                    vec += m[i-1][tam-1] + m[i-1][j] + m[i-1][j+1]; //las de arriba
                                                                                    vec += m[i][tam-1]   		                  + m[i][j+1]; //las de al lado
                                                                                    vec += m[i+1][tam-1] + m[i+1][j] + m[i+1][j+1]; //las de abajo                                                                                   
                                                                                }
                                                                               else
                                                                                {
                                                                                    if(j == tam - 1)
                                                                                        {
                                                                                            vec += m[i-1][j-1] + m[i-1][j] + m[i-1][0]; //las de arriba
                                                                                            vec += m[i][j-1]   		                  + m[i][0]; //las de al lado
                                                                                            vec += m[i+1][j-1] + m[i+1][j] + m[i+1][0]; //las de abajo                                                                                                                                                                                   
                                                                                        }
                                                                                    else
                                                                                        {
                                                                                            vec += m[i-1][j-1] + m[i-1][j] + m[i-1][j+1]; //las de arriba
                                                                                            vec += m[i][j-1]   		                  + m[i][j+1]; //las de al lado
                                                                                            vec += m[i+1][j-1] + m[i+1][j] + m[i+1][j+1]; //las de abajo   
                                                                                        }
                                                                                }                                                                               
                                                                             //  System.out.println("i = "+i+"  j = " + j );
                                                                           }
                                                       }
                                                        
                                                                                                               
                                                            if(m[i][j] == 1) //[fila][columna]  Si está viva entonces:
                                                                    {
                                                                            if(vec >= regla[0] && vec <= regla[1]) //
                                                                                {
                                                                                     aux[i][j] = 1;
                                                                                }
                                                                            else 
                                                                                {
                                                                                      aux[i][j] = 0;
                                                                                }
                                                                    }
                                                              else //si está muerta
                                                                    {                                                                                                        
                                                                            if(vec >= regla[2] && vec <= regla[3])
                                                                                {
                                                                                      aux[i][j] = 1;
                                                                                }
                                                                            else
                                                                                {
                                                                                       aux[i][j] = 0;
                                                                                }
                                                                    } //else muerta
                                                        }//for columa
                                    } //for fila analizar vida
                            k = 0;
                             for(int i = 0; i < tam; i++)
                                {
                                    for(int  j = 0; j < tam; j++)
                                        {
                                            an[k] = aux[i][j]; //pasar el anillo a matriz
                                            k++;
                                        }
                                }
                          return an;   
    }//main
                
                public int decimal(int[] m)
                    {
                        String bin = "";
                        int dec;
                        for(int i = 0; i < m.length; i++)
                            {
                                bin += Integer.toString(m[i]);
                            }
                           dec = Integer.parseInt(bin, 2);                //convierto binario a decimal      
                        return dec;
                    }
        }//clase

    
