package pe.edu.upc.kidtd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.kidtd.entities.Goal;

import java.util.List;

@Repository
public interface IGoalRepository extends JpaRepository<Goal,Integer> {
    @Query(value = "SELECT status, COUNT(goal_id) AS total_metas, \n" +
            "ROUND(COUNT(goal_id) * 100.0 / (SELECT COUNT(*) FROM goal), 2) AS porcentaje FROM goal\n" +
            "GROUP BY status ORDER BY porcentaje DESC", nativeQuery = true)
    public List<String[]> CumplimientoMetas();

    @Query(value="SELECT ROUND(AVG(EXTRACT(EPOCH FROM (end_date - start_date))) / 86400, 2) AS dias_promedio_para_cerrar_meta \n" +
            "FROM goal WHERE status = False AND start_date IS NOT NULL AND end_date IS NOT NULL",nativeQuery = true)
    public double TiempoCumplimientoMetas();
}
