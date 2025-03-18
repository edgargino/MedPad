package edu.wgu.assignments.MedPad.controllers;

import edu.wgu.assignments.MedPad.Entities.Patient;
import edu.wgu.assignments.MedPad.Substructure.PtPack;
import edu.wgu.assignments.MedPad.Substructure.ServiceSub;
import edu.wgu.assignments.MedPad.repository.PtRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/addPatient")
    public HttpStatus addPatient(@RequestBody Patient patient) {
        try{

            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.UNAUTHORIZED;
        }
    }

    @GetMapping("/practice")
    public List<Patient> testadds(){
        ServiceSub.info();
        return ptRepo.findAll();
    }
    
}
