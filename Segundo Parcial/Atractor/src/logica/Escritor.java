/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Character.getNumericValue;

/**
 *
 * @author Maku
 */
public class Escritor 
    {
       public  Escritor()
            {
        
            }
        public int escribe(int regla, String text)
            {                                                 
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(regla+".txt", true))) 
                        {
                            bw.write(text);
                            bw.close();
                            return 1;
                        }
                    catch (IOException e) 
                        { e.printStackTrace();	return 0;}                   
            }
        public int[] lee(File f) throws FileNotFoundException, IOException
            {
                int[] x;
                int i = 0, j = 0, tam = 0;
                String c = "", d;
                if(f!=null)
                    {     
                       FileReader archivos=new FileReader(f);
                       BufferedReader lee=new BufferedReader(archivos);
                       //c+= lee.readLine();
                       while((d = lee.readLine()) !=null)
                        {                                                                                      
                                c += d;                             
                        }
                       tam = c.length();
                          lee.close(); 
                          x = new int[tam];
                                                                  
                    for(int k = 0; k < c.length(); k++)
                        {   
                            String car = "";
                            car += c.charAt(k);                              
                            x[i] = Integer.parseInt(car);                                                         
                        }//while2
                         
                           return x;
                     }    //if
                else
                    {
                        x = new int[10];
                        for(i = 0; i < 10; i++)
                            {
                                for(j = 0; j < 10; j++)
                                    {
                                        x[i] = 0;
                                    }
                            }
                        return x;
                    }
               
            }//funcion lee
    }
