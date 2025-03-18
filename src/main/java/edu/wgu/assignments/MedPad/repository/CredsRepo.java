package edu.wgu.assignments.MedPad.repository;

import edu.wgu.assignments.MedPad.Entities.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredsRepo extends JpaRepository<Credentials, Long> {
}
