package uek.krakow.pl.Gym_App.training;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uek.krakow.pl.Gym_App.exercise.*;
import uek.krakow.pl.Gym_App.user.User;
import uek.krakow.pl.Gym_App.user.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrainingService {

    private final TrainingRepository trainingRepository;

    private final UserRepository userRepository;

    private final TrainingResponseMapper trainingResponseMapper;

    public TrainingResponse getTrainingById(int trainingId) {
        return trainingRepository.findById(trainingId)
                .map(trainingResponseMapper)
                .orElseThrow();
    }

    public List<TrainingResponse> getAllTrainings() {
        return trainingRepository.findAll()
                .stream()
                .map(trainingResponseMapper)
                .collect(Collectors.toList());
    }

    public List<TrainingResponse> getAllTrainingsByUserEmail(String userEmail) {
        return trainingRepository.findTrainingsByUser_Email(userEmail)
                .stream()
                .map(trainingResponseMapper)
                .collect(Collectors.toList());
    }

    public Integer updateTrainingById(Integer trainingId, TrainingRequest request) {
        trainingRepository.findById(trainingId)
                .map(training -> {
                    training.setName(request.getName());
                    return trainingRepository.save(training);
                })
                .orElseGet(() -> {
                    Training training = new Training();
                    training.setName(request.getName());
                    return trainingRepository.save(training);
                });
        return trainingId;
    }


    public Integer addNewTraining(String userEmail, TrainingRequest request) {

        User user = userRepository.findByEmail(userEmail).orElseThrow();

        Training training = new Training();
        training.setName(request.getName());
        training.setUser(user);

        return trainingRepository.save(training).getId();

    }


    public void removeById(Integer id) {
        trainingRepository.deleteById(id);
    }

}
