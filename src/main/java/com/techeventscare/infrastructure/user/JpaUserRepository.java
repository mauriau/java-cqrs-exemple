package com.techeventscare.infrastructure.user;

import com.techeventscare.domain.user.User;
import com.techeventscare.domain.user.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class JpaUserRepository implements UserRepository {
  private final SpringDataUserRepository springDataRepo;

  public JpaUserRepository(SpringDataUserRepository springDataRepo) {
    this.springDataRepo = springDataRepo;
  }

  @Override
  public Optional<User> findByEmail(String email) {
    return springDataRepo.findByEmail(email);
  }

  @Override
  public User save(User user) {
    return springDataRepo.save(user);
  }

  @Override
  public boolean existsByEmail(String email) {
    return springDataRepo.existsByEmail(email);
  }

  @Override
  public List<User> findAll() {
    return springDataRepo.findAll();
  }

  @Override
  public Optional<User> findById(UUID id) {
    return springDataRepo.findById(id);
  }

  @Override
  public Void deleteById(UUID id) {
    springDataRepo.deleteById(id);
    return null;
  }

}