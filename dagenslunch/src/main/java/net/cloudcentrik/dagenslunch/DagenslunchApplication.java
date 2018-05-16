package net.cloudcentrik.dagenslunch;

import net.cloudcentrik.dagenslunch.configuration.DatabaseConfiguration;
import net.cloudcentrik.dagenslunch.restaurant.RestaurantDataRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class DagenslunchApplication {

	@Autowired
	RestaurantDataRestRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(DagenslunchApplication.class, args);
	}
}
