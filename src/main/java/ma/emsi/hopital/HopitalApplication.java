package ma.emsi.hopital;

import ma.emsi.hopital.entities.Patient;
import ma.emsi.hopital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class HopitalApplication implements CommandLineRunner {

	@Autowired
	private PatientRepository PatientRepository;

	public static void main(String[] args) {
		SpringApplication.run(HopitalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		PatientRepository.save(new Patient(null,"Mohamed",new Date(),false,23));
		PatientRepository.save(new Patient(null,"Hanane",new Date(),false,21));
		PatientRepository.save(new Patient(null,"Imane",new Date(),true,34));

	}
}
