package com.techeventscare.user.application.handler;

import com.techeventscare.common.application.handler.CommandHandler;
import com.techeventscare.user.application.command.CreateUserCommand;
import com.techeventscare.user.domain.User;
import com.techeventscare.user.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserHandler implements CommandHandler<CreateUserCommand, User> {

    @Autowired
    private final UserRepository userRepository;

    public CreateUserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User handle(CreateUserCommand command) {
        if(userRepository.existsByEmail(command.email())) {
            throw new UserAlreadyExistsException(command.email());
        }
        User user = new User(null,command.username(), command.email(), command.password());

        return userRepository.save(user);
    }

}
