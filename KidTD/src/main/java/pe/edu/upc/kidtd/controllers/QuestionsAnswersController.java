package pe.edu.upc.kidtd.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.kidtd.dtos.QuestionsAnswersDTO;
import pe.edu.upc.kidtd.entities.QuestionsAnswers;
import pe.edu.upc.kidtd.servicesinterfaces.IQuestionsAnswersService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/QuestionsAnswers")
public class QuestionsAnswersController {
    @Autowired
    private IQuestionsAnswersService qaS;

    @GetMapping
    public List<QuestionsAnswersDTO> listQuestionsAnswers() {
        return qaS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, QuestionsAnswersDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertQuestionsAnswers(@RequestBody QuestionsAnswersDTO qa) {
        ModelMapper m = new ModelMapper();
        QuestionsAnswers questionsAnswers = m.map(qa, QuestionsAnswers.class);
        qaS.insert(questionsAnswers);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteQuestionsAnswers(@PathVariable("id") Integer id){
        QuestionsAnswers qa = qaS.findById(id);
        if (qa == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un registro con el ID: " + id);
        }
        qaS.delete(id);
        return ResponseEntity.ok("Respuesta con el ID: " + id + " eliminado correctamente");
    }
}
