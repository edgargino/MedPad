package edu.wgu.assignments.MedPad.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Entity
@NoArgsConstructor
@Data
public class Credentials {

    @Id
    @GeneratedValue
    private int id;

    @NonNull
    private String username;

    @NonNull
    private String password;

}
