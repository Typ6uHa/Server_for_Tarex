package server.services;

import server.forms.UserForm;
import server.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void signUp(UserForm userForm);

    List<User> findAll();

    User findOne(Long userId);

    Optional<User> findOne(String token);

    User findOneUser(String token);
}
