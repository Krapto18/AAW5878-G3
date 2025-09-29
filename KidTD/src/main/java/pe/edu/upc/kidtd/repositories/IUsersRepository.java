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


    @Query(value = "SELECT u.* \n" +
            "FROM public.\"user\" u inner join roles r \n" +
            "on u.role_id = r.role_id\n" +
            "WHERE r.role_name =:role_name",nativeQuery = true)
    public List<User> buscarXRol(@Param("role_name") String role);

}
