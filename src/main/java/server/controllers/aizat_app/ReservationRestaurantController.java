package server.controllers.aizat_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import server.model.Reservation;
import server.model.Reservations;
import server.services.ReservationService;

import java.util.List;

@RestController
public class ReservationRestaurantController {

    @Autowired
    ReservationService reservationService;

    @GetMapping("/reservation/restaurant/{reservationId}")
    public Reservations getReservation(@PathVariable("reservationId") Long reservationId) {
        return new Reservations(reservationService.getAll(reservationId));
    }

    @GetMapping("reservation/restaurant/active/{reservationId}")
    public Reservations getReservationActive(@PathVariable("reservationId") Long reservationId) {
        return new Reservations(reservationService.getAllActive(reservationId));
    }
}
