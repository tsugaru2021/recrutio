package pl.projects.recrutio.service;

import org.springframework.stereotype.Service;
import pl.projects.recrutio.entity.Feedback;
import pl.projects.recrutio.repositories.FeedbackRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public void save(Feedback feedback) {
        feedbackRepository.save(feedback);
    }

    public Optional<Feedback> findById(Long id) {
        return feedbackRepository.findById(id);
    }

    public List<Feedback> findAll() {
        return feedbackRepository.findAll();
    }

    public void update(Feedback feedback) {
        feedbackRepository.save(feedback);
    }

    public void deleteById(Long id) {
        feedbackRepository.deleteById(id);
    }

}
