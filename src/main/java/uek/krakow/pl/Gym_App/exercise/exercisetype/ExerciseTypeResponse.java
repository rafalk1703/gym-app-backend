package uek.krakow.pl.Gym_App.exercise.exercisetype;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseTypeResponse {

    private Integer id;
    private String name;
}
