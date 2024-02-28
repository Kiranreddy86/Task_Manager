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
    private Date createdAt;
    @Column
    private boolean completed;
    @Column
    private Date deadline;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    private List<NoteEntity> noteEntity=new ArrayList<>();
}
