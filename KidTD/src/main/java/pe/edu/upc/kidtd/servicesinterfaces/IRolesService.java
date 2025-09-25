package pe.edu.upc.kidtd.servicesinterfaces;

import pe.edu.upc.kidtd.entities.Roles;

import java.util.List;

public interface IRolesService {
    public List<Roles> list();
    public void insert(Roles role);

    public Roles listId(int id);
    public void delete(int id);
    public void update(Roles role);
}
