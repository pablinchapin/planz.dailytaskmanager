/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.planz.dailytaskmanager.controller;

import com.pablinchapin.planz.dailytaskmanager.service.TaskService;
import com.pablinchapin.planz.dailytaskmanager.service.TaskServiceDTO;
import java.util.List;
import javax.security.auth.message.callback.PrivateKeyCallback;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pvargas
 */
@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    
    @Autowired
    private TaskService service;
    
    @RequestMapping(method = RequestMethod.GET)
    public List findAll(){
        return service.findAll();
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public TaskServiceDTO create(@Valid @RequestBody TaskServiceDTO dto){
        return service.create(dto);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public TaskServiceDTO update(@PathVariable Long id, @Valid @RequestBody TaskServiceDTO dto){
        return service.update(id, dto);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
    
}