package server.repositories.anton_app;

import org.springframework.data.jpa.repository.JpaRepository;
import server.model.Reservation;
import server.model.StatusReservation;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> getAllById(Long id);
    List<Reservation> getAllByIdAndStatusReservation(Long id, StatusReservation statusReservation);
}
