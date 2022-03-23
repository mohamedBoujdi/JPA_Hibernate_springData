package com.med.hospital.web;

import com.med.hospital.entities.Patient;
import com.med.hospital.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //ou @Controller
public class PatientRestController {
    @Autowired  // n'est pas recommendé mieux d'utiliser constrecture
    private PatientRepository patientRepository;// ici c'est mieux d'utiliser service

    @GetMapping("/patients")
    List<Patient> PatientList(){
        return patientRepository.findAll();
    }
    @GetMapping("/{name}")
    String bienvenue(@PathVariable String name){
        return "salam alikom "+name;
    }
}
