package kr.co.project.restaurantreservesystem.interfaces;

import kr.co.project.restaurantreservesystem.domain.Restaurant;
import kr.co.project.restaurantreservesystem.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // @RestController 또한 @Component의 일종이다.
public class RestaurantController {

    // RestaurantRepository에 @Component가 지정되어 있기 때문에 별도의 객체 생성 없이 @Autowired 를 사용하여 이를 대신할 수 있다.
    // @Autowired를 지정하면 Controller를 만들어 줄 때 Spring이 알아서 RestaurantRepository를 생성하여 넣어준다.
    @Autowired
    private RestaurantRepository repository;

    @GetMapping("/restaurants")
    public List<Restaurant> list() {
        return repository.findAll();
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id) {
        return repository.findById(id);
    }
}
