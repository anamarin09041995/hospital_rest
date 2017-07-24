/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hospital.services;

import java.util.List;
import org.hospital.models.Medico;

/**
 *
 * @author Ana Marin
 */
public interface MedicoService {
    void insert(Medico medico);
    boolean update(Medico medico);
    Medico getById(Long id);
    List<Medico> all();
    
}
