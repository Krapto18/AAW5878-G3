package pe.edu.upc.kidtd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.kidtd.entities.ProfessionalDiagnosis;

@Repository
public interface IProfessionalDiagnosisRepository extends JpaRepository<ProfessionalDiagnosis, Integer> {
}
