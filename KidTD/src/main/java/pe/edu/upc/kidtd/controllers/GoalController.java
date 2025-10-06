package pe.edu.upc.kidtd.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.kidtd.dtos.CumplimientoMetasDTO;
import pe.edu.upc.kidtd.dtos.GoalDTO;
import pe.edu.upc.kidtd.dtos.RespuestasAltoRiesgoDTO;
import pe.edu.upc.kidtd.dtos.SymptomsLogDTO;
import pe.edu.upc.kidtd.entities.Goal;
import pe.edu.upc.kidtd.entities.SymptomsLog;
import pe.edu.upc.kidtd.servicesinterfaces.IGoalService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Goal")
public class GoalController {
    @Autowired
    private IGoalService goalService;
    @GetMapping
    public List<GoalDTO> listGoals(){
        return goalService.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, GoalDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertGoal(@RequestBody GoalDTO goalDTO){
        ModelMapper m = new ModelMapper();
        Goal goal=m.map(goalDTO, Goal.class);
        goalService.insert(goal);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteGoal(@PathVariable("id") Integer id){
        Goal goal= goalService.findById(id);
        if(goal==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un registro con el ID: " + id);
        }
            goalService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Registro eliminado ID: " + id);
    }
    @PutMapping
    public ResponseEntity<String> updateGoal(@RequestBody GoalDTO dto) {
        ModelMapper m = new ModelMapper();
        Goal goal = m.map(dto, Goal.class);
        Goal exist = goalService.findById(goal.getGoalId());
        if (exist == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + goal.getGoalId());
        }
        goalService.update(goal);
        return ResponseEntity.ok("Registro con ID " + goal.getGoalId() + " modificado correctamente.");
    }
    @GetMapping("/query5")
    public ResponseEntity<?> CumplimientoMetas() {
        List<CumplimientoMetasDTO> qDto = new ArrayList<>();
        List<String[]> lic = goalService.CumplimientoMetas();

        if (lic.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay data");
        }

        for (String[] columna:lic) {

            CumplimientoMetasDTO dto = new CumplimientoMetasDTO();
            dto.setStatus(Boolean.parseBoolean(columna[0]));
            dto.setTotal_metas(Integer.parseInt(columna[1]));
            dto.setPorcentaje(Double.parseDouble(columna[2]));
            qDto.add(dto);
        }
        return ResponseEntity.ok(qDto);
    }
}
