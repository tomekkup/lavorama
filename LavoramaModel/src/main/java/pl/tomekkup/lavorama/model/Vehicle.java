package pl.tomekkup.lavorama.model;

import pl.tomekkup.lavorama.model.media.*;
import lombok.Getter;
import lombok.Setter;
import pl.tomekkup.lavorama.model.base.AuditEntity;

import jakarta.persistence.*;
import java.util.List;
import pl.tomekkup.lavorama.model.enums.VehicleBrand;

@Entity
@Getter
@Setter
public class Vehicle extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    
    @Enumerated(EnumType.STRING)    
    private VehicleBrand brand;
    
    @Column
    private String model;
    
    @Column
    private int manufactureYear;
    
    @Column
    private String vin;
    
    @Column
    private String registrationNum;

    @OneToMany(mappedBy = "vehicle", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @OrderBy("createdDate desc")
    private List<Photo> photos;
    
    
}