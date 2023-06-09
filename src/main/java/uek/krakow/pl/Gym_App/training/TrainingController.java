package uek.krakow.pl.Gym_App.training;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uek.krakow.pl.Gym_App.config.JwtService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/trainings")
@RequiredArgsConstructor
public class TrainingController {

    private final TrainingService trainingService;

    private final JwtService jwtService;

    @GetMapping
    public ResponseEntity<List<TrainingResponse>> getAllTrainings(@RequestHeader("Authorization") String jwt) {
        String userEmail = jwtService.extractUserEmailFromToken(jwt.replace("Bearer ", ""));
        return new ResponseEntity<>(trainingService.getAllTrainingsByUserEmail(userEmail), HttpStatus.OK);
    }

    @GetMapping("/{trainingId}")
    public ResponseEntity<TrainingResponse> getTrainingById(@PathVariable("trainingId") Integer trainingId) {
        return new ResponseEntity<>(trainingService.getTrainingById(trainingId), HttpStatus.OK);
    }

    @GetMapping("/exercise/{exerciseId}")//not tested
    public ResponseEntity<List<TrainingResponse>> getTrainingsByExercise(@PathVariable("exerciseId") Integer exerciseId) {
        return new ResponseEntity<>(trainingService.getTrainingsByExercise(exerciseId), HttpStatus.OK);
    }

    @PutMapping("/{trainingId}")
    public ResponseEntity<Integer> updateExercise(@PathVariable("trainingId") Integer trainingId, @RequestBody TrainingRequest request) {
        return new ResponseEntity<>(trainingService.updateTrainingById(trainingId, request), HttpStatus.OK);
    }

    @DeleteMapping("/{trainingId}")
    public ResponseEntity<?> removeTrainingById(@PathVariable("trainingId") Integer trainingId) {
        trainingService.removeById(trainingId);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Integer> saveTraining(@RequestHeader("Authorization") String jwt, @RequestBody TrainingRequest request) {
        String userEmail = jwtService.extractUserEmailFromToken(jwt.replace("Bearer ", ""));
        return new ResponseEntity<>(trainingService.addNewTraining(userEmail, request), HttpStatus.OK);
    }
}
