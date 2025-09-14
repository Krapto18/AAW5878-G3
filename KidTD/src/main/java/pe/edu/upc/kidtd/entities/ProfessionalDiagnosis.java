package pe.edu.upc.kidtd.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ProfessionalDiagnosis")
public class ProfessionalDiagnosis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int diagnosisId;

    @ManyToOne
    @JoinColumn(name = "professionalId", nullable = false)
    private User professional;

    @ManyToOne
    @JoinColumn(name = "patientId", nullable = false)
    private User patient;

    @Column(name = "diagnosisText", nullable = false, columnDefinition = "TEXT")
    private String diagnosisText;

    @Column(name = "createdAt", nullable = false)
    private LocalDateTime createdAt;

    //Constructores
    public ProfessionalDiagnosis() {
    }

    public ProfessionalDiagnosis(int diagnosisId, User professional, User patient,
                                 String diagnosisText, LocalDateTime createdAt) {
        this.diagnosisId = diagnosisId;
        this.professional = professional;
        this.patient = patient;
        this.diagnosisText = diagnosisText;
        this.createdAt = createdAt;
    }

    // 🔹 Getters y setters
    public int getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(int diagnosisId) {
        this.diagnosisId = diagnosisId;
    }

    public User getProfessional() {
        return professional;
    }

    public void setProfessional(User professional) {
        this.professional = professional;
    }

    public User getPatient() {
        return patient;
    }

    public void setPatient(User patient) {
        this.patient = patient;
    }

    public String getDiagnosisText() {
        return diagnosisText;
    }

    public void setDiagnosisText(String diagnosisText) {
        this.diagnosisText = diagnosisText;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
