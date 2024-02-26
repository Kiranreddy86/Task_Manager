package Repository;

import Entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<NoteEntity,Integer> {
//    @Query("select n from notes n")
//    List<NoteEntity> findAllBy();
}
