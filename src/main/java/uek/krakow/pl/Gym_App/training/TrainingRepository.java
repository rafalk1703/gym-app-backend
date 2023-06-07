package uek.krakow.pl.Gym_App.training;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Integer> {

    List<Training> findTrainingsByUser_Email(String userEmail);
}
