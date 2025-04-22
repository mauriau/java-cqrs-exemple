package com.techeventscare.domain.user;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    Optional<User> findByEmail(String email);
    User save(User user);
    boolean existsByEmail(String email);
    List<User> findAll();
    Optional<User> findById(UUID id);
    Void deleteById(UUID id);
}