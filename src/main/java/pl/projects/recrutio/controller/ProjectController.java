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
public class ProjectController {

    private final ProjectService projectService;
    private final CandidateService candidateService;

    public ProjectController(ProjectService projectService, CandidateService candidateService) {
        this.projectService = projectService;
        this.candidateService = candidateService;
    }

    @GetMapping(path = "/project/add")
    String showAddForm(Model model) {
        Project project = new Project();
        model.addAttribute("project", project);
        return "project/add";
    }

    @PostMapping(path = "/project/add")
    String processAddForm(Project project) {
        projectService.save(project);
        return "redirect:/project/list";
    }

    @GetMapping(path = "/project/list")
    String showAll(Model model) {
        List<Project> projects = projectService.findAll();
        model.addAttribute("projects", projects);
        return "project/list";
    }

    @GetMapping(path = "/project/delete/{id}")
    public String deleteInstance(@PathVariable("id") long id, Model model) {
        Project project = projectService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid project Id:" + id));
        projectService.deleteById(id);
        return "redirect:/project/list";
    }

    @GetMapping("/project/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Project project = projectService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid project Id:" + id));

        model.addAttribute("project", project);
        return "project/update";
    }

    @PostMapping("/project/update/{id}")
    public String processUpdateForm(@PathVariable("id") long id, @Valid Project project, BindingResult result, Model model) {
        if (result.hasErrors()) {
            project.setId(id);
            return "project/update";
        }

        projectService.save(project);
        return "redirect:/project/list";
    }
}
