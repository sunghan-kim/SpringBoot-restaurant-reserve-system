package kr.co.project.restaurantreservesystem.interfaces;

import kr.co.project.restaurantreservesystem.application.MenuItemService;
import kr.co.project.restaurantreservesystem.domain.MenuItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MenuItemController.class)
public class MenuItemControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MenuItemService menuItemService;

    @Test
    public void list() throws Exception {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(MenuItem.builder().name("Kimchi").build());

        given(menuItemService.getMenuItems(1L)).willReturn(menuItems);

        mvc.perform(get("/restaurants/1/menuitems"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Kimchi")));
    }

    @Test
    public void bulkUpdate() throws Exception {
        mvc.perform(patch("/restaurants/1/menuitems")
            .contentType(MediaType.APPLICATION_JSON)
            .content("[]"))
            .andExpect(status().isOk());

        List<MenuItem> menuItems;
        verify(menuItemService).bulkUpdate(eq(1L), any());
    }

}