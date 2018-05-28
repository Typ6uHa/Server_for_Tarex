package server.controllers.aizat_app;

import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import server.forms.LoginForm;
import server.forms.LoginRestaurantForm;
import server.model.Login;
import server.model.LoginRestaurant;
import server.model.Restaurant;
import server.model.User;
import server.repositories.anton_app.RestaurantRepository;
import server.repositories.anton_app.UsersRepository;
import server.services.LoginRestaurantService;
import server.services.LoginService;

import java.util.Optional;

@RestController
public class LoginRestaurantController {

    @Autowired
    private LoginRestaurantService loginRestaurantService;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @PostMapping("/login_restaurant")
    public ResponseEntity<LoginRestaurant> login(@RequestBody LoginRestaurantForm loginForm) {
        Restaurant restaurant = restaurantRepository.findOneByLogin(loginForm.getLogin());
        LoginRestaurant login = new LoginRestaurant(loginRestaurantService.login(loginForm), restaurant);
        return ResponseEntity.ok(login);
    }

}
