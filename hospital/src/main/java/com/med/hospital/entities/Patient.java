package com.med.hospital.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Temporal(TemporalType.DATE)
    private Date date_naissance;
    private  Boolean malade;
    @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY)
   // @JoinColumn(name = "patient_FK")
    @ToString.Exclude
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Rendez_vous> rendez_vouscollection;

}
