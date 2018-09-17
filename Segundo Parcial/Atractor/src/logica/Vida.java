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

                public int[] existe (int[] m, int regla, int tam) //analizador del automata y sustituidor
                        {
                                int[] aux = new int[tam], sust = new int[8]; //aqui va el sustituidor
                                String cadenita;
                                int[] bin = binario(regla, 8);
                                for(int i = 0; i < tam; i++) //aqui divido el arreglo en pedacitos de 3 para analizarlo
                                    {
                                        if(i == 0) //uno el inicio con el final
                                            {
                                                cadenita = Integer.toString(m[tam - 1]);
                                                cadenita += Integer.toString(m[i]) + Integer.toString(m[i + 1]);
                                            }
                                        else
                                            {
                                                    if(i == (tam - 1))
                                                        {
                                                            cadenita = m[i - 1] + "" + m[i] + "" + m[0] + ""; //uno el final al inicio
                                                        }
                                                    else
                                                        {
                                                            cadenita = m[i - 1] + "" +m[i] + "" +m[i + 1] + "";
                                                        }
                                            }
                                    //    System.out.println(cadenita);
                                        switch(cadenita)
                                            {
                                                case "000":
                                                    aux[i] = bin[7];
                                                break;
                                                case "001":
                                                    aux[i] = bin[6];
                                                break;
                                                case "010":
                                                    aux[i] = bin[5];
                                                break;
                                                case "011":
                                                    aux[i] = bin[4];
                                                break;
                                                case "100":
                                                    aux[i] = bin[3];
                                                break;
                                                case "101":
                                                    aux[i] = bin[2];
                                                break;
                                                case "110":
                                                    aux[i] = bin[1];
                                                break;
                                                case "111":
                                                    aux[i] = bin[0];
                                                break;
                                                       
                                            }//System.out.print(aux[i]); 
                                    
                                    }
                                return aux;
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

    
