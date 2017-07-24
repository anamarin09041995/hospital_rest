/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hospital.rest;

import java.util.List;
import org.hospital.models.Medico;
import org.hospital.models.PostResponse;
import org.hospital.models.SimpleResponse;
import org.hospital.services.MedicoServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Ana Marin
 */
public class MedicoApi {
    
    private MedicoServiceImp medicoServiceImp;
    
    @RequestMapping(path = "/medicos"
                    , method = RequestMethod.POST
                    , produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<PostResponse> insert(@RequestBody Medico medico){
         medicoServiceImp.insert(medico);
         return new ResponseEntity(new PostResponse(true, medico.getId()), HttpStatus.OK);
    }
    
    @RequestMapping(path = "/medicos"
                    ,method = RequestMethod.PUT
                    ,produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<SimpleResponse> update(@RequestBody Medico medico){
        boolean success = medicoServiceImp.update(medico);
        return new ResponseEntity(new SimpleResponse(success), HttpStatus.OK);
    }
    
    @RequestMapping(path = "/medicos/{cedula}"
            , method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Medico> getById(@PathVariable long cedula){
        Medico medico = medicoServiceImp.getById(cedula);
        if(medico == null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);        
        return new ResponseEntity(medico, HttpStatus.OK);
    }
    
     @RequestMapping(
            path = "/medicos"
            , method= RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Medico>> all(){
        List<Medico> products = medicoServiceImp.all();
        return new ResponseEntity(products, HttpStatus.OK);
    }
    
}
