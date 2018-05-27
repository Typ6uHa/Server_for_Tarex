package server.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import server.transfer.TokenDto;

@Data
@AllArgsConstructor
public class LoginRestaurant {
    TokenDto tokenDto;
    Restaurant restaurant;
}
