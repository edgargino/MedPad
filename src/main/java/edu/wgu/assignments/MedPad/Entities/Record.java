package edu.wgu.assignments.MedPad.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

@Entity
@NoArgsConstructor
@Data
@Table(name = "records")
public class Record implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private int facilityId;

    @NonNull
    private Long ptId;

    @NonNull
    private String chiefComplaint;

    private int weight;

    private int height;

    private int temperature;

    private String bloodPressure;

    private String humidity;

    private String notes;

    private String diagnosis;

    private String medications;
}
