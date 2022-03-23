package com.med.hospital.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Medicine {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private  Long Id;
 private String Nom;
 private String email;
 private  String specialite;
 @OneToMany(mappedBy="medecin")
 //@JoinColumn(name = "medecin_FK")
 @ToString.Exclude
 private Collection<Rendez_vous> rendez_vousCollection;

}
