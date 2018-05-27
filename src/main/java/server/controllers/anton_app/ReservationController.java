package server.controllers.anton_app;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {

    @PostMapping("/reservation/{restaurant-id}")
    public void getReservation (@PathVariable("restaurant-id") String restaurantId){

    }
}
