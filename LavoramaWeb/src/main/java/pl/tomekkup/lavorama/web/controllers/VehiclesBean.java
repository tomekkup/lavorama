package pl.tomekkup.lavorama.web.controllers;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import org.springframework.stereotype.Component;
import pl.tomekkup.lavorama.service.repositories.VehicleRepository;
import pl.tomekkup.lavorama.model.Vehicle;
/**
 *
 * @author tomek
 */
@Component
@ViewScoped
public class VehiclesBean implements Serializable{
    
    @Inject
    private VehicleRepository repository;
    
    public Iterable<Vehicle> listAll() {
        return repository.findAll();
    }
}
