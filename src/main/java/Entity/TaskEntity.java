package Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private int id;
    @NonNull
    @Column
    private String title;
    @NonNull
    @Column
    private String description;
    @NonNull
    @Column
    private String deadline;
    @Column
    private boolean completed;
    @OneToMany(mappedBy = "taskEntity", cascade = CascadeType.ALL)
    private List<NoteEntity> noteEntity = new ArrayList<>();
}
