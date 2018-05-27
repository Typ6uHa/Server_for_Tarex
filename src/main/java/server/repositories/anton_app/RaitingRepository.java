package server.repositories.anton_app;

import org.springframework.data.jpa.repository.JpaRepository;
import server.model.Rating;

public interface RaitingRepository extends JpaRepository<Rating, Long> {
}
