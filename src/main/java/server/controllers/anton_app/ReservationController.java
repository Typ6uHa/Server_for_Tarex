package server.controllers.anton_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import server.forms.ReservationForm;
import server.services.ReservationService;

@RestController
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @PostMapping("/reservation")
    ResponseEntity <ReservationForm> reservation (@RequestBody ReservationForm reservationForm){
        reservationService.reservation(reservationForm.getUserToken(),reservationForm.getRestaurant_id(),reservationForm.getTime(),reservationForm.getDay(),reservationForm.getCountPeople());
        return ResponseEntity.ok().build();
    }
}
