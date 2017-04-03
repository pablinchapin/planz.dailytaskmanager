/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.planz.dailytaskmanager.service;

import com.pablinchapin.planz.dailytaskmanager.model.Task;
import com.pablinchapin.planz.dailytaskmanager.repository.TaskRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pvargas
 */
@Service
public class TaskService {
    
    @Autowired
    private TaskRepository repository;
    
    
    public List<TaskServiceDTO> findAll(){
        return repository.findAll().stream()
                .map(entity -> new TaskServiceDTO(entity.getId(), entity.getDescription(), entity.isCompleted()))
                .collect(Collectors.toList());
    }
    
    
    @Transactional
    public TaskServiceDTO create(TaskServiceDTO taskServiceDTO){
        
        Task newTask = new Task();
        
        newTask.setDescription(taskServiceDTO.getDescription());
        newTask.setCompleted(taskServiceDTO.isCompleted());
        
        Task savedTask = repository.saveAndFlush(newTask);
        
        return new TaskServiceDTO(savedTask.getId(), savedTask.getDescription(), savedTask.isCompleted());
    }
    
    
    
    @Transactional
    public TaskServiceDTO update(Long id, TaskServiceDTO task){
        Task entity = findOneSafe(id);
        
        entity.setDescription(task.getDescription());
        entity.setCompleted(task.isCompleted());
        
        return new TaskServiceDTO(entity.getId(), entity.getDescription(), entity.isCompleted());
    }
    
    
    
    @Transactional
    public void delete(Long id){
        Task task = findOneSafe(id);
        repository.delete(task);
    }
    
    
    private Task findOneSafe(Long id){
        Task task = repository.findOne(id);
        if(task == null){
            throw new TaskNotFoundException();
        }else{
                return task;
        }
        
    }
}
