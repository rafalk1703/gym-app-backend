package uek.krakow.pl.Gym_App.exercise.exercisetype;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/exerciseTypes")
@RequiredArgsConstructor
public class ExerciseTypeController {

    private final ExerciseTypeService exerciseTypeService;

    @GetMapping
    public ResponseEntity<List<ExerciseTypeResponse>> getAllExerciseTypesById() {
        return new ResponseEntity<>(exerciseTypeService.getAllExerciseTypes(), HttpStatus.OK);
    }

    @GetMapping("/{exerciseTypeId}")
    public ResponseEntity<ExerciseTypeResponse> getAllExerciseTypesById(@PathVariable("exerciseTypeId") Integer exerciseTypeId) {
        return new ResponseEntity<>(exerciseTypeService.getExerciseTypeById(exerciseTypeId), HttpStatus.OK);
    }

    @DeleteMapping("/{exerciseTypeId}")
    public ResponseEntity<?> removeExerciseTypesById(@PathVariable("exerciseTypeId") Integer exerciseTypeId) {
        exerciseTypeService.removeExerciseTypeById(exerciseTypeId);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<ExerciseTypeResponse> saveExerciseType(@RequestBody  ExerciseTypeRequest request) {
        return new ResponseEntity<>(exerciseTypeService.saveExerciseType(request), HttpStatus.OK);
    }


}
