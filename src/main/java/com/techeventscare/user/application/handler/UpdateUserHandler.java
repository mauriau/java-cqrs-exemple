package com.techeventscare.user.application.handler;

import com.techeventscare.common.application.handler.CommandHandler;
import com.techeventscare.user.application.command.UpdateUserCommand;
import com.techeventscare.user.domain.User;
import com.techeventscare.user.domain.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateUserHandler implements CommandHandler<UpdateUserCommand, User> {

    @Autowired
    private final UserRepository userRepository;

    public UpdateUserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User handle(UpdateUserCommand command) {
        Optional<User> userOptional = userRepository.findById(command.userId());
        if(userOptional.isEmpty()) {
            throw new EntityNotFoundException("User not found");
        }
        User user = userOptional.get();
        user.setEmail(command.email());
        user.setPassword(command.password());
        user.setUsername(command.username());

        return userRepository.save(user);
    }

}
