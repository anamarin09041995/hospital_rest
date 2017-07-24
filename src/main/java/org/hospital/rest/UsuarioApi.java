/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hospital.rest;

import org.hospital.models.PostResponse;
import org.hospital.models.Usuario;
import org.hospital.services.UsuarioServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    
    @RequestMapping(path = "/usuarios"
                    , method = RequestMethod.POST
                    , produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<PostResponse> insert(@RequestBody Usuario usuario){
         usuarioServiceImp.insert(usuario);
         return new ResponseEntity(new PostResponse(true, usuario.getId()), HttpStatus.OK);
    }
    
    
}
