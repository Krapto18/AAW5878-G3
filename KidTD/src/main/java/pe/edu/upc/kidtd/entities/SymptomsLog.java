package pe.edu.upc.kidtd.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name="SymptomsLog")
public class SymptomsLog {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int logId;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    @Column(name = "moodEntry", nullable = false, length = 50)
    private String moodEntry;
    @Column(name = "symptomNotes", nullable = false)
    private String symptomNotes;
    @Column(name = "logDate", nullable = false)
    private LocalDate logDate;

    public SymptomsLog() {
    }

    public SymptomsLog(int logId, User user, String moodEntry, String symptomNotes, LocalDate logDate) {
        this.logId = logId;
        this.user = user;
        this.moodEntry = moodEntry;
        this.symptomNotes = symptomNotes;
        this.logDate = logDate;
    }

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public String getMoodEntry() {
        return moodEntry;
    }

    public void setMoodEntry(String moodEntry) {
        this.moodEntry = moodEntry;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSymptomNotes() {
        return symptomNotes;
    }

    public void setSymptomNotes(String symptomNotes) {
        this.symptomNotes = symptomNotes;
    }

    public LocalDate getLogDate() {
        return logDate;
    }

    public void setLogDate(LocalDate logDate) {
        this.logDate = logDate;
    }
}
