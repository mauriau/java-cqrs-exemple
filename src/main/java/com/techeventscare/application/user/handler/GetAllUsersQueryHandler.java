package com.techeventscare.application.user.handler;

import com.techeventscare.application.user.query.GetAllUsersQuery;
import com.techeventscare.domain.user.User;
import com.techeventscare.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllUsersQueryHandler {

    private final UserRepository userRepository;

    public GetAllUsersQueryHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> handle(GetAllUsersQuery query) {
       return userRepository.findAll();
    }

}
