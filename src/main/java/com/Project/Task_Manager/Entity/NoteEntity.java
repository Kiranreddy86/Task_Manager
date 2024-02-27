package com.Project.Task_Manager.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "notes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String title;
    @Column
    private String body;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    private TaskEntity taskEntity;
}
