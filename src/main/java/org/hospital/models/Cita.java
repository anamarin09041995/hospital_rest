/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hospital.models;

import java.util.Date;

/**
 *
 * @author Ana Marin
 */
public class Cita {
    Long id;
    String nombreP, nombreD,  diagnostico, foto;
    int cedulaP, cedulaD;
    Date hora, fecha;

    public Cita() {
    }

    public Cita(String nombreP, String nombreD, Date fecha, Date hora, String diagnostico, String foto, int cedulaP, int cedulaD) {
        this.nombreP = nombreP;
        this.nombreD = nombreD;
        this.fecha = fecha;
        this.hora = hora;
        this.diagnostico = diagnostico;
        this.foto = foto;
        this.cedulaP = cedulaP;
        this.cedulaD = cedulaD;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getNombreD() {
        return nombreD;
    }

    public void setNombreD(String nombreD) {
        this.nombreD = nombreD;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getCedulaP() {
        return cedulaP;
    }

    public void setCedulaP(int cedulaP) {
        this.cedulaP = cedulaP;
    }
    
     public int getCedulaD() {
        return cedulaD;
    }

    public void setCedulaD(int cedulaD) {
        this.cedulaD = cedulaD;
    }
    
    
}
