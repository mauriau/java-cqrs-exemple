package com.techeventscare.application.user.handler;

import com.techeventscare.application.user.query.GetUserByIdQuery;
import com.techeventscare.domain.user.User;
import com.techeventscare.domain.user.UserRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
public class GetUserByIdQueryHandler {
    private final UserRepository userRepository;

    public GetUserByIdQueryHandler(UserRepository repo) {
        this.userRepository = repo;
    }

    public User handle(GetUserByIdQuery query) throws ChangeSetPersister.NotFoundException {
        return userRepository.findById(query.userId())
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }
}
