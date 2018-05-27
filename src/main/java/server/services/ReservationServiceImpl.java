package server.services;

import javafx.util.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.forms.ReservationForm;
import server.model.Reservation;
import server.model.Restaurant;
import server.model.StatusReservation;
import server.model.User;
import server.repositories.anton_app.ReservationRepository;
import server.repositories.anton_app.RestaurantRepository;

import java.util.List;
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
    public void reservation(ReservationForm reservationForm) {
      User user = userService.findOneUser(reservationForm.getUserToken());
      Restaurant restaurant = restaurantRepository.findOneById(reservationForm.getRestaurant_id());
        Reservation reservation = Reservation.builder()
                                    .restaurant(restaurant)
                                    .user(user)
                                    .countPeople(reservationForm.getCountPeople())
                                    .day(reservationForm.getDay())
                                    .time(reservationForm.getTime())
                                    .statusReservation(StatusReservation.ACTIVE)
                                    .build();
        reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> getAll(Long id) {
        return reservationRepository.getAllByRestaurant(restaurantRepository.findOneById(id));
    }

    @Override
    public List<Reservation> getAllActive(Long id) {
        StatusReservation statusReservation = StatusReservation.ACTIVE;
        return reservationRepository.getAllByStatusReservationAndRestaurant(statusReservation,restaurantRepository.findOneById(id));
    }
}
