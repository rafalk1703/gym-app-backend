package uek.krakow.pl.Gym_App.exercise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uek.krakow.pl.Gym_App.training.Training;
import uek.krakow.pl.Gym_App.user.User;

import java.util.List;

@Repository
public interface ExerciseRepository  extends JpaRepository<Exercise, Integer> {

    List<Exercise> findExercisesByUsersContains(User user);

    List<Exercise> findExercisesByUsersContainsAndType_Id(User user, Integer typeId);

    List<Exercise> findExercisesByType_Id(Integer typeId);

    List<Exercise> findExercisesByUsersContainsAndTrainingsContains(User user, Training training);


}
