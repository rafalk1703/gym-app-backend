package uek.krakow.pl.Gym_App.training;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrainingResponse {

    private Integer id;
    private String name;

    private String imageUrl;
    private String icon;


}
