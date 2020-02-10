package kr.co.project.restaurantreservesystem.interfaces;

import kr.co.project.restaurantreservesystem.domain.Restaurant;
import kr.co.project.restaurantreservesystem.domain.RestaurantRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
    UI Layer는 사용자와 도메인(또는 비즈니스 로직)들이 서로 상관없도록(징검다리 역할만 하도록) 코드를 구현한다.
    실제로 활용하는 부분은 도메인에서 이루어지도록 한다.
    즉, Controller는 매우 단순하게 구현하고, 데이터를 가지고 처리하는 부분은 도메인에서 이뤄지도록 한다.
 */

@RestController
public class RestaurantController {

    private RestaurantRepository repository = new RestaurantRepository();

    @GetMapping("/restaurants")
    public List<Restaurant> list() {
        return repository.findAll();
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id) {
        return repository.findById(id);
    }
}
