package com.med.hospital.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date dateConsultation;
    private  Double prixConsulatation;
    private  String rapportConsulatation;
    @OneToOne(mappedBy = "consultation") // by default
   // @JoinColumn(name = "consulatation_FK")
    @ToString.Exclude
    private Rendez_vous rendez_vous;
}
