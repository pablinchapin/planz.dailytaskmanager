/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.planz.dailytaskmanager.repository;

import com.pablinchapin.planz.dailytaskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author pvargas
 */
public interface TaskRepository extends JpaRepository<Task, Long>{
    
}