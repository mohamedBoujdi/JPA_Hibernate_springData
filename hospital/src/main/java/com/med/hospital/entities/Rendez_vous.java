package com.med.hospital.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Rendez_vous {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY) //dans le cas d'un id string
    private String id;
    @Temporal(TemporalType.DATE)
    private Date dateRendez_vous;
    private  StatutRDV statutRDV;
    @ManyToOne
    private Medicine medecin;
    @ManyToOne
    private Patient patient;
    @OneToOne
    private Consultation consultation;
}
