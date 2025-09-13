package pe.edu.upc.kidtd.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.kidtd.dtos.GoalDTO;
import pe.edu.upc.kidtd.dtos.PredictionDTO;
import pe.edu.upc.kidtd.entities.Goal;
import pe.edu.upc.kidtd.entities.Prediction;
import pe.edu.upc.kidtd.servicesinterfaces.IPredictionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Prediction")
public class PredictionController {
    @Autowired
    private IPredictionService predictionService;
    @GetMapping
    public List<PredictionDTO> listPredictions() {
        return predictionService.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, PredictionDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertPrediction(@RequestBody PredictionDTO predictionDTO){
        ModelMapper m = new ModelMapper();
        Prediction prediction=m.map(predictionDTO, Prediction.class);
        predictionService.insert(prediction);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePrediction(@PathVariable("id") Integer id){
        Prediction prediction= predictionService.findById(id);
        if(prediction==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un registro con el ID: " + id);
        }
        predictionService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Registro eliminado ID: " + id);
    }
    @PutMapping
    public ResponseEntity<String> updatePrediction(@RequestBody PredictionDTO dto) {
        ModelMapper m = new ModelMapper();
        Prediction prediction = m.map(dto, Prediction.class);
        Prediction exist = predictionService.findById(prediction.getPredictionId());
        if (exist == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + prediction.getPredictionId());
        }
        predictionService.update(prediction);
        return ResponseEntity.ok("Registro con ID " + prediction.getPredictionId() + " modificado correctamente.");
    }
}
