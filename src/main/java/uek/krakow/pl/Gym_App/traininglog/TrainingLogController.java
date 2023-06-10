package uek.krakow.pl.Gym_App.traininglog;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uek.krakow.pl.Gym_App.config.JwtService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/trainingLogs")
@RequiredArgsConstructor
public class TrainingLogController {

    private final TrainingLogService trainingLogService;

    private final JwtService jwtService;

    @GetMapping
    public ResponseEntity<List<TrainingLogResponse>> getAllTrainingLogs(@RequestHeader("Authorization") String jwt) {
        String userEmail = jwtService.extractUserEmailFromToken(jwt.replace("Bearer ", ""));
        return new ResponseEntity<>(trainingLogService.getAllTrainingLogsByUserEmail(userEmail), HttpStatus.OK);
    }

    @GetMapping("/{trainingLogId}")
    public ResponseEntity<TrainingLogResponse> getTrainingById(@PathVariable("trainingLogId") Integer trainingLogId) {
        return new ResponseEntity<>(trainingLogService.getTrainingLogById(trainingLogId), HttpStatus.OK);
    }

    @GetMapping("/start/training/{trainingId}")
    public ResponseEntity<Integer> startTraining(@PathVariable("trainingId") Integer trainingId) {
        return new ResponseEntity<>(trainingLogService.startTraining(trainingId), HttpStatus.OK);
    }

    @GetMapping("/end/training/{trainingId}")
    public ResponseEntity<Integer> endTraining(@PathVariable("trainingId") Integer trainingId) {
        return new ResponseEntity<>(trainingLogService.endTraining(trainingId), HttpStatus.OK);
    }

    @DeleteMapping("/{trainingId}")
    public ResponseEntity<?> removeTrainingById(@PathVariable("trainingId") Integer trainingId) {
        trainingLogService.removeById(trainingId);
        return ResponseEntity.ok().build();
    }

}
