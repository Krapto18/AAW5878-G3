package pe.edu.upc.kidtd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.kidtd.entities.SymptomsLog;

import java.util.List;

@Repository
public interface ISymptomsLogRepository extends JpaRepository<SymptomsLog,Integer> {
    @Query(value = "SELECT mood_entry, COUNT(log_id) AS total_entradas, " +
            "ROUND(COUNT(log_id) * 100.0 / (SELECT COUNT(*) FROM symptoms_log), 2) AS porcentaje " +
            "FROM symptoms_log GROUP BY mood_entry ORDER BY total_entradas DESC",nativeQuery = true)
    public List<String[]> CumplimientoDeRegistroDeSintomas();
}
