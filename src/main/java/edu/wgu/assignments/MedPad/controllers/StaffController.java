package edu.wgu.assignments.MedPad.controllers;

import edu.wgu.assignments.MedPad.Entities.Patient;
import edu.wgu.assignments.MedPad.repository.PtRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private PtRepo ptRepo;

    @GetMapping("/home")
    public String stindex() {
        return "This is the staff page";
    }

    @GetMapping("/patients")
    public List<Patient> getPatients() {
        return ptRepo.findAll();
    }

    @PostMapping("/add")
    public String addPatient(@RequestBody Patient patient) {
        ptRepo.saveAndFlush(patient);
        return "Patient added";
    }
    
}
