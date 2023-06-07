package uek.krakow.pl.Gym_App.exercise.exercisetype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ExerciseTypeRepository extends JpaRepository<ExerciseType, Integer> {

    Optional<ExerciseType> findByName(String exerciseTypeName);
}
