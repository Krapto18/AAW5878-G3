package pe.edu.upc.kidtd.dtos;

import pe.edu.upc.kidtd.entities.User;

public class LinkedProfileDTO {

    private int linkId;
    private User tutor;
    private User child;
    private User professional;
    private Boolean status;

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
