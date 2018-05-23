/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.manager;


import org.bean.header.EstructuraArchivoEncabezado;
import org.bean.header.EstructuraEncabezado;
import org.error.EstructuraError;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Obed
 */
public class AnalizadorSintactico {
    ArrayList<EstructuraArchivoEncabezado> listaArchivo;
    ArrayList<EstructuraError> listaError;
    
    public ArrayList<EstructuraArchivoEncabezado> ComparaSintactico(ArrayList<EstructuraEncabezado> TabSim, ArrayList<EstructuraArchivoEncabezado> Lectura) throws IOException{
        //DECLARO MIS ITERADORES
         Iterator<EstructuraEncabezado> it = TabSim.iterator();
         Iterator<EstructuraArchivoEncabezado> it2 = Lectura.iterator();
         //INSTANCIO LISTA ARCHIVO
         listaArchivo = new ArrayList<>();
         //INICIO EL CICLO PARA RECORRER LAS LISTAS 
           while (it.hasNext() && it2.hasNext()) { 
            EstructuraEncabezado Tab =  (EstructuraEncabezado) it.next();
            EstructuraArchivoEncabezado Lec = (EstructuraArchivoEncabezado) it2.next();
            //SI EL CAMPO OBLIGATORIO ES IGUAL A TRUE 
            if (Tab.getCampoObligatorio().equals("True")){
                //SI EL CAMPO OBLIGATORIO NO ES NULL
                if (Lec.getCampo() != null){                    
		Pattern patron =  Pattern.compile(Tab.getExpresionRegular()); //Pattern.compile("([0-9]{2})/([0-9]{2})/([0-9]{4})");
                Matcher emparejador = patron.matcher(Lec.getCampo());
                //COMPRUEBO SI COINCIDEN LOS VALORES CON LAS EXPRESIONES REGULARES
			boolean esCoincidente = emparejador.find();
			if (esCoincidente) {
                            listaArchivo.add(new EstructuraArchivoEncabezado(Lec.getNumeroLinea(),Lec.getValorConstante(),Lec.getSeparador(),Lec.getCampo()));
				///System.out.println("Expresion Reconocida en Linea No.: "+ Lec.getNumeroLinea()+" Campo es: " + Lec.getCampo());
                          }else{
                            //	System.out.println("No se reconoce la linea No.: "+ Lec.getNumeroLinea()+ " Expresion es: "+ Tab.getExpresionRegular()+" Campo es: " + Lec.getCampo());
                        }           
                }
          //SI NO ES CAMPO OBLIGATORIO SOLO CARGO EL VALOR LEIDO EN LA LISTA A RETORNAR
            }else{
              //  if (Lec.getCampo() != null && Lec.getNumeroLinea() != null && Lec.getSeparador() != null && Lec.getValorConstante() != null){
                    listaArchivo.add(new EstructuraArchivoEncabezado(Lec.getNumeroLinea(),Lec.getValorConstante(),Lec.getSeparador(),Lec.getCampo()));
                //}
            
            }
            
           }
        return listaArchivo;        
}
    
    
    
        public ArrayList<EstructuraError> ErroresSintactico(ArrayList<EstructuraEncabezado> TabSim, ArrayList<EstructuraArchivoEncabezado> Lectura) throws IOException{
        //DECLARO MIS ITERADORES
         Iterator<EstructuraEncabezado> it = TabSim.iterator();
         Iterator<EstructuraArchivoEncabezado> it2 = Lectura.iterator();
         //INSTANCIO LISTA ARCHIVO
         listaError = new ArrayList<>();
         //INICIO EL CICLO PARA RECORRER LAS LISTAS 
           while (it.hasNext() && it2.hasNext()) { 
            EstructuraEncabezado Tab =  (EstructuraEncabezado) it.next();
            EstructuraArchivoEncabezado Lec = (EstructuraArchivoEncabezado) it2.next();
            //SI EL CAMPO OBLIGATORIO ES IGUAL A TRUE 
            if (Tab.getCampoObligatorio().equals("True")){
                //SI EL CAMPO OBLIGATORIO NO ES NULL
                if (Lec.getCampo() != null && (Tab.getExpresionRegular() != null && !Tab.getExpresionRegular().isEmpty())){
		Pattern patron =  Pattern.compile(Tab.getExpresionRegular()); //Pattern.compile("([0-9]{2})/([0-9]{2})/([0-9]{4})");
                Matcher emparejador = patron.matcher(Lec.getCampo());
                //COMPRUEBO SI COINCIDEN LOS VALORES CON LAS EXPRESIONES REGULARES
			//boolean esCoincidente = emparejador.find();
                    boolean esCoincidente = Lec.getCampo().matches(Tab.getExpresionRegular());
			if (esCoincidente) {
                           
				///System.out.println("Expresion Reconocida en Linea No.: "+ Lec.getNumeroLinea()+" Campo es: " + Lec.getCampo());
                          }else{
                            //	System.out.println("No se reconoce la linea No.: "+ Lec.getNumeroLinea()+ " Expresion es: "+ Tab.getExpresionRegular()+" Campo es: " + Lec.getCampo());
                             listaError.add(new EstructuraError(Lec.getNumeroLinea(),"SINTACTICO","El campo ingresado no cumple con la estructura de la expresion regular","Ingrese los valores correctos solicitados en tabla de simbolos"));
                        }           
                }
            }
            
           }
        return listaError;        
}
}
