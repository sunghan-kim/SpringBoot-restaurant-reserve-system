package kr.co.project.restaurantreservesystem.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component // RestaurantRepository 을 Spring에서 직접 관리하게 된다.
public class RestaurantRepository {

    private List<Restaurant> restaurants = new ArrayList<>();

    public RestaurantRepository() {
        restaurants.add(new Restaurant(1004L,"Bob zip", "Seoul"));
        restaurants.add(new Restaurant(2020L,"Cyber Food", "Seoul"));
    }

    public List<Restaurant> findAll() {
        return restaurants;
    }

    public Restaurant findById(Long id) {
        return restaurants.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElse(null); //.get();
    }
}
