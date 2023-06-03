package uek.krakow.pl.Gym_App.exercise;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ExerciseType {

    @Id
    @GeneratedValue
    public Integer id;

    @Column(unique = true)
    public String name;

    @OneToMany(mappedBy = "type")
    private List<Exercise> exercises;
}
