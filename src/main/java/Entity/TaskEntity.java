package Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    int id;
    @Column
    String title;
    @Column
    String description;
    @Column
    Date deadline;
    @Column
    boolean completed;
    @OneToMany(mappedBy = "taskEntity",cascade = CascadeType.ALL)
    List<NoteEntity> noteEntity=new ArrayList<NoteEntity>();
}
