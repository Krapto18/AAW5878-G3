package pe.edu.upc.kidtd.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.kidtd.entities.Roles;
import pe.edu.upc.kidtd.repositories.IRolesRepository;
import pe.edu.upc.kidtd.servicesinterfaces.IRolesService;

import java.util.List;

@Service
public class RolesServiceImplement implements IRolesService {
    @Autowired
    private IRolesRepository rR;


    @Override
    public List<Roles> list() {
        return rR.findAll();
    }

    @Override
    public void insert(Roles role) {
        rR.save(role);
    }

    @Override
    public Roles listId(int id) {
        return rR.findById(id).orElse(null) ;
    }

    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }

    @Override
    public void update(Roles role) {
        rR.save(role);
    }
}
