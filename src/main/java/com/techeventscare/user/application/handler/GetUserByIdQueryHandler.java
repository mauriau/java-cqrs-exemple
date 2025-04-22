package com.techeventscare.user.application.handler;

import com.techeventscare.common.application.handler.QueryHandler;
import com.techeventscare.user.application.query.GetUserByIdQuery;
import com.techeventscare.user.domain.User;
import com.techeventscare.user.domain.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetUserByIdQueryHandler implements QueryHandler<GetUserByIdQuery, User> {
    private final UserRepository userRepository;

    public GetUserByIdQueryHandler(UserRepository repo) {
        this.userRepository = repo;
    }

    public User handle(GetUserByIdQuery query) throws EntityNotFoundException {
        Optional<User> optionalUser = userRepository.findById(query.userId());
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        throw new EntityNotFoundException("User not found");
    }
}
