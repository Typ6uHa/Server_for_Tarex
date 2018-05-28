package server.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationForm {
    private String userToken;
    private Long restaurant_id;
    private String time;
    private String day;
    private Integer countPeople;
    private String description;
}
