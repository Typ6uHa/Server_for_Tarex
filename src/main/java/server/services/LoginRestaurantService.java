package server.services;

import server.forms.LoginRestaurantForm;
import server.transfer.TokenDto;

public interface LoginRestaurantService {
    TokenDto login(LoginRestaurantForm loginRestaurantForm);
}
