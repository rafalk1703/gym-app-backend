package uek.krakow.pl.Gym_App.traininglog;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrainingLogResponse {

    private Integer id;

    private String startDate;

    private String endDate;

    private Boolean isDone;

    private Integer trainingId;
}
