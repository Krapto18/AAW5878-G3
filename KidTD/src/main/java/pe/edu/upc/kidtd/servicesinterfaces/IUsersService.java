package pe.edu.upc.kidtd.servicesinterfaces;

import pe.edu.upc.kidtd.entities.Users;

import java.util.List;

public interface IUsersService {
    public List<Users> list();
    public void insert(Users user);

    public Users listId(int id);
    public void delete(int id);
    public void update(Users user);
}
