package pl.projects.recrutio.service;

import org.springframework.stereotype.Service;
import pl.projects.recrutio.entity.Candidate;
import pl.projects.recrutio.repositories.CandidateRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {

    private final CandidateRepository candidateRepository;

    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public void save(Candidate candidate) {
        candidateRepository.save(candidate);
    }

    public Optional<Candidate> findById(Long id) {
        return candidateRepository.findById(id);
    }

    public List<Candidate> findAll() {
        return candidateRepository.findAll();
    }

    public void update(Candidate candidate) {
        candidateRepository.save(candidate);
    }

    public void deleteById(Long id) {
        candidateRepository.deleteById(id);
    }

    public List<Candidate> findByProjectId(long id){
        return candidateRepository.findAllCandidateByProjectId(id);
    }
}
