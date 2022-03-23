package com.med.hospital;

import com.med.hospital.entities.*;
import com.med.hospital.repositories.ConsultationRepository;
import com.med.hospital.repositories.MedicineRepository;
import com.med.hospital.repositories.PatientRepository;
import com.med.hospital.repositories.Rendez_vousRepository;
import com.med.hospital.services.IHospitalServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication { //implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}
    /* @Bean
	CommandLineRunner start(
			PatientRepository patientRepository,
			MedicineRepository medicineRepository,
			Rendez_vousRepository  rendezVousRepository,
			ConsultationRepository consultationRepository
	                      ){

		 return args -> {
            //List.of(.....)
			 Stream.of("hassan".toUpperCase(),"khalid","fatima","fadwa").forEach(
					 p->{
						 Patient patient=new Patient();
						 patient.setName(p);
						 patient.setDate_naissance(Date.from(Instant.now()));
						 patient.setMalade(Math.random()>0.5);
						 patientRepository.save(patient);
					 });
	         Stream.of("HHHHH","ggggg","gggggg","tttttt")
					 .forEach(
							 m->{
								 Medicine medicine=new Medicine();
								 medicine.setNom(m);
								 medicine.setEmail(m+"@gmail.com");
								 medicine.setSpecialite("chirurgien");

								 medicineRepository.save(medicine);
							 }
			                );
			 Patient patient1=patientRepository.findByName("hassan".toUpperCase());
			 Patient patient2=patientRepository.findById(3l).orElse(null);
			 //System.out.println("_______________"+patient1+"___________");
			 //System.out.println("_______________"+patient2+"___________");
			 Consultation consultation=new Consultation();
			 consultation.setDateConsultation(Date.from(Instant.now()));
			 consultation.setPrixConsulatation(2221.4);
			 consultation.setRapportConsulatation("salam alikom \n le rapport");
			 consultationRepository.save(consultation);
			 Rendez_vous rendezVous=new Rendez_vous();
			 rendezVous.setDateRendez_vous(Date.from(Instant.now()));
			 rendezVous.setStatutRDV(StatutRDV.PENDING);
			 rendezVous.setMedecin(medicineRepository.findById(1L).orElse(null));
			 rendezVous.setPatient(patientRepository.findById(1L).orElse(null));
			 rendezVous.setConsultation(consultationRepository.findById(1L).orElse(null));
			 System.out.println(rendezVousRepository.save(rendezVous));
			 //System.out.println("=======\n"+rendezVous+"\n=========");
			 //System.out.println("=======\n"+rendezVousRepository.findById(1L).orElse(null)+"\n=========");
		 };
	 }*/
	/*@Override
	public void run(String... args) throws Exception {

	}*/
	@Bean
	CommandLineRunner start(IHospitalServices iHospitalServices,Rendez_vousRepository rendezVousRepository){
		return args -> {
			//List.of(.....)
			Stream.of("hassan".toUpperCase(),"khalid","fatima","fadwa").forEach(
					p->{
						Patient patient=new Patient();
						patient.setName(p);
						patient.setDate_naissance(Date.from(Instant.now()));
						patient.setMalade(Math.random()>0.5);
						iHospitalServices.savePatient(patient);
					});
			Stream.of("HHHHH","ggggg","gggggg","tttttt","rrrrrrrrr")
					.forEach(
							m->{
								Medicine medicine=new Medicine();
								medicine.setNom(m);
								medicine.setEmail(m+"@gmail.com");
								medicine.setSpecialite("chirurgien");

								iHospitalServices.saveMedecine(medicine);
							}
					);


			Consultation consultation=new Consultation();
			consultation.setDateConsultation(Date.from(Instant.now()));
			consultation.setPrixConsulatation(2221.4);
			consultation.setRapportConsulatation("salam alikom \n le rapport");
			iHospitalServices.saveConsultation(consultation);
			Rendez_vous rendezVous=new Rendez_vous();
			rendezVous.setDateRendez_vous(Date.from(Instant.now()));
			rendezVous.setStatutRDV(StatutRDV.PENDING);
			rendezVous.setConsultation(consultation);
			Rendez_vous rendezVous2=new Rendez_vous();
			rendezVous.setDateRendez_vous(Date.from(Instant.now()));
			rendezVous.setStatutRDV(StatutRDV.CANCELED);
			rendezVous.setConsultation(consultation);
			System.out.println(iHospitalServices.saveRendezVous(rendezVous2));
			System.out.println(iHospitalServices.saveRendezVous(rendezVous));
			//System.out.println("=======\n"+rendezVous+"\n=========");
			//System.out.println("=======\n"+rendezVousRepository.findById(1L).orElse(null)+"\n=========");
		};
	}
}
