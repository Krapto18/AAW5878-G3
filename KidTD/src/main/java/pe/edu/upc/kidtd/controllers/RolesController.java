package pe.edu.upc.kidtd.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.kidtd.dtos.RolesDTO;
import pe.edu.upc.kidtd.dtos.RolesPostDTO;
import pe.edu.upc.kidtd.entities.Roles;
import pe.edu.upc.kidtd.servicesinterfaces.IRolesService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Roles")
public class RolesController {
    @Autowired
    private IRolesService rS;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<RolesPostDTO> listarRoles() {
        return rS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, RolesPostDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> BuscarRoles(@PathVariable("id") Integer id) {
        Roles r = rS.listId(id);
        if (r == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un rol con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        RolesDTO dto = m.map(r, RolesDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void insertarRol(@RequestBody RolesDTO r) {
        ModelMapper m = new ModelMapper();
        Roles rol = m.map(r, Roles.class);
        rS.insert(rol);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<String> eliminarRol(@PathVariable("id") Integer id) {
        Roles r = rS.listId(id);
        if (r == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un rol con el ID: " + id);
        }
        rS.delete(id);
        return ResponseEntity.ok("rol con el ID " + id + " eliminado correctamente.");
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> modificarRol(@RequestBody RolesDTO r) {
        ModelMapper m = new ModelMapper();
        Roles rol = m.map(r, Roles.class);
        Roles ro = rS.listId(r.getRoleId());
        if (ro == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un rol con el ID: " + r.getRoleId());
        }
        rS.update(rol);
        return ResponseEntity.ok("Rol con el ID " + r.getRoleId() + " modificado correctamente.");
    }
}
