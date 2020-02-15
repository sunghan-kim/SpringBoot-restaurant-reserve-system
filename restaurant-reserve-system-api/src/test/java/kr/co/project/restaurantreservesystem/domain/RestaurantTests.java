package kr.co.project.restaurantreservesystem.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


class RestaurantTests {

    @Test
    public void creation() {
        Restaurant restaurant = new Restaurant(1004L, "Bob zip", "Seoul");
        assertThat(restaurant.getId(), is(1004L));
        assertThat(restaurant.getName(), is("Bob zip")); // red cycle
        assertThat(restaurant.getAddress(), is("Seoul")); // red cycle
    }

    @Test
    public void information() {
        Restaurant restaurant = new Restaurant(1004L, "Bob zip", "Seoul");

        restaurant.setName("Sool zip");

        assertThat(restaurant.getInformation(), is("Sool zip in Seoul"));
    }

}