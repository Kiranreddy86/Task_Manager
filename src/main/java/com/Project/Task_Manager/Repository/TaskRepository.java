package com.Project.Task_Manager.Repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Project.Task_Manager.Entity.TaskEntity;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity,Integer> {
    @Query(value = "SELECT * FROM tasks WHERE deadline = :currentDate", nativeQuery = true)
    List<TaskEntity> findTasksByCurrentDate(@Param("currentDate") LocalDate currentDate);
}
