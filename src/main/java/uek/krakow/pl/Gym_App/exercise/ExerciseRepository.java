package uek.krakow.pl.Gym_App.exercise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uek.krakow.pl.Gym_App.training.Training;

import java.util.List;

@Repository
public interface ExerciseRepository  extends JpaRepository<Exercise, Integer> {

    List<Exercise> findExercisesByUser_Email(String userEmail);

    List<Exercise> findExercisesByUser_EmailAndAndType_Id(String userEmail, Integer typeId);


    List<Exercise> findExercisesByUser_EmailAndTrainingsContains(String userEmail, Training training);


}
