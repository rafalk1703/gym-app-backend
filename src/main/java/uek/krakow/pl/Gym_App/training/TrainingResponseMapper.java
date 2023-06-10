package uek.krakow.pl.Gym_App.training;

import org.springframework.stereotype.Service;
import uek.krakow.pl.Gym_App.exercise.Exercise;
import uek.krakow.pl.Gym_App.exercise.exercisetype.ExerciseTypeResponse;

import java.util.List;
import java.util.function.Function;

@Service
public class TrainingResponseMapper  implements Function<Training, TrainingResponse> {

    @Override
    public TrainingResponse apply(Training training) {
        List<Exercise> exerciseList = training.getExercises();
        Exercise[] exercises = new Exercise[exerciseList.size()];
        exerciseList.toArray(exercises);
        return TrainingResponse.builder()
                .id(training.getId())
                .name(training.getName())
                .imageUrl(training.getImageUrl())
                .icon(training.getIcon())
//                .exercises(exercises)
                .build();
    }
}
