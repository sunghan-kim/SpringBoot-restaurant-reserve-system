package kr.co.project.restaurantreservesystem.application;

import kr.co.project.restaurantreservesystem.domain.MenuItem;
import kr.co.project.restaurantreservesystem.domain.MenuItemRepository;
import kr.co.project.restaurantreservesystem.domain.Restaurant;
import kr.co.project.restaurantreservesystem.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // @Component의 한 종류
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    MenuItemRepository menuItemRepository;

    public RestaurantService(RestaurantRepository restaurantRepository, MenuItemRepository menuItemRepository) {
        this.restaurantRepository = restaurantRepository;
        this.menuItemRepository = menuItemRepository;
    }

    public List<Restaurant> getRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        return restaurants;
    }

    public Restaurant getRestaurant(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id);

        List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantId(id);
        restaurant.setMenuItem(menuItems);

        return restaurant;
    }

    public void addRestaurant(Restaurant restaurant) {
        //
    }
}
