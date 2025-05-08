package pl.tomekkup.lavorama.service.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.tomekkup.lavorama.model.authentication.UserPrincipal;

import jakarta.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UserPrincipalRepository extends CrudRepository<UserPrincipal, Long> {

    @Transactional
    Optional<UserPrincipal> findByUsername(String username);

    void deleteById(Long id);
}
