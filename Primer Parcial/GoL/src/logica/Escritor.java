/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
        public int escribe(int[][] m)
            {
                try
                    {
                            PrintWriter writer = new PrintWriter("1.txt", "UTF-8");                                        
                            for(int i = 0; i < m.length; i++)
                                {
                                    for(int j = 0; j < m.length; j++)
                                        {
                                            writer.print(m[i][j]);
                                        }
                                    writer.println("");
                                } 
                     writer.close();
                     return 1;
                    } 
                catch (IOException e) 
                        {
                          return 0;
                        }
            }
        public int[][] lee(File f) throws FileNotFoundException, IOException
            {
                int[][] x;
                int i = 0, j = 0, tam = 0;
                String c = "", d;
                if(f!=null)
                    {     
                       FileReader archivos=new FileReader(f);
                       BufferedReader lee=new BufferedReader(archivos);
                       //c+= lee.readLine();
                       while((d = lee.readLine()) !=null)
                        {                                                                                     
                                tam++;    
                                c += d;
                                //System.out.println("c es "+c);                                  
                        }
                          lee.close(); 
                          x = new int[tam][tam];
                                                                  
                    for(int k = 0; k < c.length(); k++)
                        {   
                            String car = "";
                            car += c.charAt(k);   
                            System.out.print("["+car+"]");                         
                           if(j == tam )
                            {
                                System.out.println("");                         
                                i++; 
                                j = 0;
                                k--;
                            }
                           else
                            {
                                x[i][j] = Integer.parseInt(car);
                                j++;
                            }
                        }//while2
                          
                           return x;
                     }    //if
                else
                    {
                        x = new int[10][10];
                        for(i = 0; i < 10; i++)
                            {
                                for(j = 0; j < 10; j++)
                                    {
                                        x[i][j] = 0;
                                    }
                            }
                        return x;
                    }
               
            }//funcion lee
    }
