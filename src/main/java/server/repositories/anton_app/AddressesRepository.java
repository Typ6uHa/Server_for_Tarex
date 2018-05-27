package server.repositories.anton_app;

import org.springframework.data.jpa.repository.JpaRepository;
import server.model.Address;

public interface AddressesRepository extends JpaRepository<Address,Long> {
}
