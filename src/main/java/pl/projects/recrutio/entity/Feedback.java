package pl.projects.recrutio.entity;

import javax.persistence.*;

@Entity
@Table(name = "feedbacks")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String techSkills;
    private String softSkills;
    private String langSkills;
    private String other;
    private String admin;

    @ManyToOne
    private Candidate candidate;

    @ManyToOne
    private User user;

    public Feedback() {
    }

    public Feedback(Long id, String techSkills, String softSkills, String langSkills, String other, String admin, Candidate candidate, User user) {
        this.id = id;
        this.techSkills = techSkills;
        this.softSkills = softSkills;
        this.langSkills = langSkills;
        this.other = other;
        this.admin = admin;
        this.candidate = candidate;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTechSkills() {
        return techSkills;
    }

    public void setTechSkills(String techSkills) {
        this.techSkills = techSkills;
    }

    public String getSoftSkills() {
        return softSkills;
    }

    public void setSoftSkills(String softSkills) {
        this.softSkills = softSkills;
    }

    public String getLangSkills() {
        return langSkills;
    }

    public void setLangSkills(String langSkills) {
        this.langSkills = langSkills;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", techSkills='" + techSkills + '\'' +
                ", softSkills='" + softSkills + '\'' +
                ", langSkills='" + langSkills + '\'' +
                ", other='" + other + '\'' +
                ", admin='" + admin + '\'' +
                ", candidate=" + candidate +
                ", user=" + user +
                '}';
    }
}
