package uek.krakow.pl.Gym_App.exercise;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uek.krakow.pl.Gym_App.user.User;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseRequest {

    private String name;

    private String description;

    private String level;

    private String time;

    private String type;

    private Integer reps;

    private Integer sets;

}
