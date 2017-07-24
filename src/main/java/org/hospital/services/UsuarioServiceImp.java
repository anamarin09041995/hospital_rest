/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hospital.services;

import java.util.ArrayList;
import java.util.List;
import org.hospital.models.Cita;
import org.hospital.models.Usuario;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ana Marin
 */
@Service 
public class UsuarioServiceImp implements UsuarioService{

    private static List<Usuario> data = new ArrayList<>();
    
    @Override
    public void insert(Usuario usuario) {
       usuario.setId(System.currentTimeMillis());
       data.add(usuario);
    }
    
}
