package edu.wgu.assignments.MedPad.repository;

import edu.wgu.assignments.MedPad.Entities.Record;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RecRepo extends JpaRepository<Record, Long> {
}
