package pe.edu.upc.kidtd.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "\"Roles\"")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int role_id;

    @Column(name = "role_name", nullable = false, length = 30)
    private String role_name;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private List<User> users;

    public Roles() {

    }

    public Roles(int role_id, String role_name, List<User> users) {
        this.role_id = role_id;
        this.role_name = role_name;
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}
