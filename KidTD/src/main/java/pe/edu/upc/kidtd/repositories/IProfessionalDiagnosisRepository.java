package pe.edu.upc.kidtd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.kidtd.entities.ProfessionalDiagnosis;

import java.util.List;

@Repository
public interface IProfessionalDiagnosisRepository extends JpaRepository<ProfessionalDiagnosis, Integer> {
    @Query(value = "SELECT COUNT(DISTINCT patient_id) AS pacientes_con_diagnostico_profesional, \n" +
            "(SELECT COUNT(DISTINCT user_id) FROM prediction) AS pacientes_con_prediccion \n" +
            "FROM professional_diagnosis;",nativeQuery = true)
    List<String[]> DiagnisticoProfesionalvsPrediccionSistema();
}
