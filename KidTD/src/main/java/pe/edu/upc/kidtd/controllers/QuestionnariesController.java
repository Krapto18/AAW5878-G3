package pe.edu.upc.kidtd.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.kidtd.dtos.QuestionnariesDTO;
import pe.edu.upc.kidtd.entities.Questionnaries;
import pe.edu.upc.kidtd.servicesinterfaces.IQuestionnariesService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Questionnaries")
public class QuestionnariesController {

    @Autowired
    private IQuestionnariesService qS;

    @GetMapping
    public List<QuestionnariesDTO> listarQuestionnaries() {
        return qS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, QuestionnariesDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> BuscarCuestionario(@PathVariable("id") Integer id) {
        Questionnaries q = qS.listId(id);
        if (q == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un cuestionario con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        QuestionnariesDTO dto = m.map(q, QuestionnariesDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public void insertarCuestionario(@RequestBody QuestionnariesDTO q) {
        ModelMapper m = new ModelMapper();
        Questionnaries cuestionario = m.map(q, Questionnaries.class);
        qS.insert(cuestionario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCuestionario(@PathVariable("id") Integer id) {
        Questionnaries q = qS.listId(id);
        if (q == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un cuestionario con el ID: " + id);
        }
        qS.delete(id);
        return ResponseEntity.ok("Cuestionario con el ID " + id + " eliminado correctamente.");
    }

    @PutMapping
    public ResponseEntity<String> modificarCuestionario(@RequestBody QuestionnariesDTO q) {
        ModelMapper m = new ModelMapper();
        Questionnaries quest = m.map(q, Questionnaries.class);
        Questionnaries questionnarie = qS.listId(q.getQuestionnaire_id());
        if (questionnarie == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un cuestionario con el ID: " + q.getQuestionnaire_id());
        }
        qS.update(quest);
        return ResponseEntity.ok("Cuestionario con el ID " + q.getQuestionnaire_id() + " modificado correctamente.");
    }


}
