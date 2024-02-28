package com.Project.Task_Manager.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private LocalDate created_At = LocalDate.now();
    @Column
    private boolean completed=false;
    @Column
    private LocalDate deadline;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    private List<NoteEntity> noteEntity=new ArrayList<>();

}
