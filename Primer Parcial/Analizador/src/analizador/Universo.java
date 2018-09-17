/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JPanel;
import logica.Dios;
import logica.Divisor;
import logica.Vida;

/**
 *
 * @author Maku
 */
class Universo extends JPanel  {
        int[][] m, ini;
        int[][][] cubo;
        int tam, click, tamCelula = 10, gens = 10, k = 0, au = 0; //tam = num de celulas
        private Graphics2D g2d;
        Color viva,  muerta;
        int[] regla = new int[4];
        Dios gg = new Dios();
        

        Universo ()
            {
                
            }
        Universo(int[] regla, int tam, Color vi, Color mu)
        {                     
            this.regla = regla;
            this.tam = tam;   
            setPreferredSize(new Dimension(tam*tamCelula,tam*tamCelula)); //x, y 
            m = gg.creaVida(tam);   
            ini = m; //inicial sin cambios

            cubo = new int[m.length][m.length][gens];
            viva = vi;
            k = 0;
            muerta = mu;
            this .addMouseListener(new MouseListener() {
                                                        @Override
                                                        public void mouseClicked(MouseEvent e) 
                                                                {
                                                                    int x, y;
                                                                    Point p = e.getPoint();
                                                                    y = (int) Math.floor((float)p.getX()/tamCelula);
                                                                    x = (int) Math.floor((float)p.getY()/tamCelula);
                                                                    if(x < tam && y < tam)
                                                                        {
                                                                            if(m[x][y] == 1)
                                                                                {
                                                                                    m[x][y] = 0;
                                                                                }
                                                                            else
                                                                                {
                                                                                    m[x][y] = 1;
                                                                                }                                                                          
                                                                            click = 1;
                                                                            repaint();
                                                                        }
                                                                }

                                                        @Override
                                                        public void mousePressed(MouseEvent e) {
                                                            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                                                        }

                                                        @Override
                                                        public void mouseReleased(MouseEvent e) {
                                                           // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                                                        }

                                                        @Override
                                                        public void mouseEntered(MouseEvent e) {
                                                          //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                                                        }

                                                        @Override
                                                        public void mouseExited(MouseEvent e) {
                                                          //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                                                        }
                                                    });
                     
        }

        Universo(int[] regla, int tam,  int cero, Color vi, Color mu)
        {                     
            k = 0;
            this.regla = regla;
            this.tam = tam;   
            setPreferredSize(new Dimension(tam*tamCelula,tam*tamCelula)); //x, y 
            m = gg.destruyeVida(tam);
            cubo = new int[m.length][m.length][gens];
            viva = vi;
            muerta = mu;
            this .addMouseListener(new MouseListener() {
                                                        @Override
                                                        public void mouseClicked(MouseEvent e) 
                                                                {
                                                                    int x, y;
                                                                    Point p = e.getPoint();
                                                                    y = (int) Math.floor((float)p.getX()/tamCelula);
                                                                    x = (int) Math.floor((float)p.getY()/tamCelula);
                                                                    if(x < tam && y < tam)
                                                                        {
                                                                            if(m[x][y] == 1)
                                                                                {
                                                                                    m[x][y] = 0;
                                                                                }
                                                                            else
                                                                                {
                                                                                    m[x][y] = 1;
                                                                                }                                                                          
                                                                            click = 1;
                                                                            repaint();
                                                                        }
                                                                }

                                                        @Override
                                                        public void mousePressed(MouseEvent e) {
                                                            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                                                        }

                                                        @Override
                                                        public void mouseReleased(MouseEvent e) {
                                                           // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                                                        }

                                                        @Override
                                                        public void mouseEntered(MouseEvent e) {
                                                          //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                                                        }

                                                        @Override
                                                        public void mouseExited(MouseEvent e) {
                                                          //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                                                        }
                                                    });
            
        }
        
        Universo(int[] regla, int tam,  int[][] car, Color vi, Color mu)
        {                     
            this.regla = regla;
            this.tam = tam-2;   
            ini = car;
            k = 0;
            System.out.println(this.tam);
            setPreferredSize(new Dimension(tam*tamCelula,tam*tamCelula)); //x, y 
            m = car;
            cubo = new int[m.length][m.length][gens];
            viva = vi;
            click = 1;
            muerta = mu;
            this .addMouseListener(new MouseListener() {
                                                        @Override
                                                        public void mouseClicked(MouseEvent e) 
                                                                {
                                                                    int x, y;
                                                                    Point p = e.getPoint();
                                                                    y = (int) Math.floor((float)p.getX()/tamCelula);
                                                                    x = (int) Math.floor((float)p.getY()/tamCelula);
                                                                    if(x < tam && y < tam)
                                                                        {
                                                                            if(m[x][y] == 1)
                                                                                {
                                                                                    m[x][y] = 0;
                                                                                }
                                                                            else
                                                                                {
                                                                                    m[x][y] = 1;
                                                                                }                                                                          
                                                                            click = 1;
                                                                            repaint();
                                                                        }
                                                                }

                                                        @Override
                                                        public void mousePressed(MouseEvent e) {
                                                            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                                                        }

                                                        @Override
                                                        public void mouseReleased(MouseEvent e) {
                                                           // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                                                        }

                                                        @Override
                                                        public void mouseEntered(MouseEvent e) {
                                                          //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                                                        }

                                                        @Override
                                                        public void mouseExited(MouseEvent e) {
                                                          //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                                                        }
                                                    });
                     
        }
               @Override
        public void paintComponent(Graphics g) 
        {
            super.paintComponent(g);     
            
         if(click == 1)            
                {
                    ini = m;
                    click = 0;
                    if(k != 0)
                        {
                            k--;
                        }
                    else
                        {
                            k = 0;
                        }
                   // repaint();
                }
             else
                {
                    m = analiza(m, regla);
                }
            g2d = (Graphics2D) g;	
            if(k == gens)
                {
                       for(int i = 1; i <= tam; i++)
                            {
                                for(int j = 1; j <= tam; j++)
                                    {
                                        
                                        if(m[i][j] == 1)
                                            {
                                                      g2d.setColor(viva);
                                                        g2d.fillRect(tamCelula*j, tamCelula*i, tamCelula, tamCelula); //x, y, tamx, tamy
                                                        g2d.drawRect(tamCelula*j, tamCelula*i, tamCelula, tamCelula); //x, y, tamx, tamy //x, y                
                                                        cuadricula(g2d);
                                            }
                                        else
                                            {
                                                    g2d.setColor(muerta);
                                                    g2d.fillRect(tamCelula*j, tamCelula*i, tamCelula, tamCelula); //x, y, tamx, tamy
                                                    g2d.drawRect(tamCelula*j, tamCelula*i, tamCelula, tamCelula); //x, y, tamx, tamy //x, y
                                            }
                                    }
                            }
                    if(au == 0)
                        {

                            Divisor d = new Divisor(cubo, tam, gens, ini);                        
                            d.analisis();        
                            au++;
                        }                    
                }
            else
                {
                        for(int i = 1; i <= tam; i++)
                            {
                                for(int j = 1; j <= tam; j++)
                                    {
                                        
                                        if(m[i][j] == 1)
                                            {
                                                      g2d.setColor(viva);
                                                        g2d.fillRect(tamCelula*j, tamCelula*i, tamCelula, tamCelula); //x, y, tamx, tamy
                                                        g2d.drawRect(tamCelula*j, tamCelula*i, tamCelula, tamCelula); //x, y, tamx, tamy //x, y                                   
                                            }
                                        else
                                            {
                                                    g2d.setColor(muerta);
                                                    g2d.fillRect(tamCelula*j, tamCelula*i, tamCelula, tamCelula); //x, y, tamx, tamy
                                                    g2d.drawRect(tamCelula*j, tamCelula*i, tamCelula, tamCelula); //x, y, tamx, tamy //x, y
                                            }
                                        cubo[i][j][k] = m[i][j];
                                    }
                            }
                        k++;                        
                 }//else
            cuadricula(g2d);
            
           // repaint();
            try 
                {                                                         
                     Thread.sleep(200);	
                }
            catch (Exception e) {}
            
        } //paint component
            public int[][] analiza(int[][]m, int[] regla)
                {
                    Vida v = new Vida();
                    //System.out.println("hay"+regla[0]);
                    return v.existe(m,regla, tam);
                }

            public void cuadricula (Graphics g2d)
                {
                    for(int i = 0; i < tam; i+=3)
                        {
                            g2d.setColor(viva);
                            g2d.drawLine(i*tamCelula,0, i*tamCelula, tam*tamCelula); //xy, x1y1
                            g2d.drawLine(0, i*tamCelula, tam*tamCelula, i*tamCelula); //xy, x1y1
                        }
                }
        public int[][] getMatriz()
           {
               return m;
           }     
    }//class
    