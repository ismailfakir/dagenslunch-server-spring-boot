package net.cloudcentrik.dagenslunch.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@ControllerAdvice
@RestController
@RequestMapping("/api")
public class RestaurantController {

    @Autowired
    RestaurantServiceImpl restaurantRepositoryImpl;

    @GetMapping("/restaurant")
    public List<Restaurant> retrieveAllRestaurant() {
        return restaurantRepositoryImpl.getAllRestaurant();
    }

    @GetMapping("/restaurant/{id}")
    public Optional<Restaurant> retrieveAllRestaurant(@PathVariable long id) {
        return restaurantRepositoryImpl.getRestaurantById(id);
    }

    @PostMapping("/restaurant")
    public Restaurant createRestaurant(@Valid @RequestBody Restaurant restaurant) {
        return restaurantRepositoryImpl.saveRestaurant(restaurant);
    }

    @PutMapping("/restaurant/{id}")
    public Restaurant updateRestaurant(@PathVariable long id,@Valid @RequestBody Restaurant restaurant) {
        return restaurantRepositoryImpl.updateRestaurantById(id,restaurant);
    }

    @DeleteMapping("/restaurant/{id}")
    public void deleteRestaurantById(@PathVariable long id) {
        restaurantRepositoryImpl.deleteRestaurantById(id);
    }

}
