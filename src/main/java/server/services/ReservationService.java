package server.services;

import org.springframework.stereotype.Component;
import server.model.Reservation;
import server.model.Restaurant;
import server.model.User;

public interface ReservationService {
    void reservation(String UserToken, Long restaurant_id, String time, String day, Integer countPeople);
}
