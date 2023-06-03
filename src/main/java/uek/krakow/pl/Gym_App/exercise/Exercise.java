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
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Exercise {

    @Id
    @GeneratedValue
    public Integer id;

    @Column(unique = true)
    public String token;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
    public ExerciseType type;

    @ManyToMany(fetch = FetchType.LAZY)
    public List<Training> trainings;

}
