package pe.edu.upc.kidtd.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="Goal")
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int goalId;
    @ManyToOne
    @JoinColumn(name="userId")
    private User user;
    @Column(name = "goalDescription",nullable = false)
    private String goalDescription;
    @Column(name="startDate",nullable = false)
    private LocalDateTime startDate;
    @Column(name = "endDate",nullable = false)
    private LocalDateTime endDate;
    @Column(name = "status", nullable = false)
    private boolean status;

    public Goal(int goalId, User user, String goalDescription, LocalDateTime startDate, LocalDateTime endDate, boolean status) {
        this.goalId = goalId;
        this.user = user;
        this.goalDescription = goalDescription;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public Goal() {
    }

    public int getGoalId() {
        return goalId;
    }

    public void setGoalId(int goalId) {
        this.goalId = goalId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getGoalDescription() {
        return goalDescription;
    }

    public void setGoalDescription(String goalDescription) {
        this.goalDescription = goalDescription;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
