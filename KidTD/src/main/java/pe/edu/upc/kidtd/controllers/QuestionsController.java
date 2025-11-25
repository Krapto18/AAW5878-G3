package pe.edu.upc.kidtd.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.kidtd.dtos.QuestionsDTO;
import pe.edu.upc.kidtd.entities.Questions;
import pe.edu.upc.kidtd.servicesinterfaces.IQuestionsService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Questions")
public class QuestionsController {
    @Autowired
    private IQuestionsService qS;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','PROFESIONAL','TUTOR')")
    public List<QuestionsDTO> listQuestions() {
        return qS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, QuestionsDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
     @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void insertQuestions(@RequestBody QuestionsDTO q){
        ModelMapper m = new ModelMapper();
        Questions questions = m.map(q, Questions.class);
        qS.insert(questions);
    }

    @DeleteMapping("/{id}")
     @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<String> deleteQuestions(@PathVariable("id") Integer id){
        Questions q = qS.findById(id);
        if (q == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un registro con el ID: " + id);
        }
        qS.delete(id);
        return ResponseEntity.ok("Pregunta con el Id: " + id + " eliminado correctamente");
    }

    @PutMapping
     @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<String> updateQuestions(@RequestBody QuestionsDTO dto){
        ModelMapper m = new ModelMapper();
        Questions q = m.map(dto, Questions.class);
        Questions exist = qS.findById(q.getQuestion_id());
        if (exist == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se puede modificar. No existe un registro con el ID: " + q.getQuestion_id());
        }
        qS.update(q);
        return ResponseEntity.ok("Registro con ID " + q.getQuestion_id() + " modificado correctamente.");
    }
}
