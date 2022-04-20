package pl.projects.recrutio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.projects.recrutio.entity.Candidate;
import pl.projects.recrutio.entity.Project;
import pl.projects.recrutio.service.CandidateService;
import pl.projects.recrutio.service.ProjectService;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@Controller
public class CandidateController {

    private CandidateService candidateService;
    private ProjectService projectService;

    public CandidateController(CandidateService candidateService, ProjectService projectService) {
        this.candidateService = candidateService;
        this.projectService = projectService;
    }

    @GetMapping(path = "/candidate/project/{id}")
    String showAll(@PathVariable("id") long id, Model model) {
        Project project = projectService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid project Id:" + id));
        model.addAttribute("project", project);

        List<Candidate> candidates = candidateService.findByProjectId(id);
        model.addAttribute("candidates", candidates);
        return "candidate/project-list";
    }

    @GetMapping(path = "/candidate/add")
    String showAddForm(Model model) {
        Candidate candidate = new Candidate();
        model.addAttribute("candidate", candidate);
        return "candidate/add";
    }

    @PostMapping(path = "/candidate/add")
    String processAddForm(Candidate candidate) {
        candidateService.save(candidate);
        return "redirect:/candidate/list";
    }

    @GetMapping(path = "/candidate/list")
    String showAll(Model model) {
        List<Candidate> candidates = candidateService.findAll();
        model.addAttribute("candidates", candidates);
        return "candidate/list";
    }

    @GetMapping(path = "/candidate/delete/{id}")
    public String deleteInstance(@PathVariable("id") long id, Model model) {
        Candidate candidate = candidateService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid candidate Id:" + id));
        candidateService.deleteById(id);
        return "redirect:/candidate/list";
    }

    @GetMapping("/candidate/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Candidate candidate = candidateService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid candidate Id:" + id));

        model.addAttribute("candidate", candidate);
        return "candidate/update";
    }

    @PostMapping("/candidate/update/{id}")
    public String processUpdateForm(@PathVariable("id") long id, @Valid Candidate candidate, BindingResult result, Model model) {
        if (result.hasErrors()) {
            candidate.setId(id);
            return "candidate/update";
        }

        candidateService.save(candidate);
        return "redirect:/candidate/list";
    }

    @ModelAttribute("projects")
    Collection<Project> findAllProjects() {
        return projectService.findAll();
    }

}
