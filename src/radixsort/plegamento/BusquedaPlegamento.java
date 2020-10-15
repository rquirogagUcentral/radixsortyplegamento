/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radixsort.plegamento;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.Scanner;

import java.util.Objects;


/**
 *
 * @author rosemberg
 */
public class BusquedaPlegamento {

    private static int Array[] = new int [100002];
    
    /**
     * @param args the command line arguments
     */
    public void BusquedaPlegamento(int tamanio) throws FileNotFoundException, IOException {
        // TODO code application logic here
        int numero;
        
        int resultado = 0;
        long TIni, TFin, Tiempo;
        int[] array = new int[tamanio];
        File file = new File("/home/rosemberg/Documentos/U/2020-2/Analisis_de_Algoritmos/Exposicion/csv2.csv");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        int i = 0;
        int k=0;
        while (br.ready()) {
            // System.out.println(br.readLine());
            Array[i]=0;
            array[i] = parseInt(br.readLine());
            if (i >= tamanio-1)
                    break;
            i++;
            
        }
        //Paso 1: Generación del array con Hash
        TIni = System.currentTimeMillis();
        int j=0;
        int indice;
        while(j<array.length)
        {
            indice = GenerarIndicePorPlegamiento10n(array[j], tamanio);
            if(Array[indice]==0)
                Array[indice]=array[j];
            else
                pruebaCuadratica(array[j],indice);
            j++;
        }
        TFin = System.currentTimeMillis();
        Tiempo = TFin - TIni;
        ImpArreglo(Array);
        System.out.println("Tiempo de ejecución: " + Tiempo + " milisegundos");
        
        //Paso 2: busqueda de un número
        System.out.println("Indique numero a buscar:\n");
        Scanner sc = new Scanner(System.in);
        numero = sc.nextInt();
        busquedaSecuencial(numero);
        
    }
    
    private static String ImpArreglo(int[] array)
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
    
    private static int GenerarIndicePorPlegamiento10n(int clave, int tamanio){
        String cad = String.valueOf(clave);
        int k = sumarRecursivo(cad, tamanio);
        return k;
    }
    
    private static int sumarRecursivo(String cad, int tamanio) {
        int suma = 0;
        for(int i = 0; i < cad.length(); i++){
            suma *= Integer.parseInt(String.valueOf(cad.charAt(i)));
        }
        if(suma>tamanio - 1){
            return sumarRecursivo(String.valueOf(suma),tamanio);
        }else{
            return suma;
        }
    }
    
    //Solucion de colision por prueba lineal
    private static int pruebaCuadratica(int data, int fpos) {
        
        //pos
        int flag = fpos;
        
        //i
        int i = 1;
        
        boolean found = false;
        
        do{
           
            flag = flag + 1;
            i++;
            
            if(flag>=Array.length){
                flag = 0;
                i = 1;
            }
            
            System.out.println("nuevo indice calculado: "+flag+", revisando...");
            
            if(Array[flag]==0){
                Array[flag]=data;
                found = true;
                System.out.println("Indice: "+flag+" asignado para "+data +"Clave Hash");
                return 0;
            }else if(Array[flag]==data){
                return flag;
            }else{
                System.out.println("el indice "+flag+" ya ha sido asignado, recalculando...Indice ocupado");
            }
        
        }while(flag!=fpos);
        if(!found){
            System.out.println("El arreglo se encuentra lleno Arreglo lleno");
            return -1;
        }
        return 0;
    }
    
     //##------- METODOS DE BUSQUEDA-------##//
    //Algoritmos de busqueda
    public static byte busquedaSecuencial(int data){    
        boolean flag = false;
        
        int i;
        
        for(i = 0; i<Array.length; i++){
            if(Array[i]==data){
                flag = true;
                break;
            }
        }
        
        if(flag){
            System.out.println("El elemento "+data+" se encontro en el indice "+i);
            return (byte)i;
        }else{
           System.out.println("El elemento "+data+" no se encontro en el arreglo");
            return -1;
        }
    }
    
}
