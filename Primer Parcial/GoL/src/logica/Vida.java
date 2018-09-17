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

            public int[][] existe (int[][] m, int[] regla, int tam)
                    {
                            int fila, colum, vec;
                            fila = tam;
                            colum = fila;                                
                            //Random vida = new Random();
                            //Integer[][] m = new Integer[fila+2][colum+2];
                            int[][] aux    = new int[fila+2][colum+2];
                	
                            for(int i = 1; i <= fila; i++) //analizar vida
                                    {
                            for(int j = 1; j <= colum; j++)
                                   {
                                            vec = 0;
                                            vec += m[i-1][j-1] + m[i-1][j] + m[i-1][j+1]; //las de arriba
                                            vec += m[i][j-1]   			   + m[i][j+1]; //las de al lado
                                            vec += m[i+1][j-1] + m[i+1][j] + m[i+1][j+1]; //las de abajo   
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
       return aux;                 
    }//main
}//clase


