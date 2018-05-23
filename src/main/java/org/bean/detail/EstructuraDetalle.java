package org.bean.detail;

import org.bean.header.EstructuraEncabezado;
import org.error.Log;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author WorkStation_Pro
 */
public class EstructuraDetalle { 
    public AbstracionEstructuraDetalle abtrac= new AbstracionEstructuraDetalle();
    Log log;
   public static final String SEPARATOR=";";
     BufferedReader br;    
    
        public void RetornaTablaEnc1() throws IOException{
    try {
        ArrayList<EstructuraEncabezado> lista = new ArrayList<>();
        EstructuraEncabezado enc = new EstructuraEncabezado();
        ClassPathResource resource = new ClassPathResource("./TablasSimbolos/TablaSimbolos_Detalle.csv");
         
         br =new BufferedReader(new InputStreamReader(resource.getInputStream()));
         String line = br.readLine();
         while (null!=line) {
            String [] arr = line.split(SEPARATOR);
             
            //System.out.println(Arrays.toString(arr));
            
            
                        
//            if(arr.length == 1){
//            lista.add(new EstructuraEncabezado(arr[0],"","","",""));
//            }else if(arr.length == 2){
//            lista.add(new EstructuraEncabezado(arr[0],arr[1],"","",""));
//            }else if(arr.length == 3){
//            lista.add(new EstructuraEncabezado(arr[0],arr[1],arr[2],"",""));
//            }else if(arr.length == 4){
//            lista.add(new EstructuraEncabezado(arr[0],arr[1],arr[2],arr[3],""));
//            }else if(arr.length == 5){
//            lista.add(new EstructuraEncabezado(arr[0],arr[1],arr[2],arr[3],arr[4]));
//            }          
            
             line = br.readLine();
         }
         System.out.println("La tabla de simbolos de Detalle se cargo Exitosamente!!");
//         Iterator<EstructuraEncabezado> it = lista.iterator();
// 
//        while (it.hasNext()) { 
//            
//            EstructuraEncabezado cp =  (EstructuraEncabezado) it.next();
//            
//            System.out.println(cp.getNumeroLinea()+" "+cp.getValorConstante()+" "+cp.getSeparador()+" "+cp.getTipoDato()+" "+cp.getExpresionRegular());
//            }
         
         
         
      } catch (Exception e) {
      System.out.println("El error es de tipo " + e);
      } finally {
         if (null!=br) {
            br.close();
         }
      }
    }
    
    
    
            
}
