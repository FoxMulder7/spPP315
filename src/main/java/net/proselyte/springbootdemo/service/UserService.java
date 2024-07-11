package net.proselyte.springbootdemo.service;

import net.proselyte.springbootdemo.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    List<User> findAll();
    Optional<User> getById(Long id);
    User findUserByUsername(String username);

    void save(User user);

    void deleteById(Long id);

    void update(User user);

    @Override
    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;
}