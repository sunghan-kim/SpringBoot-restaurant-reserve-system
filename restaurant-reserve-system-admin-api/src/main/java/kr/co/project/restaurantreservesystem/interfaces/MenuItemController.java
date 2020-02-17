package kr.co.project.restaurantreservesystem.interfaces;

import kr.co.project.restaurantreservesystem.application.MenuItemService;
import kr.co.project.restaurantreservesystem.domain.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @GetMapping("/restaurants/{restaurantId}/menuitems")
    public List<MenuItem> list(@PathVariable Long restaurantId) {
        return menuItemService.getMenuItems(restaurantId);
    }

    @PatchMapping("restaurants/{restaurantsId}/menuitems")
    public String bulkUpdate(
            @PathVariable("restaurantsId") Long restaurantsId,
            @RequestBody List<MenuItem> menuItems
    ) {
        menuItemService.bulkUpdate(restaurantsId, menuItems);

        return "";
    }

}
