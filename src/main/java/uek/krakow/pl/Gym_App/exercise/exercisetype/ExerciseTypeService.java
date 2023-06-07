package uek.krakow.pl.Gym_App.exercise.exercisetype;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
                .orElseThrow();
    }

    public ExerciseTypeResponse saveExerciseType(ExerciseTypeRequest request) {
        var exerciseType = ExerciseType.builder()
                .name(request.getName())
                .build();
        exerciseTypeRepository.save(exerciseType);

        return exerciseTypeResponseMapper.apply(exerciseType);
    }

    public void removeExerciseTypeById(Integer exerciseTypeId) {
        exerciseTypeRepository.deleteById(exerciseTypeId);
    }
}
