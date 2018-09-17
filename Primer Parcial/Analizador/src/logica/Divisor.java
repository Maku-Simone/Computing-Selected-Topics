/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import analizador.biatcora;
import java.util.*;

/**
 *
 * @author Maku
 */
public class Divisor 
    {
            int[][][] saves;
            int[][] saves2, ini;                       
            int sl = 0, gl = 0, ff = 0;
            int[][] mini = new int[3][3];
            int i0 = 1, i, j0 = 1, j, fil = 1, col = 1, tamSecc = 3, x = 0, y = 0, tam, gens; //mm, l es mi contador de secciones
            Vector vFF = new Vector(10, 2);
            Vector vGL = new Vector(10, 2);
            Vector vSL = new Vector(10, 2);
            //tamSecc = 3;
            Analiza an = new Analiza(); 
           public  Divisor(int[][][] saves, int tam, int gens, int[][] in)
            {
                this.saves = saves;
                this.tam = tam;
                this.gens = gens;
                this.ini = in;
                saves2 = new int[saves.length][saves.length];
            }
           public void analisis()
            {
           
                for(int ii = 1; ii <= tam; ii++)
                    {
                            for(int jj = 1; jj <= tam; jj++)
                                    {
                                        saves2[ii][jj] = 0; //inicializo matriz de analisis
                                    }
                    }

            for(int ii = 1; ii <= tam; ii++)
                    {
                            for(int jj = 1; jj <= tam; jj++)
                                    {
                                            for(int kk = 0; kk < gens; kk++)
                                                    {
                                                            saves2[ii][jj] += saves[ii][jj][kk]; //lleno mi matriz de analisis
                                                    }
                                    }
                    }
            for(int li = 1; li <= tam; li++)
                    {
                            for(int lj = 1; lj <= tam; lj++)
                                    {
                                            System.out.print(saves2[li][lj]);
                                    }
                            System.out.print("\n");
                    }			//imprimo matriz de analisis


            while(j0 <= tam)
                    {
                            if(i0 <= tam + 1)
                                    {
                                            for(i = i0; i < (fil*tamSecc+1); i++) //dividiendo la matriz
                                                    {
                                                            if(i > tam)
                                                                            {
                                                                                    break;
                                                                            }
                                                            for(j = j0 ; j < (col*tamSecc+1); j++)
                                                                    {
                                                                            if(j > tam)
                                                                                    {
                                                                                            break;
                                                                                    }
                                                                           // System.out.print(i +","+ j +" "+ saves2[i][j]+" ");
                                                                            mini[x][y] = saves2[i][j];
                                                                            y++;//columnas
                                                                    }
                                                           // System.out.print("|\n");
                                                            y = 0;
                                                            x++;
                                                            if(x > 2)
                                                                    {
                                                                          //  System.out.println("Mini tiene: \n");
                                                                         /*  for(int a = 0; a < 3; a++)
                                                                                    {
                                                                                            for(int b = 0; b < 3; b++)
                                                                                            System.out.print(mini[a][b]);
                                                                                            System.out.print("\n");
                                                                                    }*/
                                                                            if(an.FF(mini) == 1)
                                                                                            {
                                                                                                        ff++;    System.out.println("POSIBLE FLIP FLOP ENCONTRADO en" +i + " ,  " + j0 +" \n");
                                                                                                                vFF.addElement(i);
                                                                                                                vFF.addElement(j0);
                                                                                            }
                                                                            if(an.SL(mini) == 1)
                                                                                            {
                                                                                                          sl++;  System.out.println("POSIBLE STILL LIFE ENCONTRADO \n");
                                                                                                          vSL.addElement(i);
                                                                                                          vSL.addElement(j0);
                                                                                            }
                                                                            if(an.GL(mini) == 1)
                                                                                            {
                                                                                                           gl++; System.out.println("POSIBLE GLIDER ENCONTRADO\n");
                                                                                                           vGL.addElement(i);
                                                                                                           vGL.addElement(j0);
                                                                                            }

                                                                            x = 0;
                                                                    }																																									}
                                                    i0 = fil*tamSecc+1;
                                                    j0 = 1;
                                                    fil++;
                                            //System.out.println("----------------------");
                                    }
                            else
                                    {
                                            i0 = 1;
                                            j0 = col*tamSecc+1;
                                            col++;
                                    }
                            
                    }//while analisis
                biatcora b = new biatcora(ff, gl, sl, ini, vFF, vGL, vSL);
                b.setVisible(true);
            }//metodo analisis
    }
