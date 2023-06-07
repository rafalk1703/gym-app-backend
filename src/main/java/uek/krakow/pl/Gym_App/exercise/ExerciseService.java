package uek.krakow.pl.Gym_App.exercise;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uek.krakow.pl.Gym_App.exercise.exercisetype.ExerciseType;
import uek.krakow.pl.Gym_App.exercise.exercisetype.ExerciseTypeRepository;
import uek.krakow.pl.Gym_App.training.Training;
import uek.krakow.pl.Gym_App.training.TrainingRepository;
import uek.krakow.pl.Gym_App.user.User;
import uek.krakow.pl.Gym_App.user.UserRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    private final TrainingRepository trainingRepository;

    private final ExerciseTypeRepository exerciseTypeRepository;

    private final UserRepository userRepository;

    private final ExerciseResponseMapper exerciseResponseMapper;

    public ExerciseResponse getExerciseById(int exerciseId) {
        return exerciseRepository.findById(exerciseId)
                .map(exerciseResponseMapper)
                .orElseThrow();
    }

    public List<ExerciseResponse> getAllExercises() {
        return exerciseRepository.findAll()
                .stream()
                .map(exerciseResponseMapper)
                .collect(Collectors.toList());
    }

    public List<ExerciseResponse> getAllExercisesByUserEmail(String userEmail) {
        return exerciseRepository.findExercisesByUser_Email(userEmail)
                .stream()
                .map(exerciseResponseMapper)
                .collect(Collectors.toList());
    }

    public List<ExerciseResponse> getAllExercisesByUserEmailAndTrainingId(String userEmail, Integer trainingId) {
        Training training = trainingRepository.getReferenceById(trainingId);

        return exerciseRepository.findExercisesByUser_EmailAndTrainingsContains(userEmail, training)
                .stream()
                .map(exerciseResponseMapper)
                .collect(Collectors.toList());
    }

    public List<ExerciseResponse> getAllExercisesByUserEmailAndTypeId(String userEmail, Integer typeId) {
        return exerciseRepository.findExercisesByUser_EmailAndAndType_Id(userEmail, typeId)
                .stream()
                .map(exerciseResponseMapper)
                .collect(Collectors.toList());
    }

    public Integer updateExerciseById(Integer exerciseId, ExerciseRequest request) {
        ExerciseType type = exerciseTypeRepository.findByName(request.getType()).orElseThrow();
        exerciseRepository.findById(exerciseId)
                .map(exercise -> {
                    exercise.setName(request.getName());
                    exercise.setReps(request.getReps());
                    exercise.setDescription(request.getDescription());
                    exercise.setLevel(ExerciseLevel.valueOf(request.getLevel()));
                    exercise.setSets(request.getSets());
                    exercise.setTime(request.getTime());
                    exercise.setType(type);
                    return exerciseRepository.save(exercise);
                })
                .orElseGet(() -> {
                    Exercise exercise = new Exercise();
                    exercise.setName(request.getName());
                    exercise.setReps(request.getReps());
                    exercise.setDescription(request.getDescription());
                    exercise.setLevel(ExerciseLevel.valueOf(request.getLevel()));
                    exercise.setSets(request.getSets());
                    exercise.setTime(request.getTime());
                    exercise.setType(type);
                    return exerciseRepository.save(exercise);
                });
        return exerciseId;
    }


    public Integer addNewExercise(String userEmail, ExerciseRequest request) {

        ExerciseType type = exerciseTypeRepository.findByName(request.getType()).orElseThrow();
        User user = userRepository.findByEmail(userEmail).orElseThrow();

        Exercise exercise = new Exercise();
        exercise.setName(request.getName());
        exercise.setReps(request.getReps());
        exercise.setDescription(request.getDescription());
        exercise.setLevel(ExerciseLevel.valueOf(request.getLevel()));
        exercise.setSets(request.getSets());
        exercise.setTime(request.getTime());
        exercise.setType(type);
        exercise.setUser(user);

        Exercise savedExercise = exerciseRepository.save(exercise);

        return savedExercise.getId();

    }


    public void removeById(Integer id) {
        exerciseRepository.deleteById(id);
    }

}
