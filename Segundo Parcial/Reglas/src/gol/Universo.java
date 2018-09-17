/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gol;

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
import logica.Vida;

/**
 *
 * @author Maku
 */
class Universo extends JPanel  {
        int[] m;
        int[][] guardado;
        int tam, click, tamCelula = 10, tiempo, posG = 0; //tam = num de celulas
        private Graphics2D g2d;
        Color viva,  muerta;
        int regla;
        Dios gg = new Dios();
        private int zoom = 0;
        private static final double ZOOM_AMOUNT = 1.1;
        Universo ()
            {
                
            }
        Universo(int regla, int tam, int tiempo, Color vi, Color mu)
        {                     
            this.regla = regla;
            this.tam = tam;   
            setPreferredSize(new Dimension(tam*tamCelula,tam*tamCelula)); //x, y 
            m = gg.creaVida(tam);
            this.tiempo = tiempo;
            guardado = new int[tam][tam];
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
                                                                            if(m[x] == 1)
                                                                                {
                                                                                    m[x] = 0;
                                                                                }
                                                                            else
                                                                                {
                                                                                    m[x] = 1;
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

        Universo(int regla, int tam, int tiempo, int cero, Color vi, Color mu)
        {                     
            this.regla = regla;
            this.tam = tam;   
            setPreferredSize(new Dimension(tam*tamCelula,tam*tamCelula)); //x, y 
            m = gg.destruyeVida(tam);
            this.tiempo = tiempo;
            viva = vi;
            guardado = new int[tam][tam];
            muerta = mu;
            this .addMouseListener(new MouseListener() {
                                                        @Override
                                                        public void mouseClicked(MouseEvent e) 
                                                                {
                                                                    int x, y;
                                                                    Point p = e.getPoint();
                                                                    y = (int) Math.floor((float)p.getX()/tamCelula);
                                                                    x = (int) Math.floor((float)p.getY()/tamCelula);
                                                                    if(x < tam)
                                                                        {
                                                                            if(m[y] == 1)
                                                                                {
                                                                                    m[y]  = 0;
                                                                                }
                                                                            else
                                                                                {
                                                                                    m[y] = 1;
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
        
       Universo(int regla, int tam, int tiempo, int[] car, Color vi, Color mu)
        {                     
            this.regla = regla;
            this.tam = tam;   
            guardado = new int[tam][tam];
            System.out.println(this.tam);            
            setPreferredSize(new Dimension(tam*tamCelula,tam*tamCelula)); //x, y 
            m = car;
            this.tiempo = tiempo;
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
                                                                            if(m[x] == 1)
                                                                                {
                                                                                    m[y] = 0;
                                                                                }
                                                                            else
                                                                                {
                                                                                    m[y] = 1;
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
                    click = 0;
                   // repaint();
                }
             else
                {                    
                    m = analiza(m, regla);
                     if(posG == tam-1) 
                        {
                            System.out.println("No hago nada -3-");
                        }
                       else
                       {
                           posG++;
                       }
                }
              for(int i = 0; i < tam; i++)
                     {
                        guardado[i][posG] = m[i];                                               
                     }     
             
            g2d = (Graphics2D) g;	
          //  cuadricula(g2d);
            for(int i = 0; i < tam; i++)
                {
                    for(int j = 0; j < tam; j++)
                        {
                            if(guardado[j][i] == 1) //están al revesados
                            {
                                      g2d.setColor(viva);
		g2d.fillRect(tamCelula*j, tamCelula*i, tamCelula, tamCelula); //x, y, tamx, tamy
		g2d.drawRect(tamCelula*j, tamCelula*i, tamCelula, tamCelula); //x, y, tamx, tamy //x, y       
                                    //cuadricula(g2d);
                            }
                            else
                            {
                                    g2d.setColor(muerta);
		g2d.fillRect(tamCelula*j, tamCelula*i, tamCelula, tamCelula); //x, y, tamx, tamy
		g2d.drawRect(tamCelula*j, tamCelula*i, tamCelula, tamCelula); //x, y, tamx, tamy //x, y
                           //cuadricula(g2d);
                            }
                        }
                }
                       //cuadricula(g2d);
           
           // repaint();
            try 
            {                             
                            //System.out.println("tiempo " +tiempo);
                 Thread.sleep(tiempo);	
            }
         catch (Exception e) {}
        } //paint component
            public int[] analiza(int[] m, int regla)
                {
                    Vida v = new Vida();
                    //System.out.println("hay"+regla[0]);
                    return v.existe(m,regla, tam);
                }


 public int[] getMatriz()
    {
        return m;
    }     
 public void setTiempo(int tiempo)
    {
        this.tiempo = tiempo;
    }
 public void setZoom(int zoom)
 {
     if(zoom == 0)
        {
            this.tamCelula = 10;
        }
     else
     {
         this.tamCelula = 10 + zoom;
     }
 }
   public void cuadricula (Graphics g2d)
                {
                    for(int i = 0; i < tam; i++)
                        {
                            g2d.setColor(viva);
                            g2d.drawLine(i*tamCelula,0, i*tamCelula, tam*tamCelula); //xy, x1y1
                            g2d.drawLine(0, i*tamCelula, tam*tamCelula, i*tamCelula); //xy, x1y1
                        }
                }
    }//class
    