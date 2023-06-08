package uek.krakow.pl.Gym_App.training;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrainingListRequest {
    private List<TrainingIdRequest> trainings;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TrainingIdRequest {
        Integer id;
    }
}
