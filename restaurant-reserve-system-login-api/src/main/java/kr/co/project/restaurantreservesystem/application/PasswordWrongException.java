package kr.co.project.restaurantreservesystem.application;

public class PasswordWrongException extends RuntimeException{
    PasswordWrongException() {
        super("Password is wrong");
    }
}
