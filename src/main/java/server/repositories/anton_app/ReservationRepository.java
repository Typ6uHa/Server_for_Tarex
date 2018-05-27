package server.repositories.anton_app;

import org.springframework.data.jpa.repository.JpaRepository;
import server.model.Reservation;
import server.model.Restaurant;
import server.model.StatusReservation;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Reservation getOneById(Long id);
    List<Reservation> getAllByStatusReservationAndRestaurant(StatusReservation statusReservation,Restaurant restaurant);
    List<Reservation> getAllByRestaurant(Restaurant restaurant);
}
