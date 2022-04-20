package pl.projects.recrutio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.projects.recrutio.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
