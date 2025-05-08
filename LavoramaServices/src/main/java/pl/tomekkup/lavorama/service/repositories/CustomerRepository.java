package pl.tomekkup.lavorama.service.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.tomekkup.lavorama.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    void deleteById(Long id);
}
