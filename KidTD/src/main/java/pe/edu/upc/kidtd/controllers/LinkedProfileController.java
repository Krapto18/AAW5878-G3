package pe.edu.upc.kidtd.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.kidtd.dtos.GoalDTO;
import pe.edu.upc.kidtd.dtos.LinkedProfileDTO;
import pe.edu.upc.kidtd.entities.Goal;
import pe.edu.upc.kidtd.entities.LinkedProfile;
import pe.edu.upc.kidtd.servicesinterfaces.IGoalService;
import pe.edu.upc.kidtd.servicesinterfaces.ILinkedProfileService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/LinkedProfile")
public class LinkedProfileController {
    @Autowired
    private ILinkedProfileService lpS;
    @GetMapping
    public List<LinkedProfileDTO> listLinkedProfiles(){
        return lpS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, LinkedProfileDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertLinkedProfile(@RequestBody LinkedProfileDTO linkedProfileDTO){
        ModelMapper m = new ModelMapper();
        LinkedProfile linkedProfile=m.map(linkedProfileDTO, LinkedProfile.class);
        lpS.insert(linkedProfile);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteLinkedProfile(@PathVariable("id") Integer id){
        LinkedProfile linkedProfile= lpS.findById(id);
        if(linkedProfile==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un registro con el ID: " + id);
        }
        lpS.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Registro eliminado ID: " + id);
    }
    @PutMapping
    public ResponseEntity<String> updateLinkedProfile(@RequestBody GoalDTO dto) {
        ModelMapper m = new ModelMapper();
        LinkedProfile linkedProfile = m.map(dto, LinkedProfile.class);
        LinkedProfile exist = lpS.findById(linkedProfile.getLinkId());
        if (exist == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + linkedProfile.getLinkId());
        }
        lpS.update(linkedProfile);
        return ResponseEntity.ok("Registro con ID " + linkedProfile.getLinkId() + " modificado correctamente.");
    }
}
