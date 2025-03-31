package pl.tomekkup.lavorama.model;

import pl.tomekkup.lavorama.model.media.*;
import lombok.Getter;
import lombok.Setter;
import pl.tomekkup.lavorama.model.base.AuditEntity;

import jakarta.persistence.*;
import java.util.List;
import pl.tomekkup.lavorama.model.base.VersionedEntity;

@Entity
@Getter
@Setter
public class Customer extends VersionedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    
    @Column
    private String address;

    @Column
    private String taxIdNumber;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Vehicle> vehicles;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Policy> policies;
    
}