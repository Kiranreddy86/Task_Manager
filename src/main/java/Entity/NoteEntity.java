package Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "notes")
@Data
public class NoteEntity {
    @Column
    int id;
    @Column
    String Description;
}
