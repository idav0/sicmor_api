package mx.edu.utez.sicmor_api.controllers.history.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.sicmor_api.models.history.History;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class HistoryDto {


    private Long id;
    private int airHumididty;

    private int airTemperature;

    private int soilHumididty;

    private int soilTemperature;

    private int luminosity;


    public History getHistory() {
        return new History(
                getId(),
                getAirHumididty(),
                getAirTemperature(),
                getSoilHumididty(),
                getSoilTemperature(),
                getLuminosity()
        );
    }
}
