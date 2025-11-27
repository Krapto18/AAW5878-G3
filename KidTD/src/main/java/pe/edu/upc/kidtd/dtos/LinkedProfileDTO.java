package pe.edu.upc.kidtd.dtos;

import pe.edu.upc.kidtd.entities.User;

public class LinkedProfileDTO {

    private int linkId;
    private UsersDTO tutor;
    private UsersDTO child;
    private UsersDTO professional;
    private Boolean status;

    public int getLinkId() {
        return linkId;
    }

    public void setLinkId(int linkId) {
        this.linkId = linkId;
    }

    public UsersDTO getTutor() {
        return tutor;
    }

    public void setTutor(UsersDTO tutor) {
        this.tutor = tutor;
    }

    public UsersDTO getChild() {
        return child;
    }

    public void setChild(UsersDTO child) {
        this.child = child;
    }

    public UsersDTO getProfessional() {
        return professional;
    }

    public void setProfessional(UsersDTO professional) {
        this.professional = professional;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
