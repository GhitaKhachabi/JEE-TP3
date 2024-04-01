package ma.emsi.hopital.Repositories;

import ma.emsi.hopital.Entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PatientRepository extends JpaRepository<Patient,Long> {

    Page<Patient> findByNameContains(String Keyword, Pageable Pageable);

    @Query("select P from Patient P where P.Name like :x")
    Page<Patient> Chercher(@Param("x") String Keyword, Pageable Pageable);
}
