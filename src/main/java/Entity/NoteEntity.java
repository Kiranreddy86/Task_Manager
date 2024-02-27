package Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "notes")
@Data
public class NoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    private String title;
    @Column
    private String body;
    @ManyToOne
    @JoinColumn(name = "task_id")
    private TaskEntity taskEntity;
}
