package uek.krakow.pl.Gym_App.training;

import org.springframework.data.jpa.repository.JpaRepository;
import uek.krakow.pl.Gym_App.exercise.Exercise;

import java.util.List;

public interface TrainingRepository extends JpaRepository<Training, Integer> {


}
