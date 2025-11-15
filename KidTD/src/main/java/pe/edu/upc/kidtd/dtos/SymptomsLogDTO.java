package pe.edu.upc.kidtd.dtos;

import pe.edu.upc.kidtd.entities.User;

import java.time.LocalDate;

public class SymptomsLogDTO {

    private int logId;
    private UsersDTO user;
    private String moodEntry;
    private String symptomNotes;
    private LocalDate logDate;

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public UsersDTO getUser() {
        return user;
    }

    public void setUser(UsersDTO user) {
        this.user = user;
    }

    public String getMoodEntry() {
        return moodEntry;
    }

    public void setMoodEntry(String moodEntry) {
        this.moodEntry = moodEntry;
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
