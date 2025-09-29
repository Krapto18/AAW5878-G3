package pe.edu.upc.kidtd.dtos;

import jakarta.persistence.*;
import pe.edu.upc.kidtd.entities.Roles;

import javax.management.relation.Role;
import java.time.LocalDate;
import java.util.List;

public class UsersDTO {
    private int userId;
    private String username;
    private String email;
    private String passwordHash;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private Boolean enabled;
    private String role;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role.getRole_name();
    }
}
