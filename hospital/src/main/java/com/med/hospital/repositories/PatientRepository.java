package com.med.hospital.repositories;

import com.med.hospital.entities.Patient;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.function.Function;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByName(String name);
}