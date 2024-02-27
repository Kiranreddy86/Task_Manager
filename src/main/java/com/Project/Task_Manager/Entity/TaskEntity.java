package com.Project.Task_Manager.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private String deadline;
    @Column
    private boolean completed;
    @OneToMany(mappedBy = "taskEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NoteEntity> notes=new ArrayList<>();

}
