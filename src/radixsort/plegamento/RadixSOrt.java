/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

hola
Tú
21:24
puchica ! sopa y seco 
:O
cesar adolfo velasco ariza
21:38
pille mas o menos como funciona 
el https://edukativos.com/apuntes/archives/10585 
codular 
modular
cesar adolfo velasco ariza
22:19
https://runestone.academy/runestone/static/pythoned/SortSearch/TransformacionDeClaves.html
 */
package radixsort.plegamento;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Integer.parseInt;

/**
 *
 * @author rosemberg
 */
public class RadixSOrt {
    
    private int[] Vector=null;
    /**
     * @param args the command line arguments
     */
    public void inicializarRadix(int tamanio) throws FileNotFoundException, IOException {
        // TODO code application logic here
        int resultado = 0;
        
        long TIni, TFin, Tiempo;
        
        
        
        int Array[] = new int[tamanio];
        int[] array = new int[tamanio];
        File file = new File("/home/rosemberg/Documentos/U/2020-2/Analisis_de_Algoritmos/Exposicion/csv.csv");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        int i = 0;
        while (br.ready()) {
            // System.out.println(br.readLine());
            array[i] = parseInt(br.readLine());
            if (i >= tamanio-1)
                    break;
            i++;
        }
        
        ImpArreglo(array);
        TIni = System.currentTimeMillis();
        Array = Ordenaradix(array);
        TFin = System.currentTimeMillis();
        Tiempo = TFin - TIni;
        ImpArreglo(Array);
        System.out.println("Tiempo de ejecución: " + Tiempo + " milisegundos");
    }
    
    private String ImpArreglo(int[] array)
    {
        String result = "[";
        int j=0;
        String pvec= "[";
        while(j < array.length)
        {
            pvec += array[j]+",";
            j++;
        }
        pvec += "]\n";
        System.out.println(pvec);
        return result;
    }
    
    private int[] Ordenaradix(int[] array) {
        Vector = array;    
        int mayor = 0;
        for (int i = 1; i < Vector.length; i++) {
          if (Vector[i] > mayor) {
            mayor = Vector[i];
          }
        }
        int posición = 1;// desde unidades
        while (mayor / posición > 0) {
          ordenacontando(posición);
          posición = posición * 10;
        }
        
        return Vector;
    }

        private void ordenacontando(int posición){
            int tamaño = Vector.length;
            int[] intercambio = new int[tamaño];
            int[] cuántosenlaposición = new int[10];
            for(int i = 0; i < tamaño; i++){
                cuántosenlaposición[(Vector[i]/posición)%10]++;
            }

            for(int i = 1; i < 10; i++){
                cuántosenlaposición[i] = cuántosenlaposición[i] + cuántosenlaposición[i-1];
            }

           int indice=0;
           for(int i = tamaño-1; i >=0; i--){
              indice=(Vector[i]/posición)%10;
              intercambio[cuántosenlaposición[indice] - 1] = Vector[i];
              cuántosenlaposición[indice]--;
           }
           Vector=intercambio;
           
        }
    
}
