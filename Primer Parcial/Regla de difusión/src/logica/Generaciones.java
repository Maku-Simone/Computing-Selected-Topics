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
public class Generaciones 
{
    int[] todas;
    public Generaciones(int[] todas)
        {
            this.todas = todas;
        }
    public void informa()
        {
            for(int i = 0; i < todas.length; i++)
                {
                    System.out.println(todas[i]);
                }
        }
}
