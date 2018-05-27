package server.repositories.anton_app;

import org.springframework.data.jpa.repository.JpaRepository;
import server.model.Token;
import server.model.TokenRestaurant;

import java.util.Optional;

public interface TokensRestaurantRepository extends JpaRepository<TokenRestaurant,Long> {
    Optional<Token> findFirstByValue(String value);
}
