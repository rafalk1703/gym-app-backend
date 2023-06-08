package uek.krakow.pl.Gym_App.exercise;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uek.krakow.pl.Gym_App.auth.RegisterRequest;
import uek.krakow.pl.Gym_App.config.JwtService;
import uek.krakow.pl.Gym_App.training.TrainingListRequest;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/exercises")
@RequiredArgsConstructor
public class ExerciseController {

    private final ExerciseService exerciseService;

    private final JwtService jwtService;

    @GetMapping
    public ResponseEntity<List<ExerciseResponse>> getAllExercises(@RequestHeader("Authorization") String jwt) {
        String userEmail = jwtService.extractUserEmailFromToken(jwt.replace("Bearer ", ""));
        return new ResponseEntity<>(exerciseService.getAllExercisesByUserEmail(userEmail), HttpStatus.OK);
    }

    @GetMapping("/type/{typeId}")
    public ResponseEntity<List<ExerciseResponse>> getAllExercisesByType(@RequestHeader("Authorization") String jwt, @PathVariable("typeId") Integer typeId) {
        String userEmail = jwtService.extractUserEmailFromToken(jwt.replace("Bearer ", ""));
        return new ResponseEntity<>(exerciseService.getAllExercisesByUserEmailAndTypeId(userEmail, typeId), HttpStatus.OK);
    }

    @GetMapping("/training/{trainingId}")
    public ResponseEntity<List<ExerciseResponse>> getAllExercisesByTraining(@RequestHeader("Authorization") String jwt, @PathVariable("trainingId") Integer trainingId) {
        String userEmail = jwtService.extractUserEmailFromToken(jwt.replace("Bearer ", ""));
        return new ResponseEntity<>(exerciseService.getAllExercisesByUserEmailAndTrainingId(userEmail, trainingId), HttpStatus.OK);
    }


    @GetMapping("/{exerciseId}")
    public ResponseEntity<ExerciseResponse> getExerciseById(@PathVariable("exerciseId") Integer exerciseId) {
        return new ResponseEntity<>(exerciseService.getExerciseById(exerciseId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Integer> addExercise(@RequestHeader("Authorization") String jwt, @RequestBody ExerciseRequest request) {
        String userEmail = jwtService.extractUserEmailFromToken(jwt.replace("Bearer ", ""));

        return new ResponseEntity<>(exerciseService.addNewExercise(userEmail, request), HttpStatus.OK);
    }

    @PostMapping("/addToTrainings/exercise/{exerciseId}")
    public ResponseEntity<Void> addExerciseToTrainings(@PathVariable("exerciseId") Integer exerciseId, @RequestBody TrainingListRequest trainingIds) {
        exerciseService.addExerciseToTrainings(exerciseId, trainingIds);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{exerciseId}")
    public ResponseEntity<Integer> updateExercise(@PathVariable("exerciseId") Integer exerciseId, @RequestBody ExerciseRequest request) {
        return new ResponseEntity<>(exerciseService.updateExerciseById(exerciseId, request), HttpStatus.OK);
    }

    @DeleteMapping("/{exerciseId}")
    public ResponseEntity<Void> removeExercise(@PathVariable("exerciseId") Integer exerciseId) {
        exerciseService.removeById(exerciseId);
        return ResponseEntity.ok().build();
    }
}
