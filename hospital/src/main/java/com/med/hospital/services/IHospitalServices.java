package com.med.hospital.services;

import com.med.hospital.entities.Consultation;
import com.med.hospital.entities.Medicine;
import com.med.hospital.entities.Patient;
import com.med.hospital.entities.Rendez_vous;

public interface IHospitalServices {
    Patient savePatient(Patient patient);
    Medicine saveMedecine(Medicine medicine);
    Consultation saveConsultation(Consultation consultation);
    Rendez_vous saveRendezVous(Rendez_vous rendezVous);
}
