package edu.wgu.assignments.MedPad.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "facilities")
public class Facility {

    @Id
    @GeneratedValue
    private int id;

    private String facilityName;

    private String facilityDescription;
}
