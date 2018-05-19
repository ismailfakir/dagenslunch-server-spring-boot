package net.cloudcentrik.dagenslunch.web;

import net.cloudcentrik.dagenslunch.restaurant.Restaurant;
import net.cloudcentrik.dagenslunch.restaurant.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
@Controller
@RequestMapping("/")
public class WebController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping(value = "/")
    public String welcome(Model model) {
        model.addAttribute("restaurantList",restaurantService.getAllRestaurant());
        return "index";
    }

    @GetMapping(value = "/tables")
    public String forms(Model model) {
        model.addAttribute("restaurantList",restaurantService.getAllRestaurant());
        return "tables";
    }

    @GetMapping(value = "/home")
    public String home(Model model) {
        model.addAttribute("restaurantList",restaurantService.getAllRestaurant());
        return "home";
    }

    @GetMapping(value = "/restaurantlist")
    public String restaurantList(Model model) {
        model.addAttribute("restaurantList",restaurantService.getAllRestaurant());
        return "restaurantlist";
    }

    @GetMapping(value = "/addrestaurant")
    public String addRestaurant(Model model,Restaurant restaurant) {
        model.addAttribute("restaurant",restaurant);
        return "addrestaurant";
    }

    @PostMapping(value= "/addrestaurant")
    public String addRestaurant(@ModelAttribute Restaurant restaurant) {
        return "redirect: /home";
    }
}
