package net.cloudcentrik.dagenslunch.restaurant;

import net.cloudcentrik.dagenslunch.exception.ResourceNotFoundException;
import net.cloudcentrik.dagenslunch.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service(value = "restaurantService")
public class RestaurantServiceImpl  implements RestaurantService{

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> getAllRestaurant() {
        List<Restaurant> list = new ArrayList<>();
        restaurantRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public void deleteRestaurantById(Long id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    public Optional<Restaurant> getRestaurantById(Long id) throws ResourceNotFoundException{

        Optional<Restaurant> restaurant=restaurantRepository.findById(id);

        if (!restaurant.isPresent()) {
            throw new ResourceNotFoundException(id,"Restaurant");
        }
        return restaurant;
    }


    public Restaurant updateRestaurantById(Long id,Restaurant restaurant) {

        if(restaurantRepository.existsById(id)){
            //int res=restaurantRepository.updateRestaurant(id,restaurant.getName());
            restaurant.setId(id);
            return restaurantRepository.saveAndFlush(restaurant);
        }else{
            throw new ResourceNotFoundException(id,"Restaurant");
        }
    }

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }
}
