package kr.co.project.restaurantreservesystem.interfaces;

import kr.co.project.restaurantreservesystem.application.RestaurantService;
import kr.co.project.restaurantreservesystem.domain.MenuItem;
import kr.co.project.restaurantreservesystem.domain.MenuItemRepository;
import kr.co.project.restaurantreservesystem.domain.Restaurant;
import kr.co.project.restaurantreservesystem.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> list() {
        List<Restaurant> restaurants = restaurantService.getRestaurants();
        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id) {
        Restaurant restaurant = restaurantService.getRestaurant(id); // 기본 정보 + 메뉴 정보
        return restaurant;
    }

    @PostMapping("/restaurants")
    public ResponseEntity<?> create() throws URISyntaxException {
        Restaurant restaurant = new Restaurant(1234L, "BeRyong", "Busan");
        restaurantService.addRestaurant(restaurant);

        URI location = new URI("/restaurants/1234");
        return ResponseEntity.created(location).body("{}");
    }
}
