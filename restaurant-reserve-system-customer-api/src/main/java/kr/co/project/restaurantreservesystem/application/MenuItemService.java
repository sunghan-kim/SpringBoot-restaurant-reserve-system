package kr.co.project.restaurantreservesystem.application;

import kr.co.project.restaurantreservesystem.domain.MenuItem;
import kr.co.project.restaurantreservesystem.domain.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService {

    public MenuItemService(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    @Autowired
    private MenuItemRepository menuItemRepository;

    public void bulkUpdate(Long restaurantsId, List<MenuItem> menuItems) {
        for (MenuItem menuItem : menuItems) {
            update(restaurantsId, menuItem);
        }
    }

    private void update(Long restaurantsId, MenuItem menuItem) {
        if (menuItem.isDestroy()) {
            menuItemRepository.deleteById(menuItem.getId());
            return;
        }
        menuItem.setRestaurantId(restaurantsId);
        menuItemRepository.save(menuItem);
    }
}
