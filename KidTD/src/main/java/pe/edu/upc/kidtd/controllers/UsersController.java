package pe.edu.upc.kidtd.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import pe.edu.upc.kidtd.dtos.*;
import pe.edu.upc.kidtd.entities.User;
import pe.edu.upc.kidtd.servicesinterfaces.IUsersService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Users")
public class UsersController {
    @Autowired
    private IUsersService uS;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<UsersDTO> listarUsuarios() {
        return uS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, UsersDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
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
    @PreAuthorize("hasAnyAuthority('ADMIN','PROFESIONAL','TUTOR')")
    public void insertarUsuario(@RequestBody UserPostDTO uDTO) {
        ModelMapper m = new ModelMapper();
        User user = m.map(uDTO, User.class);
        uS.insert(user);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> eliminarUsuario(@PathVariable("id") Integer uid) {
        User u = uS.listId(uid);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un usuario con el ID: " + uid);
        }
        uS.delete(uid);
        return ResponseEntity.ok("Usuario con el ID " + uid + " eliminado correctamente.");
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','PROFESIONAL','TUTOR')")
    public ResponseEntity<String> modificarUsuario(@RequestBody UsersDTO u) {
        ModelMapper m = new ModelMapper();
        User user = m.map(u, User.class);
        User usuario = uS.listId(u.getUserId());
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un usuario con el ID: " + u.getUserId());
        }
        uS.update(user);
        return ResponseEntity.ok("Usuario con el ID " + u.getUserId() + " modificado correctamente.");
    }

    @GetMapping("/RoleFilter")
    @PreAuthorize("hasAnyAuthority('ADMIN','PROFESIONAL')")
    public ResponseEntity<?> ListarNiños(@RequestParam String role_name) {
        List<User> users = uS.listByRole(role_name);

        if (users.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron usuarios con el rol: " + role_name);
        }

        List<UsersPerRolDTO> listaDTO = users.stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsersPerRolDTO.class);
        }).collect(Collectors.toList());

        return ResponseEntity.ok(listaDTO);
    }

    @GetMapping("/GoalsDuration")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> ListarGoalsDuration() {
        List<ActGoalDurationDTO> listaDTO = new ArrayList<>();
        List<String[]> fila = uS.activeGoalsDuration();

        if (fila.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron registros");
        }

        for (String[] columna:fila){
            ActGoalDurationDTO dto = new ActGoalDurationDTO();
            dto.setUserId(Integer.parseInt(columna[0]));
            dto.setTotal_metas_activas(Integer.parseInt(columna[1]));
            dto.setPromedio_duracion_dias(columna[2]);
            listaDTO.add(dto);
        }

        return ResponseEntity.ok(listaDTO);
    }

    @GetMapping("/GoalsCompleted")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> ListarGoalsCompleted() {
        List<CompletedGoalsDTO> listaDTO = new ArrayList<>();
        List<String[]> fila = uS.completedGoals();

        if(fila.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron registros");
        }

        for (String[] columna:fila) {
            CompletedGoalsDTO dto = new CompletedGoalsDTO();
            dto.setUserId(Integer.parseInt(columna[0]));
            dto.setMetas_completadas(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }

        return ResponseEntity.ok(listaDTO);
    }
}
