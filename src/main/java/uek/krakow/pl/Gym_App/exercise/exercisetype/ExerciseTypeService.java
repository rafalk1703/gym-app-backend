package uek.krakow.pl.Gym_App.exercise.exercisetype;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uek.krakow.pl.Gym_App.exception.DeleteException;
import uek.krakow.pl.Gym_App.exception.ResourceNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExerciseTypeService {

    private final ExerciseTypeRepository exerciseTypeRepository;

    private final ExerciseTypeResponseMapper exerciseTypeResponseMapper;


    public List<ExerciseTypeResponse> getAllExerciseTypes() {
        return exerciseTypeRepository.findAll()
                .stream()
                .map(exerciseTypeResponseMapper)
                .collect(Collectors.toList());
    }

    public ExerciseTypeResponse getExerciseTypeById(Integer exerciseTypeId) {
        return exerciseTypeRepository.findById(exerciseTypeId)
                .map(exerciseTypeResponseMapper)
                .orElseThrow(() -> new ResourceNotFoundException("Exercise type not found"));
    }

    public ExerciseTypeResponse saveExerciseType(ExerciseTypeRequest request) {
        var exerciseType = ExerciseType.builder()
                .name(request.getName())
                .build();
        exerciseTypeRepository.save(exerciseType);

        return exerciseTypeResponseMapper.apply(exerciseType);
    }

    public void removeExerciseTypeById(Integer exerciseTypeId) {
        if (exerciseTypeRepository.existsById(exerciseTypeId)) {
            exerciseTypeRepository.deleteById(exerciseTypeId);
        } else {
            throw new DeleteException("Object not found");
        }
    }
}
