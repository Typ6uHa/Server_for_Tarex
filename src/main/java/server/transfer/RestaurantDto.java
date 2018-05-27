package server.transfer;

import lombok.AllArgsConstructor;
import lombok.Data;
import server.model.Restaurant;

@Data
@AllArgsConstructor
public class RestaurantDto {
    private Long id;
    private String login;

    public static UserDto from (Restaurant restaurant){
        return UserDto.builder()
                .id(restaurant.getId())
                .login(restaurant.getLogin())
                .build();
    }
}
