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
public class Varianza 
{
    int[] arrayVi;
    public Varianza(int[] arrayVi)
        {
            this.arrayVi = arrayVi;
        }
    public void calcula()
        {
            double acMedia = 0, acMedia2 = 0, varianza, x;
            int n = 0;
            for(int i = 0; i < arrayVi.length; i++)
                {
                  x = (double) arrayVi[i];
                  acMedia = acMedia + x;
                  acMedia2 = acMedia2 + x * x;
                  n++;
                }
            varianza =  acMedia2 / (n - 1) - (acMedia * acMedia) / (n * (n - 1));
            System.out.println("La varianza es: " + varianza);                
            System.out.println("La media es: " + (acMedia / n));             
        }
}
