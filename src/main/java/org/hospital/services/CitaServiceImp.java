/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hospital.services;

import java.util.ArrayList;
import java.util.List;
import org.hospital.models.Cita;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ana Marin
 */
@Service
public class CitaServiceImp implements CitaService{

    private static List<Cita> data = new ArrayList<>();
    
    @Override
    public void insert(Cita cita) {
       cita.setId(System.currentTimeMillis());
       data.add(cita);
    }

    @Override
    public boolean update(Cita cita) {
        boolean success = false;
        int index = 0;
        for(Cita c : data){
            if(c.getId().equals(cita.getId())){
                data.set(index, cita);
                success = true;
                break;
            }index++;
        }
        
        return success;
    }

    @Override
    public boolean delete(Long id) {
        boolean success = false;
        int index = 0;
        for(Cita c : data){
            if(c.getId().equals(id)){
                data.remove(index);
                success = true;
                break;
            }index++;
        }
        
        return success;
    }

    @Override
    public Cita getById(Long id) {
        Cita cita = null;
        int index = 0;
        for(Cita c : data){
            if(c.getId().equals(id)){
                c = cita;
                break;
            }index++;
        }
        return cita;
    }

    @Override
    public List<Cita> all(long cedulaD) {
      
        List<Cita> citas = new ArrayList<>();
        int index = 0;
        
        for(Cita c: data){
         if(c.getCedulaD() == cedulaD){
             citas.add(c);
         }
        }
        return citas;
    }
      
}
