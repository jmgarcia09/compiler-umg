/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bean.detail;

/**
 *
 * @author Obed
 */
public class AbstracionEstructuraDetalle {
       //PROPIEDADES
    private String Campo;
    private String TipoDato;
    private String ExpR;
//SETTER Y GETTER

    public String getCampo() {
        return Campo;
    }

    public void setCampo(String Campo) {
        this.Campo = Campo;
    }

    public String getTipoDato() {
        return TipoDato;
    }

    public void setTipoDato(String TipoDato) {
        this.TipoDato = TipoDato;
    }

    public String getExpR() {
        return ExpR;
    }

    public void setExpR(String ExpR) {
        this.ExpR = ExpR;
    }
    
//CONSTRUCTORES

    public AbstracionEstructuraDetalle() {
    }

    public AbstracionEstructuraDetalle(String Campo, String TipoDato, String ExpR) {
        this.Campo = Campo;
        this.TipoDato = TipoDato;
        this.ExpR = ExpR;
    }
    
}
