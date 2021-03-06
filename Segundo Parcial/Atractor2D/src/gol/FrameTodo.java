/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gol;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import logica.Escritor;
import logica.Base;
import logica.Vida;

/**
 *
 * @author Maku
 */
public class FrameTodo extends javax.swing.JFrame implements ActionListener, MouseListener, MouseMotionListener  {
    int nodoActual = 0,  tam, arshivo = 0;  
    int[] regla = new int[4];    
    private Timer timer;   
    Escritor esc = new Escritor();
    Vida v = new Vida();
    Base b = new Base();      
    /**
     * Creates new form FrameTodo
     */
    public FrameTodo() {
        initComponents();    
        timer = new Timer(50, this);
     //   b.conectar();
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        BtnPausar = new javax.swing.JButton();
        txtRegla = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtTamUniv = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnGuardaMatriz = new javax.swing.JButton();
        Prog = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Iniciar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        BtnPausar.setText("Pausar");
        BtnPausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPausarActionPerformed(evt);
            }
        });

        txtRegla.setText("2233");
        txtRegla.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtReglaFocusLost(evt);
            }
        });
        txtRegla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtReglaActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Regla");

        txtTamUniv.setText("3");
        txtTamUniv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTamUnivActionPerformed(evt);
            }
        });

        jLabel3.setText("Tamaño ");
        jLabel3.setToolTipText("");

        btnGuardaMatriz.setText("Guardar");
        btnGuardaMatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardaMatrizActionPerformed(evt);
            }
        });

        Prog.setBackground(new java.awt.Color(153, 51, 255));
        Prog.setForeground(new java.awt.Color(102, 0, 102));
        Prog.setStringPainted(true);

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Prog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnPausar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtRegla, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTamUniv, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                    .addComponent(btnGuardaMatriz, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtRegla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTamUniv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(BtnPausar)
                .addGap(18, 18, 18)
                .addComponent(btnGuardaMatriz)
                .addGap(18, 18, 18)
                .addComponent(Prog, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addGap(93, 93, 93))
        );

        txtRegla.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //INICIAR
        if(autoriza() == 1)
          {
              if(jButton1.getText().equals("Reiniciar"))
                {
                        nodoActual = 0;                        
                        BtnPausar.setText("Pausar");
                        timer.stop();            
                         jButton1.setText("Iniciar");    
                }
              else
               {
                    jButton1.setText("Reiniciar");          
                    setRegla();
                    regla = getRegla();
                    tam = Integer.parseInt(txtTamUniv.getText()) ; //el máximo a calcular
                    Prog.setMaximum((int) Math.pow(2,tam*tam)); //el maximo del progress bar        
                    String reg = "";
                        for(int i = 0; i < 4; i++)
                            {
                                reg += regla[i];
                            }
                    esc.escribe(regla, "Export[\"Toroide - "+reg+"-"+tam+"x"+tam+".png\", Graph[{");
                    timer.start();
               }              
          } 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BtnPausarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPausarActionPerformed
        // TODO add your handling code here:
        if(timer.isRunning())
            {
                timer.stop();
                BtnPausar.setText("Reanudar");
            } 
        else
            {
                if(BtnPausar.getText().equals("Reanudar"))
                    {
                        timer.restart();                    
                        BtnPausar.setText("Pausar");
                    }
            }        
    }//GEN-LAST:event_BtnPausarActionPerformed

    private void txtTamUnivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTamUnivActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTamUnivActionPerformed

    private void txtReglaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtReglaFocusLost
        // TODO add your handling code here:
        setRegla();
        //System.out.println(regla[0]);
    }//GEN-LAST:event_txtReglaFocusLost

    private void btnGuardaMatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardaMatrizActionPerformed
        // TODO add your handling code here:
        timer.stop();
        if(esc.escribe(regla, "}];") == 1)
        {
            JOptionPane.showMessageDialog(null, "Se ha creado un sensual archivo");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No se pudo crear el archivo ;3;");
        }
    }//GEN-LAST:event_btnGuardaMatrizActionPerformed

    private void txtReglaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtReglaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtReglaActionPerformed

    public  int[] getRegla()
        {
                   return regla;
        }
    public void setRegla()
        {
            for(int l = 0; l < 4; l++)
                        {
                            regla[l] = Character.getNumericValue(((txtRegla.getText()).charAt(l)));
                        }
        }
    public int getTam()
        {
            return Integer.parseInt(txtTamUniv.getText());
        }    
    public void setColor()
        {
            //cViva = btnViva.getColor();
        }
public int autoriza()
    {
              if(txtRegla.getText().length() == 4)
                {
                    if(Integer.parseInt(txtTamUniv.getText()) < 3)
                        {
                            JOptionPane.showMessageDialog(null, "Mayor a 3 por favor -3-");
                        }
                    else{
                             if(Integer.parseInt(txtTamUniv.getText()) > 1000)
                                    {
                                        JOptionPane.showMessageDialog(null, "¿Tú quieres que explote, verdad?");
                                    }
                             else
                             {                                             
                                       return 1;
                             }
                        } 
                }
            else
                {
                    JOptionPane.showMessageDialog(null, "Escribe bien la regla >:c deben ser SSBB");
                }
          return 0;
    }
    
        public void actionPerformed(ActionEvent e) { //por cada tic del timer
        Object src = e.getSource(); 
        if (src == timer) 
            {
                Prog.setValue(nodoActual);
                if(nodoActual == (int)Math.pow(2,tam*tam)) //ya terminé
                    {
                        timer.stop();     
                        esc.escribe(regla, "}, ImageSize->Full]];");
                        JOptionPane.showMessageDialog(null, "Análisis Terminado. Se ha creado un sensual archivo");
                    }
                else
                    {
                        
                        int[] mat;//actual                        
                        int[] mat2; //evaluado
                        int nodoSiguiente; //evaluado en decimal
                        String coma = ",";
                        mat = v.binario(nodoActual, tam*tam); //obtengo mi nodo actual en binario
                        mat2 = v.existe(mat, tam, regla);
                        nodoSiguiente = v.decimal(mat2);
                        //System.out.println(nodoActual + " -> " + nodoSiguiente);
                        if(nodoActual == (int)Math.pow(2,tam*tam) - 1)
                            {
                                coma = "";
                            }
                        String txt = nodoActual + "->" + nodoSiguiente+coma;
                        esc.escribe(regla, txt);
                       nodoActual++;                                        
                    }
            }
        }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameTodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameTodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameTodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameTodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {                
                new FrameTodo().setVisible(true);               
            }
        });      
    }
    
	public void run() 
                    {
	    
                    }
	private void stopRunning() {
		//toggleRunButton.setText("Start");
				
	}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnPausar;
    private javax.swing.JPanel Menu;
    private javax.swing.JProgressBar Prog;
    private javax.swing.JButton btnGuardaMatriz;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtRegla;
    private javax.swing.JTextField txtTamUniv;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
