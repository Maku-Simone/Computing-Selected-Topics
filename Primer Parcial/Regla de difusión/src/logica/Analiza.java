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
public class Analiza
    {
              public Analiza()
                    {			
                        
                    }
              public int FF(int[][] matriz)
                        {
                                int[] FFC = {0, 0, 0}; //{valor, i, j}
                                int max = 0;
                                int[] maxes = {0, 0, 0, 0};
                                while(max < 3)
                                        {
                                            for(int i = 0; i < 3; i++)
                                                    {
                                                            for(int j = 0; j < 3; j++)
                                                                    {
                                                                            if(matriz[i][j] > FFC[0] && matriz[i][j] != maxes[max])
                                                                                    {
                                                                                            FFC[0] = matriz[i][j];
                                                                                            FFC[1] = i;
                                                                                            FFC[2] = j;
                                                                                    }
                                                                    }
                                                    } //for de encontrar centro
                                            if(FFC[0] < 4)
                                                {
                                                    return 0;
                                                }
                                                    if(FFC[1] == FFC[2]) //esta en el centro {valor, i, j}
                                                            {
                                                                    if(FFC[0] > matriz[0][1] && ( (matriz[0][1] == matriz[2][1]) && (matriz[1][0] == matriz[1][2]) ) ) //central mayor a cruz lateral
                                                                            {
                                                                                    return 1;
                                                                            }
                                                            }
                                                    else //está en los lados
                                                            {
                                                                if(FFC[1] == 1 && FFC[2] == 0) //lado izquierdo en medio
                                                                        {
                                                                                if((matriz[1][0] > matriz[0][0]) && (matriz[1][0] > matriz[1][1]) && (matriz[0][0] == matriz[2][0]))
                                                                                        {
                                                                                                return 1;
                                                                                        }
                                                                        }
                                                                if(FFC[1] == 1 && FFC[2] == 2) //lado derecho en medio
                                                                        {
                                                                                if(matriz[1][2] > matriz[0][2] && (matriz[0][2] == matriz[2][2]) && (matriz[1][0] > matriz[1][1])) //evaluo lados
                                                                                        {
                                                                                                return 1;
                                                                                        }
                                                                        }
                                                                if(FFC[1] == 0 && FFC[2] == 1) //arriba en medio
                                                                        {
                                                                                if(matriz[0][1] > matriz[0][2] && (matriz[0][2] == matriz[0][0]) && (matriz[0][1] > matriz[1][1])) //evaluo lados
                                                                                        {
                                                                                                return 1;
                                                                                        }
                                                                        }
                                                                if(FFC[2] == 1 && FFC[1] == 2) //lado derecho en medio
                                                                    {
                                                                            if(matriz[2][1] > matriz[2][0] && (matriz[2][0] == matriz[2][2]) && (matriz[2][1] > matriz[1][1])) //evaluo lados
                                                                                    {
                                                                                            return 1;
                                                                                    }
                                                                    }
                                                            }//else
                                                            max++;
                                                            maxes[max] = FFC[0];
                                    }

                                    return 0;
                    }

              public int SL(int[][] m)
                    {
                        int vida = 3;
                            if(m[0][0] > vida) // esquinita de arriba izr //cuadrado y lados
                                    {
                                            if((m[0][1] > vida && m[1][0] > vida && m[1][1] > vida) || (m[0][1] > vida &&  m[0][2] > vida) || (m[1][0] > vida && m[1][2] > vida))
                                                    {
                                                            return 1;
                                                    }
                                    }
                            if(m[0][2] > vida) // esquinita de arriba dere
                                    {
                                            if(m[0][1] > vida && m[1][2] > vida && m[1][1] > vida)
                                                    {
                                                            return 1;
                                                    }
                                    }
                            if(m[2][0] > vida) // esquinita de abajo izr
                                    {
                                            if(m[1][0] > vida && m[2][1] > vida && m[1][1] > vida)
                                                    {
                                                            return 1;
                                                    }
                                    }
                            if(m[2][2] > vida) // esquinita de abajo der
                                    {
                                            if((m[2][1] > vida && m[1][2] > vida && m[1][1] > vida) ||  (m[2][0] > vida &&  m[2][1] > vida) || (m[1][2] > vida && m[0][2] > vida))
                                                    {
                                                            return 1;
                                                    }
                                    }
                            return 0;
                    }//still life

              public int GL(int[][] m)
                    {
                        int tam = 2;
                            if(m[0][0] >= tam) // esquinita de arriba izr
                                    {
                                            if(m[1][0] >= m[0][0] && m[0][1] >= m[0][0] || (m[1][1] >= m[0][0] && (m[1][0] >= m[0][0] || m[0][1] >= m[0][0])) )
                                                    {
                                                            if(m[2][1] >= m[1][0] && m[1][2] >= m[0][1] || m[2][2] >= m[1][1] && (m[2][1] >= m[1][0] || m[1][2] >= m[0][1]))
                                                                    {
                                                                            return 1;
                                                                    }
                                                    }
                                    }
                            if(m[0][2] >= tam) // esquinita de arriba der
                                    {
                                            if(m[0][1] >= m[0][2] && m[1][2] >= m[0][2] || (m[1][1] >= m[0][2] && (m[1][0] >= m[0][2] || m[1][2] >= m[0][2])) )
                                                    {
                                                            if(m[1][0] >= m[0][1] && m[2][1] >= m[1][2] || m[2][0] >= m[1][1] && (m[2][1] >= m[1][0] || m[1][0] >= m[2][1]))
                                                                    {
                                                                            return 1;
                                                                    }
                                                    }
                                    }

                            if(m[2][0] >= tam) // esquinita de abajo izq
                                            {
                                                    if(m[1][0] >= m[2][0] && m[2][1] >= m[2][0] || (m[1][1] >= m[2][0] && (m[1][0] >= m[2][0] || m[2][1] >= m[2][0])) )
                                                            {
                                                                    if(m[0][1] >= m[1][0] && m[1][2] >= m[2][1] || m[0][2] >= m[1][1] && (m[0][1] >= m[1][0] || m[1][2] >= m[2][1]))
                                                                            {
                                                                                    return 1;
                                                                            }
                                                            }
                                            }
                            if(m[2][2] >= tam) // esquinita de abajo der
                                            {
                                                    if(m[2][1] >= m[2][2] && m[1][2] >= m[2][2] || (m[1][1] >= m[2][2] && (m[2][1] >= m[2][2] || m[1][2] >= m[2][2])) )
                                                            {
                                                                    if(m[1][0] >= m[2][1] && m[0][1] >= m[1][2] || m[0][0] >= m[1][1] && (m[1][0] >= m[2][1] || m[0][1] >= m[1][2]))
                                                                            {
                                                                                    return 1;
                                                                            }
                                                            }
                                            }
                            return 0;
                    }//glider
    }

