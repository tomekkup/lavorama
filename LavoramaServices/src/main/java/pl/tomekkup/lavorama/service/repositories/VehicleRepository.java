package pl.tomekkup.lavorama.service.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.tomekkup.lavorama.model.Vehicle;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {

    void deleteById(Long id);
}
