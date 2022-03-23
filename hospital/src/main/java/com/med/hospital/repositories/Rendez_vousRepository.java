package com.med.hospital.repositories;

import com.med.hospital.entities.Rendez_vous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Rendez_vousRepository extends JpaRepository<Rendez_vous,String> {
}