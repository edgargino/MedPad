package edu.wgu.assignments.MedPad.repository;

import edu.wgu.assignments.MedPad.Entities.Facility;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacRepo extends JpaRepository<Facility, Long> {

}
