package server.controllers.anton_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.model.Restaurant;
import server.model.Restaurants;
import server.repositories.anton_app.RestaurantRepository;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @GetMapping("/restaurant")
    public Restaurants getRestaurant() {
        System.out.println("xer");
        Restaurants restaurants = new Restaurants(restaurantRepository.findAll());
        return restaurants;
    }

    @GetMapping("/restaurant/id/{restaurantId}")
    public Restaurant getRestaurantById(@PathVariable("restaurantId") Long restaurantId){
        System.out.println("zbs");
        return restaurantRepository.findOneById(restaurantId);
    }
}
