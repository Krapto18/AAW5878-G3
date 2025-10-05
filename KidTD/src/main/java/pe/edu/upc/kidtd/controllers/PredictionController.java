package pe.edu.upc.kidtd.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.kidtd.dtos.PrediccionPromedioDTO;
import pe.edu.upc.kidtd.dtos.PredictionDTO;
import pe.edu.upc.kidtd.entities.Prediction;
import pe.edu.upc.kidtd.servicesinterfaces.IPredictionService;

import java.util.ArrayList;
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
    @GetMapping("/query1")
    public ResponseEntity<?> totalSoftware() {
        List<PrediccionPromedioDTO> qDto = new ArrayList<>();
        List<String[]> lic = predictionService.PrediccionPromedio();

        if (lic.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay data");
        }

        for (String[] columna:lic) {

            PrediccionPromedioDTO dto = new PrediccionPromedioDTO();
            dto.setMes(columna[0]);
            dto.setTotalPredicciones(Integer.parseInt(columna[1]));
            dto.setScorePromedioMensual(Double.parseDouble(columna[2]));
            qDto.add(dto);
        }
        return ResponseEntity.ok(qDto);
    }
}
