package pe.edu.upc.kidtd.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.kidtd.entities.User;
import pe.edu.upc.kidtd.repositories.IUsersRepository;
import pe.edu.upc.kidtd.servicesinterfaces.IUsersService;

import java.util.List;

@Service
public class UsersServiceImplement implements IUsersService {
    @Autowired
    private IUsersRepository uR;

    @Override
    public List<User> list() {
        return uR.findAll();
    }

    @Override
    public void insert(User user) {
        uR.save(user);
    }

    @Override
    public User listId(int id) {
        return uR.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        uR.deleteById(id);
    }

    @Override
    public void update(User user) {
        uR.save(user);
    }
}
