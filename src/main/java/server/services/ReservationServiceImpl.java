package server.services;

import javafx.util.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.model.Reservation;
import server.model.Restaurant;
import server.model.StatusReservation;
import server.model.User;
import server.repositories.anton_app.ReservationRepository;
import server.repositories.anton_app.RestaurantRepository;

import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    UserService userService;

    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public void reservation(String userToken, Long restaurant_id, String time, String day, Integer countPeople) {
      User user = userService.findOneUser(userToken);
      Restaurant restaurant = restaurantRepository.findOneById(restaurant_id);
        Reservation reservation = Reservation.builder()
                                    .restaurant(restaurant)
                                    .user(user)
                                    .countPeople(countPeople)
                                    .day(day)
                                    .time(time)
                                    .statusReservation(StatusReservation.ACTIVE)
                                    .build();
        reservationRepository.save(reservation);
    }
}
