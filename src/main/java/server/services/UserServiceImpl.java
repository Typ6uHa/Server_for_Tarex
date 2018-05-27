package server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import server.forms.UserForm;
import server.model.Role;
import server.model.State;
import server.model.User;
import server.repositories.anton_app.UsersRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void signUp(UserForm userForm) {
        String hashPassword = passwordEncoder.encode(userForm.getPassword());
        User user = User.builder()
                .firstName(userForm.getFirst_name())
                .lastName(userForm.getLast_name())
                .hashPassword(hashPassword)
                .login(userForm.getLogin())
                .role(Role.USER)
                .state(State.ACTIVE)
                .phoneNumber(userForm.getPhoneNumber())
                .build();
        usersRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public User findOne(Long userId) {
        return usersRepository.findOne(userId);
    }
}