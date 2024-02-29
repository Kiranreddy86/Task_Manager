package com.Project.Task_Manager.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Project.Task_Manager.Entity.TaskEntity;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity,Integer> {
    @Query(value = "SELECT * FROM tasks WHERE user_id= :userId and deadline = :currentDate", nativeQuery = true)
    List<TaskEntity> findTasksByCurrentDate(@Param("userId") int userId, @Param("currentDate") LocalDate currentDate);
    @Query(value = "SELECT * FROM tasks WHERE user_id = :userId", nativeQuery = true)
    List<TaskEntity> findAllById(@Param("userId") int userId);

    @Query(value = "SELECT * FROM tasks WHERE id= :taskId and user_id = :userId", nativeQuery = true)
    TaskEntity getTaskById(@Param("userId") int userId,@Param("taskId") int task_id);
}
