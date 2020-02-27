package kr.co.project.restaurantreservesystem.application;

public class EmailExistedException extends RuntimeException {

    EmailExistedException(String email) {
        super("Email is already registerd: " + email);
    }

}
