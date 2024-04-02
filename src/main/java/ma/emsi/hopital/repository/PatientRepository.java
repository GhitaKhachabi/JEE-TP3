package ma.emsi.hopital.repository;

import ma.emsi.hopital.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {

    Page<Patient> findByNomContains(String keyword, Pageable pageable);

   // @Query("select P from Patient P where P.Name like :x")
   // Page<Patient> Chercher(@Param("x") String Keyword, Pageable Pageable1);
}
