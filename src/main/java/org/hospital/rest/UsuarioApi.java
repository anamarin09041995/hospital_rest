/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hospital.rest;

import org.hospital.services.UsuarioServiceImp;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Ana Marin
 */
public class UsuarioApi {
    
    private UsuarioServiceImp usuarioServiceImp;
    
    @Autowired
    public UsuarioApi(UsuarioServiceImp usuarioServiceImp) {
        this.usuarioServiceImp = usuarioServiceImp;
    }
    
}
