package com.compiler.manager;


import com.compiler.bean.CompilerResponse;
import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import org.apache.el.parser.SimpleCharStream;
import org.apache.tomcat.util.bcel.classfile.ConstantUtf8;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.bean.detail.EstructuraDetalle;
import org.bean.header.EstructuraArchivoEncabezado;
import org.bean.header.EstructuraEncabezado;
import org.bean.header.TablaSimbolosEncabezado;
import org.error.EstructuraError;
import org.manager.AnalizadorLexico;
import org.manager.AnalizadorSintactico;
import org.manager.LecturaTokensEncabezado1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CompilerManager {
    private Logger logger = LoggerFactory.getLogger(CompilerManager.class);


    public CompilerResponse readFile(MultipartFile file) {
        CompilerResponse response = new CompilerResponse();
        response.setSyntacticSuccess(false);
        response.setLexiconSuccess(false);
        response.setSemanticSuccess(false);
        try {

            if(file.getSize() <= 0){
                throw new RuntimeException("El archivo esta vacio.");
            }

            String result = CharStreams.toString(new InputStreamReader(
                    file.getInputStream(), Charsets.UTF_8));
            if(!result.startsWith("</ INICIO >")){
                throw new RuntimeException("El archivo no es valido.");
            }

            TablaSimbolosEncabezado tablaSimbolos = new TablaSimbolosEncabezado();
            ArrayList<EstructuraEncabezado> TabSimEnc1 = tablaSimbolos.RetornaTablaSimbEnc1();
            if (!TabSimEnc1.isEmpty()) {
                System.out.println("La Tabla Simbolos de Encabezado #1 se cargo Exitosamente!!");

            } else {
                System.out.println("La Tabla Simbolos de Encabezado #1 no se cargo.......");
            }

            ArrayList<EstructuraEncabezado> encabezado2 = tablaSimbolos.RetornaTablaSimbEnc2();
            if (!encabezado2.isEmpty()) {
                System.out.println("La Tabla Simbolos de Encabezado #2 se cargo Exitosamente!!");
            } else {
                System.out.println("La Tabla Simbolos de Encabezado #2 no se cargo........");

            }

            //LLENADO DE LA SEGUNDA TABLA DE SIMBOLOS
            ArrayList<EstructuraEncabezado> encabezado3 = tablaSimbolos.RetornaTablaSimbEnc3();
            if (!encabezado3.isEmpty()) {
                System.out.println("La Tabla Simbolos de Encabezado #3 se cargo Exitosamente!!");
            } else {
                System.out.println("La Tabla Simbolos de Encabezado #3 no se cargo........");

            }


            //LLENADO DE LA TABLA DE SIMBOLOS DE DETALLE DE FACTURA
            EstructuraDetalle estruc = new EstructuraDetalle();
            estruc.RetornaTablaEnc1();


            //INSTANCIO AL ANALIZADOR LEXICO
            AnalizadorLexico al = new AnalizadorLexico();
            //INSTANCIO LA LECTURA DEL ARCHIVO
            LecturaTokensEncabezado1 TEnc1 = new LecturaTokensEncabezado1();
            //LLENA CON LO QUE REOTRNA EL ANALIZADOR LEXICO
            ArrayList<EstructuraArchivoEncabezado> devolucionLexico = al.ComparaEncabezado_1(TabSimEnc1, TEnc1.TokensEnc1(file));
            //LLENA CON ERRORES QUE RETORNA EL ANALIZADOR LEXICO
            ArrayList<EstructuraError> listaErrores = al.RetornarErores(TabSimEnc1, TEnc1.TokensEnc1(file));
            //INICIO LA INSTANCIA DEL ANALIZADOR SINTACTICO
            AnalizadorSintactico objSintac = new AnalizadorSintactico();
            //LLENO LA LISTA DEVOLUCIONSINTACTICO CON LO QUE COMPARE EL ANALIZADOR SINTACTICO
            ArrayList<EstructuraArchivoEncabezado> devolucionSsintactico = objSintac.ComparaSintactico(TabSimEnc1, devolucionLexico);
            //AGREGO A LA LISTA DE ERRORES LOS ERRORES QUE PROVOQUE EL ANALIZADOR SINTACTICO
            listaErrores.addAll(objSintac.ErroresSintactico(TabSimEnc1, devolucionLexico));

            List<String> syntacticList = listaErrores.stream()
                    .filter(estructuraError -> "SINTACTICO".equals(estructuraError.getAnalizador()))
                    .map(estructuraArchivoEncabezado -> estructuraArchivoEncabezado.generarDetalle()).collect(Collectors.toList());
            response.setSyntacticResult(syntacticList);
            List<String> lexiconlist = listaErrores.stream()
                    .filter(estructuraError -> "LEXICO".equals(estructuraError.getAnalizador()))
                    .map(estructuraError -> estructuraError.generarDetalle()).collect(Collectors.toList());
            response.setLexiconResult(lexiconlist);

            response.setSyntacticSuccess(syntacticList.size() <= 0);
            response.setLexiconSuccess(lexiconlist.size()<= 0);
            response.setSemanticSuccess(true);
            Map values = new HashMap();
            for (EstructuraArchivoEncabezado estructuraArchivoEncabezado : devolucionSsintactico) {
                if(estructuraArchivoEncabezado.getValorConstante() != null && estructuraArchivoEncabezado.getCampo() != null){
                    values.put(estructuraArchivoEncabezado.getValorConstante().trim().replace(" ",""),estructuraArchivoEncabezado.getCampo());
                }

            }
            response.setValues(values);


            Iterator<EstructuraArchivoEncabezado> listaSintactica = devolucionSsintactico.iterator();
            while (listaSintactica.hasNext()) {
                EstructuraArchivoEncabezado cp = (EstructuraArchivoEncabezado) listaSintactica.next();
                System.out.println(cp.getNumeroLinea() + " " + cp.getValorConstante() + " " + cp.getSeparador() + " " + cp.getCampo());
            }
            //SIRVE PARA RECORRER LA LISTA DE ERRORES QUE RETORNO EL ANALIZADOR LEXICO
            Iterator<EstructuraError> rit = listaErrores.iterator();
            while (rit.hasNext()) {
                EstructuraError cp = (EstructuraError) rit.next();
                System.out.println(cp.getNoLinea() + " " + cp.getAnalizador() + " " + cp.getDescripcionError() + " " + cp.getSolucion());
            }
        } catch (IOException e) {
            System.out.println("El error es: " + e);
        }

        return response;
    }

}
