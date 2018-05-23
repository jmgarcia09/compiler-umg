/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bean.tax;


/**
 *
 * @author WorkStation_Pro
 */
public class EstructuraImpuesto {
    //PROPIEDADES
    private int numeroLinea;
    private String valorConstante;
    private String separador;
    private String tipoDato;
    private String expresionRegular;
//SETTER Y GETTER
    public int getNumeroLinea() {
        return numeroLinea;
    }

    public void setNumeroLinea(int numeroLinea) {
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

    
    //CONSTRUCTORES
    public EstructuraImpuesto() {
    }   
    
    public EstructuraImpuesto(int numeroLinea, String valorConstante, String separador, String tipoDato, String expresionRegular) {
        this.numeroLinea = numeroLinea;
        this.valorConstante = valorConstante;
        this.separador = separador;
        this.tipoDato = tipoDato;
        this.expresionRegular = expresionRegular;
    }
    
    
}
