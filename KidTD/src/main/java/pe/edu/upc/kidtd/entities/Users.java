package pe.edu.upc.kidtd.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int User_id;

    @Column(name = "Username", nullable = false, length = 30)
    private String Username;

    @Column(name = "Email", nullable = false, length = 50)
    private String Email;

    @Column(name = "Password_hash", nullable = false, length = 30)
    private String Password_hash;

    @Column(name = "Created_at", nullable = false)
    private LocalDate Created_at;

    @Column(name = "Updated_at", nullable = false)
    private LocalDate Updated_at;

    public Users() {

    }

    public Users(int User_id, String Username,String Email ,LocalDate Created_at, LocalDate Updated_at) {
        this.User_id = User_id;
        this.Username = Username;
        this.Email = Email;
        this.Created_at = Created_at;
        this.Updated_at = Updated_at;
    }


    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int user_id) {
        User_id = user_id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword_hash() {
        return Password_hash;
    }

    public void setPassword_hash(String password_hash) {
        Password_hash = password_hash;
    }

    public LocalDate getCreated_at() {
        return Created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        Created_at = created_at;
    }

    public LocalDate getUpdated_at() {
        return Updated_at;
    }

    public void setUpdated_at(LocalDate updated_at) {
        Updated_at = updated_at;
    }
}
