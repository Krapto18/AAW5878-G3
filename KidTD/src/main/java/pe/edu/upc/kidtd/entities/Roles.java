package pe.edu.upc.kidtd.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "\"Roles\"",uniqueConstraints = {@UniqueConstraint(columnNames = {"userId","role_name"})})
public class Roles implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;

    @Column(name = "role_name", nullable = false, length = 30)
    private String role_name;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;


    public Roles() {

    }

    public Roles(int roleId, String role_name, User user) {
        this.roleId = roleId;
        this.role_name = role_name;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}
