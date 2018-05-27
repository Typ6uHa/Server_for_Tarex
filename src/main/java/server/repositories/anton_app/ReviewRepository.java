package server.repositories.anton_app;

import org.springframework.data.jpa.repository.JpaRepository;
import server.model.Review;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
