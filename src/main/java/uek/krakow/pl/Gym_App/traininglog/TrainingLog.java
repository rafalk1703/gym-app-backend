package uek.krakow.pl.Gym_App.traininglog;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uek.krakow.pl.Gym_App.training.Training;

import java.sql.Date;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TrainingLog {

    @Id
    @GeneratedValue
    public Integer id;

    @Column(nullable = false)
    public Date startDate;

    @Column(nullable = false)
    public Date endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "training_id")
    public Training training;

}
