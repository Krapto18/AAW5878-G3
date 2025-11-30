package pe.edu.upc.kidtd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.kidtd.entities.User;

import java.util.List;

@Repository
public interface IUsersRepository extends JpaRepository<User,Integer> {
    public User findOneByUsername(String username);
    @Query("select count(u.username) from User u where u.username =:username")
    public int buscarUsername(@Param("username") String nombre);

    @Query(value = "SELECT u.* ,r.role_name FROM public.\"user\" u inner join \n" +
            "roles r on u.user_id = r.user_id\n" +
            "ORDER BY user_id ASC ",nativeQuery = true)
    public List<User> ListarUsuarios();

    @Query(value = "SELECT u.* \n" +
            "FROM public.\"user\" u inner join roles r \n" +
            "on u.user_id = r.user_id\n" +
            "WHERE r.role_name =:role_name",nativeQuery = true)
    public List<User> buscarXRol(@Param("role_name") String role);

    @Query(value = "SELECT g.user_id,\n" +
            "       COUNT(*) AS total_metas_activas,\n" +
            "       AVG(end_date - start_date) AS promedio_duracion_dias\n" +
            "FROM goal g\n" +
            "WHERE g.status = true\n" +
            "GROUP BY g.user_id\n" +
            "ORDER BY total_metas_activas DESC;", nativeQuery = true)
    public List<String[]> activeGoalsDuration();

    @Query(value = "SELECT g.user_id,\n" +
    "               COUNT(*) AS metas_completadas_30dias\n" +
    "FROM goal g\n" +
    "WHERE g.status = true\n" +
    "AND g.end_date >= CURRENT_DATE - INTERVAL '30 days'\n" +
    "GROUP BY g.user_id;", nativeQuery = true)
    public List<String[]> completedGoals();
}
