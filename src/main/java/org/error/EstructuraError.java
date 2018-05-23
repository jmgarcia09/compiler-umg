/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.error;

/**
 *
 * @author Obed
 */
public class EstructuraError {
    private String noLinea;
    private String analizador;
    private String descripcionError;
    private String solucion;

    public String getNoLinea() {
        return noLinea;
    }

    public void setNoLinea(String noLinea) {
        this.noLinea = noLinea;
    }

    public String getAnalizador() {
        return analizador;
    }

    public void setAnalizador(String analizador) {
        this.analizador = analizador;
    }

    public String getDescripcionError() {
        return descripcionError;
    }

    public void setDescripcionError(String descripcionError) {
        this.descripcionError = descripcionError;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    public EstructuraError() {
    }

    public String generarDetalle(){
        return "Error en linea " + (Integer.valueOf(noLinea) + 1) + " - " + descripcionError;
    }

    public EstructuraError(String noLinea, String analizador, String descripcionError, String solucion) {
        this.noLinea = noLinea;
        this.analizador = analizador;
        this.descripcionError = descripcionError;
        this.solucion = solucion;
    }
    
    
}
