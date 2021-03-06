/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.planz.dailytaskmanager.service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author pvargas
 */
public class TaskServiceDTO {
    
    private Long id;
    @NotNull
    @Size(min = 1, max = 64)
    private String description;
    private boolean completed;
    
    public TaskServiceDTO(){}
    
    public TaskServiceDTO(Long id, String description, boolean completed){
        this.id = id;
        this.description = description;
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    
    
    
}
