package uek.krakow.pl.Gym_App.training;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uek.krakow.pl.Gym_App.exercise.Exercise;
import uek.krakow.pl.Gym_App.traininglog.TrainingLog;
import uek.krakow.pl.Gym_App.user.User;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Training {

    @Id
    @GeneratedValue
    public Integer id;

    @Column(nullable = false)
    public String name;

    @Column()
    public String imageUrl;

    @Column()
    public String icon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User user;

    @OneToMany(mappedBy = "training")
    private List<TrainingLog> trainingLogs;

    @ManyToMany(fetch = FetchType.LAZY)
    public List<Exercise> exercises = new LinkedList<>();
}
