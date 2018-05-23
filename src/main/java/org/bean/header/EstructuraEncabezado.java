/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bean.header;

/**
 *
 * @author WorkStation_Pro
 */
public class EstructuraEncabezado {
    //PROPIEDADES
    private String numeroLinea;
    private String valorConstante;
    private String separador;
    private String tipoDato;
    private String expresionRegular;
    private String campoObligatorio;
//SETTER Y GETTER
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

    public String getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(String tipoDato) {
        this.tipoDato = tipoDato;
    }

    public String getExpresionRegular() {
        return expresionRegular;
    }

    public void setExpresionRegular(String expresionRegular) {
        this.expresionRegular = expresionRegular;
    }

    public String getCampoObligatorio() {
        return campoObligatorio;
    }

    public void setCampoObligatorio(String campoObligatorio) {
        this.campoObligatorio = campoObligatorio;
    }

    

    
    //CONSTRUCTORES
    public EstructuraEncabezado() {
        this.numeroLinea = "";
        this.campoObligatorio = "";
        this.valorConstante = "";
        this.separador = "";
        this.tipoDato = "";
        this.expresionRegular = "";        
    }   
    
    public EstructuraEncabezado(String numeroLinea, String campoObligatorio,String valorConstante, String separador, String tipoDato, String expresionRegular) {
        this.numeroLinea = numeroLinea;
        this.campoObligatorio = campoObligatorio;
        this.valorConstante = valorConstante;
        this.separador = separador;
        this.tipoDato = tipoDato;
        this.expresionRegular = expresionRegular;        
    }
    
    
}
