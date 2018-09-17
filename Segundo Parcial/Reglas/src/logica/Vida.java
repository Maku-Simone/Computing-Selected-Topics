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
       
            public Vida() 
                {
                
                }
            public int[] binario(int r)
                {
                    int[] b = new int[8];
                    String bin = Integer.toBinaryString(r);
                    while(bin.length() < 8)
                        {
                            bin = "0" + bin;
                        }
                    
                    
                  //  System.out.println("s" + bin);
                    for(int i = 0; i < 8; i++)
                        {
                            b[i] = Character.getNumericValue(bin.charAt(i));
                        }
                    return b;
                }

                public int[] existe (int[] m, int regla, int tam)
                        {
                                int[] aux = new int[tam], sust = new int[8]; //aqui va el sustituidor
                                String cadenita;
                                int[] bin = binario(regla);
                                for(int i = 0; i < tam; i++)
                                    {
                                        if(i == 0)
                                            {
                                                cadenita = Integer.toString(m[tam - 1]);
                                                cadenita += Integer.toString(m[i]) + Integer.toString(m[i + 1]);
                                            }
                                        else
                                            {
                                                    if(i == (tam - 1))
                                                        {
                                                            cadenita = m[i - 1] + "" + m[i] + "" + m[0] + "";
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
        }//clase

    
