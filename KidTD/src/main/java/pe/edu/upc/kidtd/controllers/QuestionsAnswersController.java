package pe.edu.upc.kidtd.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.kidtd.dtos.QuestionsAnswersDTO;
import pe.edu.upc.kidtd.dtos.RespuestasAltoRiesgoDTO;
import pe.edu.upc.kidtd.entities.QuestionsAnswers;
import pe.edu.upc.kidtd.servicesinterfaces.IQuestionsAnswersService;

import java.util.ArrayList;
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

//    @GetMapping("/query2")
//    public ResponseEntity<?> RespuestasAltoRiesgo() {
//        List<RespuestasAltoRiesgoDTO> qDto = new ArrayList<>();
//        List<String[]> lic = qaS.PuntuacionRespuestasAltoRiesgo();
//
//        if (lic.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body("No hay data");
//        }
//
//        for (String[] columna:lic) {
//
//            RespuestasAltoRiesgoDTO dto = new RespuestasAltoRiesgoDTO();
//            dto.setQuestion_text(columna[0]);
//            dto.setAvg_respuesta_alto_riesgo(Double.parseDouble(columna[1]));
//            qDto.add(dto);
//        }
//        return ResponseEntity.ok(qDto);
//    }
}
