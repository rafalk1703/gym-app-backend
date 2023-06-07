package uek.krakow.pl.Gym_App.traininglog;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uek.krakow.pl.Gym_App.training.Training;
import uek.krakow.pl.Gym_App.training.TrainingRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrainingLogService {

    private final TrainingLogRepository trainingLogRepository;

    private final TrainingRepository trainingRepository;

    private final TrainingLogResponseMapper trainingLogResponseMapper;

    public TrainingLogResponse getTrainingLogById(int trainingLogId) {
        return trainingLogRepository.findById(trainingLogId)
                .map(trainingLogResponseMapper)
                .orElseThrow();
    }

    public List<TrainingLogResponse> getAllTrainingLogsByUserEmail(String userEmail) {
        return trainingLogRepository.findTrainingLogsByTraining_User_Email(userEmail)
                .stream()
                .map(trainingLogResponseMapper)
                .collect(Collectors.toList());
    }

    public Integer startTraining(Integer trainingId) {
        Training training = trainingRepository.findById(trainingId).orElseThrow();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        TrainingLog newTrainingLog = new TrainingLog();
        newTrainingLog.setTraining(training);
        newTrainingLog.setStartDate(formatter.format(date));

        return trainingLogRepository.save(newTrainingLog).getId();
    }


    public Integer endTraining(Integer trainingLogId) {
        TrainingLog endedTrainingLog = trainingLogRepository.findById(trainingLogId).orElseThrow();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        endedTrainingLog.setEndDate(formatter.format(date));
        endedTrainingLog.setIsDone(true);

        return trainingLogRepository.save(endedTrainingLog).getId();
    }


    public void removeById(Integer id) {
        trainingLogRepository.deleteById(id);
    }
}
