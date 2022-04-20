package pl.projects.recrutio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.projects.recrutio.entity.Candidate;

import java.awt.print.Book;
import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

//    @Query("select c from Candidate c where c.project.id = ?1")
//    List<Candidate> findByProjectId(String id);

    List<Candidate> findAllCandidateByProjectId(long idProject);
}


