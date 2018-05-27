package server.services;

import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import server.forms.UserForm;
import server.model.Role;
import server.model.State;
import server.model.Token;
import server.model.User;
import server.repositories.anton_app.TokensRepository;
import server.repositories.anton_app.UsersRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokensRepository tokensRepository;

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

    @Override
    public Optional<User> findOne(String token) {
        Optional<Token> token1 = tokensRepository.findFirstByValue(token);
        if (token1.isPresent()){
            return usersRepository.findOneById(token1.get().getUser().getId());
        }
        throw new FatalBeanException("sosiska");
    }

    @Override
    public User findOneUser(String token) {
        Optional<Token> token1 = tokensRepository.findFirstByValue(token);
        if (token1.isPresent()){
            return usersRepository.findFirstById(token1.get().getUser().getId());
        }
        throw new FatalBeanException("sosiska");
    }
}
