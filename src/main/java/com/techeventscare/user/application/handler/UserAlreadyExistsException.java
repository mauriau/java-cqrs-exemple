package com.techeventscare.user.application.handler;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String email) {
        super("Un utilisateur existe déjà avec l'email : " + email);
    }
}
