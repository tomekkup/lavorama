/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.tomekkup.lavorama.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import pl.tomekkup.lavorama.model.base.VersionedEntity;
import pl.tomekkup.lavorama.model.enums.ClaimStatus;

/**
 *
 * @author tomek
 */
@Getter
@Setter
@Entity
public class Claim extends VersionedEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "policy_id")
    private Policy policy;
    
    @Column
    @Enumerated(EnumType.STRING)
    private ClaimStatus status;
    
    @Column
    private String number;

    @Column
    @Temporal(TemporalType.DATE)
    private LocalDate registeredAt;

    @Column
    private String description;
 
    @Column
    private BigDecimal damageAmount;
    
}