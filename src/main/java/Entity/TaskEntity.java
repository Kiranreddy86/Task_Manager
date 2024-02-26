package Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;
    @Column
    String title;
    @Column
    String description;
    @Column
    Date deadline;
    @Column
    boolean completed;
    @OneToOne(mappedBy = "taskEntity",cascade = CascadeType.ALL)
    NoteEntity noteEntity;
}
