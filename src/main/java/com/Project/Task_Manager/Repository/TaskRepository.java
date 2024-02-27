package com.Project.Task_Manager.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Project.Task_Manager.Entity.TaskEntity;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity,Integer> {

}
