package com.techeventscare.application.user.handler;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String email) {
        super("Un utilisateur existe déjà avec l'email : " + email);
    }
}
