package com.techeventscare.user.application.handler;

import com.techeventscare.common.application.handler.QueryHandler;
import com.techeventscare.user.application.query.GetAllUsersQuery;
import com.techeventscare.user.domain.User;
import com.techeventscare.user.domain.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllUsersQueryHandler implements QueryHandler<GetAllUsersQuery, List<User>> {

    private final UserRepository userRepository;

    public GetAllUsersQueryHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> handle(GetAllUsersQuery query) {
       return userRepository.findAll();
    }

}
