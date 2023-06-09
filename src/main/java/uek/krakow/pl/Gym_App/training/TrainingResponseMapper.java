package uek.krakow.pl.Gym_App.training;

import org.springframework.stereotype.Service;
import uek.krakow.pl.Gym_App.exercise.exercisetype.ExerciseTypeResponse;

import java.util.function.Function;

@Service
public class TrainingResponseMapper  implements Function<Training, TrainingResponse> {

    @Override
    public TrainingResponse apply(Training training) {
        return TrainingResponse.builder()
                .id(training.getId())
                .name(training.getName())
                .imageUrl(training.getImageUrl())
                .icon(training.getIcon())
                .build();
    }
}
