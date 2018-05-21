package net.cloudcentrik.dagenslunch.web;

import net.cloudcentrik.dagenslunch.restaurant.Restaurant;
import net.cloudcentrik.dagenslunch.restaurant.RestaurantService;
import net.cloudcentrik.dagenslunch.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Controller
public class WebController implements ErrorController {

    private static final Logger log = LoggerFactory.getLogger(WebController.class);

    @Autowired
    RestaurantService restaurantService;

    @GetMapping(value= "/")
    public String index(Model model) {
        return "redirect:login";
    }

    @GetMapping(value = "/login")
    public String login(Model model,User user) {
        model.addAttribute("user",user);
        return "login";
    }

    @GetMapping(value = "/dashboard")
    public String dashboard(Model model) {
        return "dashboard";
    }

    @PostMapping(value= "/login")
    public String login(@ModelAttribute User user) {
        if(user.getEmail().equals("info@cloudcentrik.net")&&user.getPassword().equals("test")){
            return "redirect:dashboard";
        }else{
            return "redirect:login";
        }

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
        //log.info(restaurant.getName());
        restaurantService.saveRestaurant(restaurant);
        return "redirect:restaurantlist";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                return "404";
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "500";
            }
        }
        return "error";
    }


}
