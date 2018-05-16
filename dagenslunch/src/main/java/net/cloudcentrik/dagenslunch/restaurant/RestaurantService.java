package net.cloudcentrik.dagenslunch.restaurant;

import net.cloudcentrik.dagenslunch.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface RestaurantService{
    Restaurant saveRestaurant(Restaurant restaurant);
    List<Restaurant> getAllRestaurant();
    void deleteRestaurantById(Long id);
    Optional<Restaurant> getRestaurantById(Long id);
    Restaurant updateRestaurantById(Long id,Restaurant restaurant);
}
