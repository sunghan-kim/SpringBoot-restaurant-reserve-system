package kr.co.project.restaurantreservesystem.domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserTests {

    @Test
    public void creation() {
        User user = User.builder()
                .email("tester@example.com")
                .name("Tester")
                .level(100L)
                .build();

        assertThat(user.getName(), is("Tester"));
        assertThat(user.isAdmin(), is(true));
        assertThat(user.isActive(), is(true));

        user.deactivate();

        assertThat(user.isActive(), is(false));
    }

    @Test
    public void accessTokenWithPassword() {
        User user = User.builder().password("ACCESSTOKEN").build();

        assertThat(user.getAccessToken(), is("ACCESSTOKE"));
    }

    @Test
    public void accessTokenWithoutPassword() {
        User user = new User();

        assertThat(user.getAccessToken(), is(""));
    }

}