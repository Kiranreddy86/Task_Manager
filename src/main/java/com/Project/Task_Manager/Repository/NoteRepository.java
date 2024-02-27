package com.Project.Task_Manager.Repository;

import com.Project.Task_Manager.Entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<NoteEntity,Integer> {
    @Query(value = "select * from notes where task_id= :taskId",nativeQuery = true)
    List<NoteEntity> findNoteBytaskId(@Param("taskId") int taskId);
    @Modifying
    @Query(value = "DELETE FROM notes WHERE task_id = :taskId AND id = :noteId", nativeQuery = true)
    void deleteNoteByTaskId(@Param("taskId") int taskId, @Param("noteId") int noteId);
}
