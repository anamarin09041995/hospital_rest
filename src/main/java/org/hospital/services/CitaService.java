/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hospital.services;

import java.util.List;
import org.hospital.models.Cita;

/**
 *
 * @author Ana Marin
 */
public interface CitaService {
    void insert(Cita cita);
    boolean update(Cita cita);
    boolean delete(Long id);
    Cita getById(Long id);
    List<Cita> all(int cedulaD);
}
