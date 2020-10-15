/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radixsort.plegamento;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author rosemberg
 */
public class RadixSortPlegamento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        int opc = 0;
        Scanner src = new Scanner(System.in);
        System.out.println("Para salir , ejecute <Ctl>+z");
        while (src.hasNext())
        {
            System.out.println("Indique el metodo a utilizar:\n1. RadixSort\n2. Busqueda Plegamento\n3. RadixSort & Plegamento\n");
            opc = src.nextInt();
            
            System.out.println("Indique el tamaño del vector\n");
            int array = src.nextInt();
            
            switch (opc)
            {       
                case 1:
                   new RadixSOrt().inicializarRadix(array);
                break;
                case 2:
                   new BusquedaPlegamento().BusquedaPlegamento(array);
                break;
                case 3:
                    
                break;
            }
        }
        
        
    }
    
}
