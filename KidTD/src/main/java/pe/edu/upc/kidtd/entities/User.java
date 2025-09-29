package pe.edu.upc.kidtd.entities;


import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "\"User\"",uniqueConstraints = {@UniqueConstraint(columnNames = {"role_id"})})
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "username", nullable = false, length = 30)
    private String username;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "passwordHash", nullable = false, length = 200)
    private String passwordHash;

    @Column(name = "createdAt", nullable = false)
    private LocalDate createdAt;

    @Column(name = "updatedAt", nullable = false)
    private LocalDate updatedAt;

    private Boolean enabled;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Roles role;

    public User() {

    }

    public User(int userId, String username, String passwordHash, String email, LocalDate createdAt, Boolean enabled, LocalDate updatedAt, Roles role) {
        this.userId = userId;
        this.username = username;
        this.passwordHash = passwordHash;
        this.email = email;
        this.createdAt = createdAt;
        this.enabled = enabled;
        this.updatedAt = updatedAt;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public int getUserId() {
        return userId;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }
}
