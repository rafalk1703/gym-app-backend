package uek.krakow.pl.Gym_App.exercise;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uek.krakow.pl.Gym_App.exception.DeleteException;
import uek.krakow.pl.Gym_App.exception.ResourceNotFoundException;
import uek.krakow.pl.Gym_App.exercise.exercisetype.ExerciseType;
import uek.krakow.pl.Gym_App.exercise.exercisetype.ExerciseTypeRepository;
import uek.krakow.pl.Gym_App.training.Training;
import uek.krakow.pl.Gym_App.training.TrainingListRequest;
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
                .orElseThrow(() -> new ResourceNotFoundException("Exercise not found"));
    }

    public List<ExerciseResponse> getAllExercises() {
        return exerciseRepository.findAll()
                .stream()
                .map(exerciseResponseMapper)
                .collect(Collectors.toList());
    }

    public List<ExerciseResponse> getAllExercisesByUserEmail(String userEmail) {
        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return exerciseRepository.findExercisesByUsersContains(user)
                .stream()
                .map(exerciseResponseMapper)
                .collect(Collectors.toList());
    }


    public List<ExerciseResponse>  getAllGlobalExercisesByTypeId(Integer typeId) {
        return exerciseRepository.findExercisesByType_Id(typeId)
                .stream()
                .map(exerciseResponseMapper)
                .collect(Collectors.toList());
    }
    public List<ExerciseResponse> getAllExercisesByUserEmailAndTrainingId(String userEmail, Integer trainingId) {
        Training training = trainingRepository.findById(trainingId).orElseThrow(() -> new ResourceNotFoundException("Training not found"));
        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new ResourceNotFoundException("User not found"));

        System.out.println("getAllExercisesByUserEmailAndTrainingId");
        training.getExercises().forEach(e -> {
            System.out.println(e.name.toString());
        });


        return exerciseRepository.findExercisesByUsersContainsAndTrainingsContains(user, training)
                .stream()
                .map(exerciseResponseMapper)
                .collect(Collectors.toList());
    }

    public List<ExerciseResponse> getAllExercisesByTrainingId(Integer trainingId) {
        Training training = trainingRepository.findById(trainingId).orElseThrow(() -> new ResourceNotFoundException("Training not found"));

        System.out.println("getAllExercisesByUserEmailAndTrainingId");
        training.getExercises().forEach(e -> {
            System.out.println(e.name.toString());
        });


        return exerciseRepository.findExercisesByTrainingsContains(training)
                .stream()
                .map(exerciseResponseMapper)
                .collect(Collectors.toList());
    }

    public List<ExerciseResponse> getAllExercisesByUserEmailAndTypeId(String userEmail, Integer typeId) {
        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return exerciseRepository.findExercisesByUsersContainsAndType_Id(user, typeId)
                .stream()
                .map(exerciseResponseMapper)
                .collect(Collectors.toList());
    }

    public Integer updateExerciseById(Integer exerciseId, ExerciseRequest request) {
        ExerciseType type = exerciseTypeRepository.findByName(request.getType()).orElseThrow(() -> new ResourceNotFoundException("Exercise not found"));
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

    public Integer addUserToExercise(String userEmail, Integer exerciseId) {

        Exercise exercise = exerciseRepository.findById(exerciseId).orElseThrow(() -> new ResourceNotFoundException("Exercise not found"));
        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new ResourceNotFoundException("User not found"));

        exercise.getUsers().add(user);
        return exerciseRepository.save(exercise).getId();
    }

    public Integer addNewGlobalExercise(ExerciseRequest request) {

        ExerciseType type = exerciseTypeRepository.findByName(request.getType()).orElseThrow(() -> new ResourceNotFoundException("Exercise type not found"));

        Exercise exercise = new Exercise();
        exercise.setName(request.getName());
        exercise.setReps(request.getReps());
        exercise.setDescription(request.getDescription());
        exercise.setLevel(ExerciseLevel.valueOf(request.getLevel()));
        exercise.setSets(request.getSets());
        exercise.setTime(request.getTime());
        exercise.setType(type);

        return exerciseRepository.save(exercise).getId();

    }

    public Integer addNewUserExercise(String userEmail, ExerciseRequest request) {

        ExerciseType type = exerciseTypeRepository.findByName(request.getType()).orElseThrow(() -> new ResourceNotFoundException("Exercise type not found"));
        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Exercise exercise = new Exercise();
        exercise.setName(request.getName());
        exercise.setReps(request.getReps());
        exercise.setDescription(request.getDescription());
        exercise.setLevel(ExerciseLevel.valueOf(request.getLevel()));
        exercise.setSets(request.getSets());
        exercise.setTime(request.getTime());
        exercise.setType(type);
        exercise.getUsers().add(user);

        return exerciseRepository.save(exercise).getId();

    }

    public void addExerciseToTrainings(Integer exerciseId, TrainingListRequest trainingIds) {

        Exercise exercise = exerciseRepository.findById(exerciseId).orElseThrow(() -> new ResourceNotFoundException("Exercise not found"));

        trainingIds.getTrainings().forEach(trainingRequest -> {
            Training training = trainingRepository.findById(trainingRequest.getId()).orElseThrow(() -> new ResourceNotFoundException("Training not found"));
            training.getExercises().add(exercise);
            exercise.getTrainings().add(training);
            trainingRepository.save(training);
            exerciseRepository.save(exercise);

        });

    }


    public void removeById(Integer id) {
        if (exerciseRepository.existsById(id)) {
            exerciseRepository.deleteById(id);
        } else {
            throw new DeleteException("Object not found");
        }
    }

}
