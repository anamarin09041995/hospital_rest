/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hospital.rest;

import java.util.List;
import org.hospital.models.Cita;
import org.hospital.models.PostResponse;
import org.hospital.models.SimpleResponse;
import org.hospital.services.CitaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ana Marin
 */
@RestController
public class CitaApi {
    
    private CitaServiceImp citaServiceImp;

    
    @Autowired
    public CitaApi(CitaServiceImp citaServiceImp) {
        this.citaServiceImp = citaServiceImp;
    }
    
    /*
    @RequestMapping(path = "/citas/{id}"
            , method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Cita> getById(@PathVariable Long id){
        Cita cita = citaServiceImp.getById(id);
        if(cita == null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);        
        return new ResponseEntity(cita, HttpStatus.OK);
    }*/
    
    @RequestMapping(path = "/citas/{cedula}"
                    , method = RequestMethod.GET
                    , produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Cita> all(@PathVariable int cedula){
        List<Cita> cita = citaServiceImp.all(cedula);
        if(cita == null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity(cita, HttpStatus.OK);
    }
    
    @RequestMapping(path = "/citas"
                    ,method = RequestMethod.PUT
                    ,produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<SimpleResponse> update(@RequestBody Cita cita){
        boolean success = citaServiceImp.update(cita);
        return new ResponseEntity(new SimpleResponse(success), HttpStatus.OK);
    }
    
    @RequestMapping(path = "/citas/{id}"
                    , method = RequestMethod.DELETE
                    , produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<SimpleResponse> delete(@PathVariable Long id){
        boolean success = citaServiceImp.delete(id);
        return new ResponseEntity(new SimpleResponse(success), HttpStatus.OK);
    }
    
    @RequestMapping(path = "/citas"
                    , method = RequestMethod.POST
                    , produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<PostResponse> insert(@RequestBody Cita cita){
         citaServiceImp.insert(cita);
         return new ResponseEntity(new PostResponse(true, cita.getId()), HttpStatus.OK);
    }
    
}
