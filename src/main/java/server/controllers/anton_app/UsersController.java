package server.controllers.anton_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.model.User;
import server.repositories.anton_app.TokensRepository;
import server.repositories.anton_app.UsersRepository;

import java.util.Optional;

@RestController
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private TokensRepository tokensRepository;

    @PostMapping("/user/{token}")
    public Optional<User> getUser(@PathVariable("token") String token){
        Long id;
        if(tokensRepository.findFirstByValue(token).isPresent()) {
            id = tokensRepository.findFirstByValue(token).get().getUser().getId();
        } else {
            id = 1L;
        }
        System.out.println(id);
        return usersRepository.findOneById(id);
    }
}
