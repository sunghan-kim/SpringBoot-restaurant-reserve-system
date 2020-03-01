package kr.co.project.restaurantreservesystem.interfaces;

import lombok.Data;

@Data
public class SessionRequestDto {

    private String email;
    private String password;

}
