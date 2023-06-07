package uek.krakow.pl.Gym_App.traininglog;

import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class TrainingLogResponseMapper implements Function<TrainingLog, TrainingLogResponse> {

    @Override
    public TrainingLogResponse apply(TrainingLog trainingLog) {
        return TrainingLogResponse.builder()
                .id(trainingLog.getId())
                .startDate(trainingLog.getStartDate())
                .endDate(trainingLog.getEndDate())
                .isDone(trainingLog.getIsDone())
                .trainingId(trainingLog.getTraining().getId())
                .build();
    }
}
