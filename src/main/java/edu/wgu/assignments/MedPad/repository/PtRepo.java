package edu.wgu.assignments.MedPad.repository;

import edu.wgu.assignments.MedPad.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PtRepo extends JpaRepository <Patient, Long> {

}
