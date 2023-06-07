package uek.krakow.pl.Gym_App.traininglog;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainingLogRepository extends JpaRepository<TrainingLog, Integer> {


    List<TrainingLog> findTrainingLogsByTraining_User_Email(String userEmail);


}
