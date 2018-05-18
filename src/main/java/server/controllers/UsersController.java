package server.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.model.User;
import server.repositories.UsersRepository;

import java.util.List;

@RestController
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/users")
    public List<User> getUsers(){
        return usersRepository.findAll();
    }
}
