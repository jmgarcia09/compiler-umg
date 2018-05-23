/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.error;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Obed
 */
public class Log{    

    public void llenarLog(String TipoAnaisis,String Mensaje) throws IOException{
        

BufferedWriter bw = null;
    FileWriter fw = null;
    
         SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy");
        SimpleDateFormat sdfH = new SimpleDateFormat("hh:mm:ss");
    String fechaCadena =  sdf.format(new Date());
    String horaCadena = sdfH.format(new Date());

    try {
        String data = "\r\n"+ horaCadena+"-"+ TipoAnaisis +"-"+ Mensaje;
        File file = new File("LOG"+ fechaCadena +".txt");
        // Si el archivo no existe, se crea!
        if (!file.exists()) {
            file.createNewFile();
        }
        // flag true, indica adjuntar información al archivo.
        fw = new FileWriter(file.getAbsoluteFile(), true);
        bw = new BufferedWriter(fw);
        bw.write(data);
        //System.out.println("información agregada!");
    } catch (IOException e) {
    } finally {
        try {
                        //Cierra instancias de FileWriter y BufferedWriter
            if (bw != null)
                bw.close();
            if (fw != null)
                fw.close();
        } catch (IOException ex) {
        }
    }
    }
    }
   