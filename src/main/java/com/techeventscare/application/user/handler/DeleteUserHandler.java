package com.techeventscare.application.user.handler;

import com.techeventscare.application.handler.CommandHandler;
import com.techeventscare.application.user.command.DeleteUserCommand;
import com.techeventscare.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteUserHandler implements CommandHandler<DeleteUserCommand, Void> {

    private final UserRepository userRepository;

    @Autowired
    public DeleteUserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Void handle(DeleteUserCommand command) {
        userRepository.deleteById(command.userId());
        return null;
    }
}
