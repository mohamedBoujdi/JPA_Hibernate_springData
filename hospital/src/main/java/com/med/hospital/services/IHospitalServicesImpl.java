package com.med.hospital.services;

import com.med.hospital.entities.Consultation;
import com.med.hospital.entities.Medicine;
import com.med.hospital.entities.Patient;
import com.med.hospital.entities.Rendez_vous;
import com.med.hospital.repositories.ConsultationRepository;
import com.med.hospital.repositories.MedicineRepository;
import com.med.hospital.repositories.PatientRepository;
import com.med.hospital.repositories.Rendez_vousRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class IHospitalServicesImpl implements IHospitalServices {
   private PatientRepository patientRepository;
   private MedicineRepository medicineRepository;
    private Rendez_vousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;
    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medicine saveMedecine(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    @Override
    public Rendez_vous saveRendezVous(Rendez_vous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }


}
