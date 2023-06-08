package uek.krakow.pl.Gym_App.exercise;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uek.krakow.pl.Gym_App.exercise.exercisetype.ExerciseType;
import uek.krakow.pl.Gym_App.training.Training;
import uek.krakow.pl.Gym_App.user.User;

import java.util.LinkedList;
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

    @Column(nullable = false)
    public String name;

    @Column(nullable = false)
    public String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public ExerciseLevel level;

    @Column(nullable = false)
    public String time;

    @Column
    public Integer reps;

    @Column
    public Integer sets;

    @ManyToMany(fetch = FetchType.LAZY)
    public List<User> users = new LinkedList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
    public ExerciseType type;

    @ManyToMany(fetch = FetchType.LAZY)
    public List<Training> trainings;

}
