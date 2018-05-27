package server.services;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import server.forms.LoginRestaurantForm;
import server.model.Restaurant;
import server.model.Token;
import server.model.TokenRestaurant;
import server.repositories.anton_app.RestaurantRepository;
import server.repositories.anton_app.TokensRepository;
import server.repositories.anton_app.TokensRestaurantRepository;
import server.transfer.TokenDto;

@Component
public class LoginRestaurantServiceImpl implements LoginRestaurantService {

    @Autowired
    private TokensRestaurantRepository tokensRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public TokenDto login(LoginRestaurantForm loginRestaurantForm) {
        Restaurant restaurant = restaurantRepository.findOneByLogin(loginRestaurantForm.getLogin());

        if (passwordEncoder.matches(loginRestaurantForm.getPassword(),restaurant.getPassword())) {
            TokenRestaurant token = TokenRestaurant.builder()
                    .restaurant(restaurant)
                    .value(RandomStringUtils.random(10, true, true))
                    .build();

            tokensRepository.save(token);
            return TokenDto.from(token);
        }
        throw new FatalBeanException("sosi");
    }
}
