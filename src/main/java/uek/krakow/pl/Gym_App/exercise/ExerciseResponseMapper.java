package uek.krakow.pl.Gym_App.exercise;

import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ExerciseResponseMapper  implements Function<Exercise, ExerciseResponse> {

    @Override
    public ExerciseResponse apply(Exercise exercise) {
        return ExerciseResponse.builder()
                .id(exercise.getId())
                .name(exercise.getName())
                .imageUrl(exercise.getImageUrl())
                .description(exercise.getDescription())
                .level(exercise.getLevel())
                .time(exercise.getTime())
                .reps(exercise.getReps())
                .sets(exercise.getSets())
                .type(exercise.getType().getName())
                .build();
    }
}
