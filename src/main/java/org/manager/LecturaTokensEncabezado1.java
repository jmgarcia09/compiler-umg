
package org.manager;

import org.bean.header.EstructuraArchivoEncabezado;
import org.springframework.web.multipart.MultipartFile;

import java.io.*; // PARA LEER EL ARCHIVO
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class LecturaTokensEncabezado1 {
    ArrayList<EstructuraArchivoEncabezado> lista = new ArrayList<>();
         
    public ArrayList<EstructuraArchivoEncabezado> TokensEnc1(MultipartFile file) throws  IOException
    {
        String cadena;
        try (BufferedReader b = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            Integer i = 0;
            while((cadena = b.readLine())!=null) {
                // System.out.println(cadena);
                //SABEMOS QUE EL ENCABEZADO #1 TIENE 44 LINEAS POR ELLO SOLO LEEMOS LAS PRIMERAS LINEAS
                if(i>=0&&i<=44){
                //cadena = (i.toString()+":"+cadena.replace(" ",""));
                 cadena = (i.toString()+":"+cadena);
               // System.out.println(cadena.replace(" ",""));
                String [] arr = cadena.split(":");
                //System.out.println(Arrays.toString(arr));
                
                
              if(arr.length == 1){
            lista.add(new EstructuraArchivoEncabezado(arr[0],"","",""));
           // System.out.println("esto es:"+ arr[0]);
            }else if(arr.length == 2){
            lista.add(new EstructuraArchivoEncabezado(arr[0],arr[1].replaceAll(" +", " ").trim(),"",""));
            // System.out.println("esto es:"+ arr[0]+arr[1]);
            }else if(arr.length == 3){
            lista.add(new EstructuraArchivoEncabezado(arr[0],arr[1].replaceAll(" +", " ").trim(),arr[2].replaceAll(" +", " ").trim(),""));
            // System.out.println("esto es:"+ arr[0]+arr[1]+arr[2]);
            }else if(arr.length == 4){
            lista.add(new EstructuraArchivoEncabezado(arr[0],arr[1].replaceAll(" +", " ").trim(),arr[2].replaceAll(" +", " ").trim(),arr[3].replaceAll(" +", " ").trim()));
             //System.out.println("esto es:"+ arr[0]+arr[1]+arr[2]+arr[3]);
            }  
                }
                i = i + 1;
            }   
//             Iterator<EstructuraArchivoEncabezado> it = lista.iterator();
//        while (it.hasNext()) { 
//            EstructuraArchivoEncabezado cp =  (EstructuraArchivoEncabezado) it.next();
//            System.out.println(cp.getNumeroLinea()+" "+cp.getValorConstante()+" "+cp.getSeparador()+" "+cp.getCampo());
//        }
        } catch (IOException e) {
            System.out.println("El error es: " + e);
        }            
        return lista;  
}
}
