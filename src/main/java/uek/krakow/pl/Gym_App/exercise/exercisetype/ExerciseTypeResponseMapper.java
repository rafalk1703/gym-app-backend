package uek.krakow.pl.Gym_App.exercise.exercisetype;

import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ExerciseTypeResponseMapper implements Function<ExerciseType, ExerciseTypeResponse> {

    @Override
    public ExerciseTypeResponse apply(ExerciseType exerciseType) {
        return ExerciseTypeResponse.builder()
                .id(exerciseType.getId())
                .name(exerciseType.getName())
                .imageUrl(exerciseType.getImageUrl())
                .build();
    }
}
