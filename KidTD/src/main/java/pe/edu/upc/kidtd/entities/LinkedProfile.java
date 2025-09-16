package pe.edu.upc.kidtd.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "LinkedProfile")
public class LinkedProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int linkId;
    @OneToOne
    @JoinColumn(name = "tutorId")
    private User tutor;
    @JoinColumn(name="childId")
    @OneToOne
    private User child;
    @OneToOne
    @JoinColumn(name="professionalId")
    private User professional;
    @Column(name = "status", nullable = false)
    private Boolean status;

    public LinkedProfile(int linkId, User tutor, User child, User professional, Boolean status) {
        this.linkId = linkId;
        this.tutor = tutor;
        this.child = child;
        this.professional = professional;
        this.status = status;
    }
    public LinkedProfile() {}

    public int getLinkId() {
        return linkId;
    }

    public void setLinkId(int linkId) {
        this.linkId = linkId;
    }

    public User getTutor() {
        return tutor;
    }

    public void setTutor(User tutor) {
        this.tutor = tutor;
    }

    public User getChild() {
        return child;
    }

    public void setChild(User child) {
        this.child = child;
    }

    public User getProfessional() {
        return professional;
    }

    public void setProfessional(User professional) {
        this.professional = professional;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
