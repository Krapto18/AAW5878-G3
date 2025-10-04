package pe.edu.upc.kidtd.servicesinterfaces;

import pe.edu.upc.kidtd.entities.User;

import java.util.List;

public interface IUsersService {
    public List<User> list();
    public void insert(User user);
    public User listId(int id);;
    public void delete(int id);
    public void update(User user);
    public List<User> listByRole(String role);
    public List<User> ListarUsuarios();
}
