/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.manager;
import org.bean.header.EstructuraArchivoEncabezado;
import org.bean.header.EstructuraEncabezado;
import org.error.EstructuraError;
import org.error.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Obed
 */
public class AnalizadorLexico {
     Log log = new Log();
     String noLinea = "";
     String valorConstante = "";
     String separador = "";
     String campo = "";
     
     String noLineaError = "";
     String analizadorError = "LEXICO";
     String descripcionError = "";
     String solucionError = "";
      ArrayList<EstructuraError> listaError = new ArrayList<>();
      
     public ArrayList<EstructuraArchivoEncabezado> ComparaEncabezado_1(ArrayList<EstructuraEncabezado> TabSim, ArrayList<EstructuraArchivoEncabezado> Lectura) throws IOException{
                ArrayList<EstructuraArchivoEncabezado> listaEnviar = new ArrayList();
                 Iterator<EstructuraEncabezado> it = TabSim.iterator();
                 Iterator<EstructuraArchivoEncabezado> it2 = Lectura.iterator();
                 
                 
        while (it.hasNext() && it2.hasNext()) { 
            EstructuraEncabezado Tab =  (EstructuraEncabezado) it.next();
            EstructuraArchivoEncabezado Lec = (EstructuraArchivoEncabezado) it2.next();
            //System.out.println(Lec.getCampo());
            //      
          
           //System.out.println("La linea leida es: "+ Tab.getNumeroLinea()+", "+Lec.getNumeroLinea());
            if (Tab.getNumeroLinea().equals(Lec.getNumeroLinea())){
                //System.out.println(Tab.getNumeroLinea()+" El numero de linea es correcta");    
                noLinea = Lec.getNumeroLinea();
            }else{
                noLinea = null;
               
               // System.out.println(Tab.getNumeroLinea()+" El numero de linea no correcta");
                //log.llenarLog("LEXICO", Tab.getNumeroLinea() +" El numero de linea no correcta");
            }
            
            if (Tab.getValorConstante().equals(Lec.getValorConstante()) )
            {
               //System.out.println(Lec.getNumeroLinea()+" Ok"); 
                valorConstante = Lec.getValorConstante();      
            }else{
                valorConstante = null; 
                               System.out.println(Tab.getValorConstante()+" DIFERENTE DE "+Lec.getValorConstante()+"...");
               // System.out.println(Lec.getNumeroLinea()+" "+Lec.getValorConstante()+" El numero de linea no correcta");
               // log.llenarLog("LEXICO","Error en la linea :" +Tab.getNumeroLinea()+" Ref:"+ Tab.getValorConstante()+"difiere de"+Lec.getValorConstante()+";");
            }
            
            

          
            if ("True".equals(Tab.getCampoObligatorio()))
            {                
                //SE INGRESA EN CAMPO EL VALOR QUE VIENE EN SEPARDOR POR QUE NO LO LEE CORRECTAMENTE CON SPLIT
               Lec.setCampo(Lec.getSeparador().replaceAll(" +", " ").trim());                
               Lec.setSeparador(":");
               separador = Lec.getSeparador();
              // System.out.println(Lec.getNumeroLinea()+" " +Lec.getCampo());
               if (!"".equals(Lec.getCampo())){
                   campo = Lec.getCampo();
               }else{
                   campo = null;
                  
                   //System.out.println("Se requiere datos obligatorios en linea #"+Lec.getNumeroLinea() +" Segun tabla de simbolo Linea #"+Tab.getNumeroLinea()+" "+Tab.getValorConstante());
               }             
            }else{  
                campo = "";                
               log.llenarLog("LEXICO","Error en la linea :" +Tab.getValorConstante()+" Esta lleno con :"+ Lec.getValorConstante()+";");
            }  
             listaEnviar.add(new EstructuraArchivoEncabezado(noLinea,valorConstante,separador,campo));
                        }
       
        return listaEnviar;
            }
        
    
          public ArrayList<EstructuraError> RetornarErores(ArrayList<EstructuraEncabezado> TabSim, ArrayList<EstructuraArchivoEncabezado> Lectura) throws IOException{
                 Iterator<EstructuraEncabezado> it = TabSim.iterator();
                 Iterator<EstructuraArchivoEncabezado> it2 = Lectura.iterator();
                 
                 
        while (it.hasNext() && it2.hasNext()) { 
            EstructuraEncabezado Tab =  (EstructuraEncabezado) it.next();
            EstructuraArchivoEncabezado Lec = (EstructuraArchivoEncabezado) it2.next();
           noLinea = Lec.getNumeroLinea();
            if (!Tab.getNumeroLinea().equals(Lec.getNumeroLinea())){
                 listaError.add(new EstructuraError(noLinea,analizadorError,"El numero de linea no es acorde al numero de la tabla de simbolos","Acualice la linea"));
            }
            
            if (!Tab.getValorConstante().equals(Lec.getValorConstante()) )
            {
                listaError.add(new EstructuraError(noLinea,analizadorError,"El valor constante no es valido con la tabla de simbolos "+ Lec.getValorConstante(),"Acualice la linea"));
            }               
            if ("True".equals(Tab.getCampoObligatorio()) && !Tab.getValorConstante().contains("Personalizado"))
            {
              if ("".equals(Lec.getCampo())){
               listaError.add(new EstructuraError(noLinea,analizadorError,"No se econtro datos en campo obligatorio de item: " + Lec.getValorConstante(),"Llene el espacio vacio"));
               }
                         
            }  
        }
        return listaError;
    }
     
}
