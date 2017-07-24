/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hospital.services;

import java.util.ArrayList;
import java.util.List;
import org.hospital.models.Medico;
import org.hospital.models.Usuario;

/**
 *
 * @author Ana Marin
 */
public class MedicoServiceImp implements MedicoService {
    
    private static List<Medico> data = new ArrayList<>();

    @Override
    public void insert(Medico medico) {
        medico.setId(System.currentTimeMillis());
        data.add(medico);
    }

    @Override
    public boolean update(Medico medico) {
        boolean success = false;
        int index = 0;
        for(Medico m: data){
            if(m.getId().equals(medico.getId())){
                data.set(index, medico);
                success = true;
                break;
            }index++;
        }return success;
    }

    @Override
    public Medico getById(Long id) {
        Medico medico = null;
        int index = 0;
        for(Medico m : data){
            if(m.getId().equals(id)){
                m = medico;
                break;
            }index++;
        }
        
        return medico;
    }

    @Override
    public List<Medico> all() {
        return data;
    }
    
}
