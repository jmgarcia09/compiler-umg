/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bean.header;

/**
 *
 * @author Obed
 */
public class EstructuraArchivoEncabezado {
    private String numeroLinea;
    private String valorConstante;
    private String separador;
    private String campo;

    public String getNumeroLinea() {
        return numeroLinea;
    }

    public void setNumeroLinea(String numeroLinea) {
        this.numeroLinea = numeroLinea;
    }

    public String getValorConstante() {
        return valorConstante;
    }

    public void setValorConstante(String valorConstante) {
        this.valorConstante = valorConstante;
    }

    public String getSeparador() {
        return separador;
    }

    public void setSeparador(String separador) {
        this.separador = separador;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public EstructuraArchivoEncabezado() {
    }

    public String generarDetalle(){
        return "Error en linea " + numeroLinea + " - " + campo + " - " + campo;
    }

    public EstructuraArchivoEncabezado(String numeroLinea, String valorConstante, String separador, String campo) {
        this.numeroLinea = numeroLinea;
        this.valorConstante = valorConstante;
        this.separador = separador;
        this.campo = campo;
    }
    
    
   
    
    
}
