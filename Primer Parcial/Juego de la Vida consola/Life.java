import java.io.*;
import java.util.*;

public class Life
	{
		public static void  main (String[] args)
			{

				int fila, colum, vec, k = 0;
				int[] regla = {2,2,3,3}; // (2,2,3,3) Smin, Bmin, Smax, Bmax
				System.out.println("Tamano \n");
				Scanner sc = new Scanner(System.in);
				fila = sc.nextInt();
				colum = fila;
				System.out.println("Seran 10 generaciones \n");
				Random vida = new Random();
				Integer[][] m = new Integer[fila+2][colum+2];
				Integer[][] aux    = new Integer[fila+2][colum+2];
				Integer[][][] saves = new Integer[fila+2][colum+2][10]; //[fila][columna][indice]
				Integer[][] saves2 = new Integer[fila+2][colum+2]; //[fila][columna][indice]
				analiza an = new analiza();
				for(int i = 0; i <= fila + 1; i++)
					{
						for(int j = 0 ; j <= colum + 1; j++)
							{
								if(i == 0 || i == (fila + 1) || j == 0 || j == (colum + 1))
									{
										m[i][j] = 0;
										aux[i][j] = 0;
									}
								else
									{
										m[i][j] = vida.nextInt(2);
									}
							}
					}
				while(k < 10)
					{

						System.out.print("----------------------------------------\n Generacion " + k + "\n");
						for(int i = 1; i <= fila; i++)//imprime matriz
							{
								for(int j = 1; j <= colum; j++)
										{
											if(m[i][j] == 0)
												{
													System.out.print(" ");
												}
											else
												{
													System.out.print("o");
												}
										}
									System.out.print("|\n");
							}
							System.out.print("\n");
							try
							{
								Thread.sleep(200);
							}
							catch(InterruptedException ex)
							{
								Thread.currentThread().interrupt();
							}

						for(int i = 1; i <= fila; i++) //analizar vida
								{
									for(int j = 1; j <= colum; j++)
										{
											if(m[i][j] == 1) //[fila][columna]  Si está viva entonces:
												{
													vec = 0;
													vec += m[i-1][j-1] + m[i-1][j] + m[i-1][j+1]; //las de arriba
													vec += m[i][j-1]   			   + m[i][j+1]; //las de al lado
													vec += m[i+1][j-1] + m[i+1][j] + m[i+1][j+1]; //las de abajo

													if(vec < regla[0]) //morir de aislamiento :c  Smin
														{
															aux[i][j] = 0;
														}
													if(vec > regla[2]) //morir de sobrepoblacion	Smax
														{
															aux[i][j] = 0;
														}
													if(vec >= regla[0] && vec <= regla[2]) //sobrevivir :3
														{
															aux[i][j] = 1;
														}
												}
											else //si está muerta
												{
													vec = 0;
													vec += m[i-1][j-1] + m[i-1][j] + m[i-1][j+1]; //las de arriba
													vec += m[i][j-1]   			   + m[i][j+1]; //las de al lado
													vec += m[i+1][j-1] + m[i+1][j] + m[i+1][j+1]; //las de abajo

													if(vec >= regla[1] && vec <= regla[3]) //nacer *3* //Tiene 3 vecinos B
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
							for(int i = 1; i <= fila; i++)
								{
									for(int j = 1; j <= colum; j++)
										{
											m[i][j] = aux[i][j];
										}
								}//for de volver a pintar
							for(int i = 1; i <= fila; i++)
								{
									for(int j = 1; j <= colum; j++)
										{
											saves[i][j][k] = aux[i][j]; //voy guardando los elementos en mi cubo de matrices
										}
								}//for cubo matrix
						k++;
					}//while vivir

					//Aqui comienza el analizador *3*
					int[] stilllife = new int[2];
					int[] glider = new int[2];
					int[] flipflop = new int[2];
					int[][] mini = new int[3][3];
					int i0 = 1, i, j0 = 1, j, fil = 1, col = 1, tamSecc, x = 0, y = 0; //mm, l es mi contador de secciones
					tamSecc = 3;


					for(int ii = 1; ii <= fila; ii++)
						{
							for(int jj = 1; jj <= colum; jj++)
								{
									for(int kk = 0; kk < 10; kk++)
										{
											saves2[ii][jj] = 0; //inicializo matriz de analisis
										}
								}
						}

					for(int ii = 1; ii <= fila; ii++)
						{
							for(int jj = 1; jj <= colum; jj++)
								{
									for(int kk = 0; kk < 10; kk++)
										{
											saves2[ii][jj] += saves[ii][jj][kk]; //lleno mi matriz de analisis
										}
								}
						}
					for(int li = 1; li <= fila; li++)
						{
							for(int lj = 1; lj <= colum; lj++)
								{
									System.out.print(saves2[li][lj]);
								}
							System.out.print("\n");
						}			//imprimo matriz de analisis


					while(j0 <= colum)
						{
							if(i0 <= fila + 1)
								{
									for(i = i0; i < (fil*tamSecc+1); i++) //dividiendo la matriz
										{
											if(i > colum)
													{
														break;
													}
											for(j = j0 ; j < (col*tamSecc+1); j++)
												{
													if(j > fila)
														{
															break;
														}
													System.out.print(i +","+ j +" "+ saves2[i][j]+" ");
													mini[x][y] = saves2[i][j];
													y++;//columnas
												}
											System.out.print("|\n");
											y = 0;
											x++;
											if(x > 2)
												{
													System.out.println("Mini tiene: \n");
													for(int a = 0; a < 3; a++)
														{
															for(int b = 0; b < 3; b++)
															System.out.print(mini[a][b]);
															System.out.print("\n");
														}
													if(an.FF(mini) == 1)
															{
																	System.out.println("POSIBLE FLIP FLOP ENCONTRADO\n");
															}
													if(an.SL(mini) == 1)
															{
																	System.out.println("POSIBLE STILL LIFE ENCONTRADO\n");
															}
													if(an.GL(mini) == 1)
															{
																	System.out.println("POSIBLE GLIDER ENCONTRADO\n");
															}

													x = 0;
												}																																									}
										i0 = fil*tamSecc+1;
										j0 = 1;
										fil++;
									System.out.println("----------------------");
								}
							else
								{
									i0 = 1;
									j0 = col*tamSecc+1;
									col++;
								}
						}//while analisis

			}//main
	}//clase
