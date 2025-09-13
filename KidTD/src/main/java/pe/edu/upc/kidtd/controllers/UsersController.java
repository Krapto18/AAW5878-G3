package pe.edu.upc.kidtd.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import pe.edu.upc.kidtd.dtos.UsersDTO;
import pe.edu.upc.kidtd.entities.User;
import pe.edu.upc.kidtd.servicesinterfaces.IUsersService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Users")
public class UsersController {
    @Autowired
    private IUsersService uS;

    @GetMapping
    public List<UsersDTO> listarUsuarios() {
        return uS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, UsersDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> PerfilDeUsuario(@PathVariable("id") Integer id) {
        User u = uS.listId(id);
        if (u == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un usuario con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        UsersDTO dto = m.map(u, UsersDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public void insertarUsuario(@RequestBody UsersDTO u) {
        ModelMapper m = new ModelMapper();
        User user = m.map(u, User.class);
        uS.insert(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable("id") Integer id) {
        User u = uS.listId(id);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un usuario con el ID: " + id);
        }
        uS.delete(id);
        return ResponseEntity.ok("Usuario con el ID " + id + " eliminado correctamente.");
    }

    @PutMapping
    public ResponseEntity<String> modificarUsuario(@RequestBody UsersDTO u) {
        ModelMapper m = new ModelMapper();
        User user = m.map(u, User.class);
        User usuario = uS.listId(u.getUser_id());
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un usuario con el ID: " + u.getUser_id());
        }
        uS.update(user);
        return ResponseEntity.ok("Usuario con el ID " + u.getUser_id() + " modificado correctamente.");
    }

}
