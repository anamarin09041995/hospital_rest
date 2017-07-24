/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hospital.models;

/**
 *
 * @author Ana Marin
 */
public class PostResponse extends SimpleResponse{
    
    private Long id;

    public PostResponse(boolean success, Long id) {
        super(success);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
}
