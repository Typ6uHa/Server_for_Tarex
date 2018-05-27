package server.services;

import org.springframework.stereotype.Component;
import server.forms.ReservationForm;
import server.model.Reservation;
import server.model.Restaurant;
import server.model.StatusReservation;
import server.model.User;

import java.util.List;

public interface ReservationService {
    void reservation(ReservationForm reservationForm);

    List<Reservation> getAll(Long id);

    List<Reservation> getAllActive(Long id);
}
