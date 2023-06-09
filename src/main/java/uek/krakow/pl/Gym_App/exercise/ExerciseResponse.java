package uek.krakow.pl.Gym_App.exercise;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uek.krakow.pl.Gym_App.training.Training;
import uek.krakow.pl.Gym_App.user.User;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseResponse {

    private Integer id;

    private String name;

    private String imageUrl;

    private String description;

    private ExerciseLevel level;

    private String time;

    private Integer reps;

    private Integer sets;

    private String type;

}
