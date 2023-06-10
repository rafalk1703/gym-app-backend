package uek.krakow.pl.Gym_App.dataLoader;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uek.krakow.pl.Gym_App.exercise.Exercise;
import uek.krakow.pl.Gym_App.exercise.ExerciseLevel;
import uek.krakow.pl.Gym_App.exercise.ExerciseRepository;
import uek.krakow.pl.Gym_App.exercise.exercisetype.ExerciseType;
import uek.krakow.pl.Gym_App.exercise.exercisetype.ExerciseTypeRepository;
import uek.krakow.pl.Gym_App.training.Training;
import uek.krakow.pl.Gym_App.training.TrainingRepository;
import uek.krakow.pl.Gym_App.traininglog.TrainingLog;
import uek.krakow.pl.Gym_App.traininglog.TrainingLogRepository;
import uek.krakow.pl.Gym_App.user.User;
import uek.krakow.pl.Gym_App.user.UserRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DataLoaderService {
    private final UserRepository userRepository;
    private final ExerciseTypeRepository exerciseTypeRepository;
    private final ExerciseRepository exerciseRepository;

    private final TrainingRepository trainingRepository;
    private final TrainingLogRepository trainingLogRepository;

    private final PasswordEncoder passwordEncoder;

    public void loadData() {
        User user = User.builder()
                .firstname("Jan")
                .lastname("Kowalski")
                .email("test@gmail.com")
                .password(passwordEncoder.encode("test@gmail.com"))
                .build();
        userRepository.save(user);
        ExerciseType plecy = ExerciseType.builder()
                .name("Plecy")
                .imageUrl("https://images.pexels.com/photos/371049/pexels-photo-371049.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
                .build();
        ExerciseType nogi = ExerciseType.builder()
                .name("Nogi")
                .imageUrl("https://images.pexels.com/photos/116077/pexels-photo-116077.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
                .build();
        ExerciseType klata = ExerciseType.builder()
                .name("Klata")
                .imageUrl("https://images.pexels.com/photos/7187890/pexels-photo-7187890.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
                .build();
        ExerciseType kardio = ExerciseType.builder()
                .name("Kardio")
                .imageUrl("https://images.pexels.com/photos/16065652/pexels-photo-16065652/free-photo-of-mezczyzna-plaza-okulary-sloneczne-piasek.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
                .build();
        exerciseTypeRepository.save(plecy);
        exerciseTypeRepository.save(nogi);
        exerciseTypeRepository.save(klata);
        exerciseTypeRepository.save(kardio);

        Exercise sklony = Exercise.builder()
                .name("Skłony")
                .description("<br>Skłony</br>")
                .sets(10).reps(3)
                .time("3min")
                .type(plecy)
                .level(ExerciseLevel.HARD)
                .imageUrl("https://images.pexels.com/photos/13965347/pexels-photo-13965347.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
                .build();
        Exercise cwiczenie1 = Exercise.builder()
                .name("Cwiczenie 1")
                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed accumsan non felis quis sollicitudin. Donec vitae dolor nulla. Pellentesque porta ipsum non finibus maximus. Fusce et sem sed tortor placerat interdum varius eu mauris.")
                .sets(10).reps(3)
                .time("3min")
                .type(plecy)
                .level(ExerciseLevel.HARD)
                .imageUrl("https://images.pexels.com/photos/1431282/pexels-photo-1431282.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
                .build();
        Exercise cwiczenie2 = Exercise.builder()
                .name("Cwiczenie 2")
                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed accumsan non felis quis sollicitudin. Donec vitae dolor nulla. Pellentesque porta ipsum non finibus maximus. Fusce et sem sed tortor placerat interdum varius eu mauris.")
                .sets(10).reps(3)
                .time("5min")
                .type(plecy)
                .level(ExerciseLevel.HARD)
                .imageUrl("https://images.pexels.com/photos/416809/pexels-photo-416809.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
                .build();
        Exercise cwiczenie3 = Exercise.builder()
                .name("Cwiczenie 3")
                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed accumsan non felis quis sollicitudin. Donec vitae dolor nulla. Pellentesque porta ipsum non finibus maximus. Fusce et sem sed tortor placerat interdum varius eu mauris.")
                .sets(10).reps(3)
                .time("5min")
                .type(plecy)
                .level(ExerciseLevel.MEDIUM)
                .imageUrl("https://images.pexels.com/photos/1638324/pexels-photo-1638324.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
                .build();
        Exercise cwiczenie4 = Exercise.builder()
                .name("Cwiczenie 4")
                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed accumsan non felis quis sollicitudin. Donec vitae dolor nulla. Pellentesque porta ipsum non finibus maximus. Fusce et sem sed tortor placerat interdum varius eu mauris.")
                .sets(10).reps(3)
                .time("5min")
                .type(plecy)
                .level(ExerciseLevel.EASY)
                .imageUrl("https://images.pexels.com/photos/414029/pexels-photo-414029.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
                .build();
        Exercise cwiczenie5 = Exercise.builder()
                .name("Cwiczenie 5")
                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed accumsan non felis quis sollicitudin. Donec vitae dolor nulla. Pellentesque porta ipsum non finibus maximus. Fusce et sem sed tortor placerat interdum varius eu mauris.")
                .sets(10).reps(3)
                .time("5min")
                .type(plecy)
                .level(ExerciseLevel.EASY)
                .imageUrl("https://images.pexels.com/photos/1552249/pexels-photo-1552249.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
                .build();
        Exercise cwiczenie6 = Exercise.builder()
                .name("Cwiczenie 6")
                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed accumsan non felis quis sollicitudin. Donec vitae dolor nulla. Pellentesque porta ipsum non finibus maximus. Fusce et sem sed tortor placerat interdum varius eu mauris.")
                .sets(10).reps(3)
                .time("5min")
                .type(plecy)
                .level(ExerciseLevel.EASY)
                .imageUrl("https://images.pexels.com/photos/38630/bodybuilder-weight-training-stress-38630.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
                .build();
        Exercise cwiczenie7 = Exercise.builder()
                .name("Cwiczenie 7")
                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed accumsan non felis quis sollicitudin. Donec vitae dolor nulla. Pellentesque porta ipsum non finibus maximus. Fusce et sem sed tortor placerat interdum varius eu mauris.")
                .sets(10).reps(3)
                .time("5min")
                .type(plecy)
                .level(ExerciseLevel.EASY)
                .imageUrl("https://images.pexels.com/photos/866027/pexels-photo-866027.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
                .build();

        exerciseRepository.save(sklony);
        exerciseRepository.save(cwiczenie1);
        exerciseRepository.save(cwiczenie2);
        exerciseRepository.save(cwiczenie3);
        exerciseRepository.save(cwiczenie4);
        exerciseRepository.save(cwiczenie5);
        exerciseRepository.save(cwiczenie6);
        exerciseRepository.save(cwiczenie7);

        Training training1 = Training.builder()
                .name("Trening 1")
                .icon("mdi-run")
                .user(user)
                .imageUrl("https://images.pexels.com/photos/414029/pexels-photo-414029.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1").build();
        Training training2 = Training.builder()
                .name("Trening 2")
                .icon("mdi-plus")
                .user(user)
                .imageUrl("https://images.pexels.com/photos/866027/pexels-photo-866027.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1").build();


        Date date10min = new Date(System.currentTimeMillis() - 600 * 1000);
        TrainingLog trainingLog1 = TrainingLog.builder().training(training1).isDone(true).endDate(String.valueOf(new Date())).startDate(String.valueOf(date10min)).build();
        TrainingLog trainingLog2 = TrainingLog.builder().training(training1).isDone(true).endDate(String.valueOf(minusDate(2000))).startDate(String.valueOf(String.valueOf(minusDate(2010)))).build();
        TrainingLog trainingLog3 = TrainingLog.builder().training(training1).isDone(true).endDate(String.valueOf(minusDate(9000))).startDate(String.valueOf(String.valueOf(minusDate(9010)))).build();
        TrainingLog trainingLog4 = TrainingLog.builder().training(training1).isDone(true).endDate(String.valueOf(minusDate(7000))).startDate(String.valueOf(String.valueOf(minusDate(7010)))).build();
        TrainingLog trainingLog5 = TrainingLog.builder().training(training1).isDone(true).endDate(String.valueOf(minusDate(4000))).startDate(String.valueOf(String.valueOf(minusDate(4010)))).build();
        TrainingLog trainingLog6 = TrainingLog.builder().training(training1).isDone(true).endDate(String.valueOf(minusDate(3000))).startDate(String.valueOf(String.valueOf(minusDate(3010)))).build();
        TrainingLog trainingLog7 = TrainingLog.builder().training(training1).isDone(true).endDate(String.valueOf(minusDate(1000))).startDate(String.valueOf(String.valueOf(minusDate(1010)))).build();

        trainingRepository.save(training1);
        exerciseRepository.save(cwiczenie1);



//        training.getExercises().add(exercise);
//        exercise.getTrainings().add(training);
//        trainingRepository.save(training);
//        exerciseRepository.save(exercise);

//        cwiczenie1.getTrainings().add(training1);
//        training1.getExercises().add(cwiczenie1);
//
//        trainingRepository.save(training1);
//        exerciseRepository.save(cwiczenie1);

        List<Exercise> exerciseList= new ArrayList<>();
        exerciseList.add(cwiczenie1);
        training1.setExercises(exerciseList);

        List<Training> trainingList = new ArrayList<>();
        trainingList.add(training1);
        cwiczenie1.setTrainings(trainingList);


        trainingRepository.save(training1);
        trainingRepository.save(training2);

        List<TrainingLog> trainingLogList= new ArrayList<>();
        trainingLogList.add(trainingLog1);
        trainingLogList.add(trainingLog2);
        trainingLogList.add(trainingLog3);
        trainingLogList.add(trainingLog4);
        trainingLogList.add(trainingLog5);
        trainingLogList.add(trainingLog6);
        trainingLogList.add(trainingLog7);
        trainingLogRepository.saveAll(trainingLogList);
    }

    private Date minusDate (Integer minutes) {
        return new Date(System.currentTimeMillis() - 60000L * minutes);
    }
}
