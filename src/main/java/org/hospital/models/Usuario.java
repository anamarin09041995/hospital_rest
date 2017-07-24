/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hospital.models;

/**
 *
 * @author Ana Marin
 */
public class Usuario {
    
    Long id;
    long cedulaU;
    String pass;

    public Usuario() {
    }

    public Usuario(int cedulaU, String pass) {
        this.cedulaU = cedulaU;
        this.pass = pass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getCedulaU() {
        return cedulaU;
    }

    public void setCedulaU(long cedulaU) {
        this.cedulaU = cedulaU;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
}
