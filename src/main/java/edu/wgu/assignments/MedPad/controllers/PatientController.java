package edu.wgu.assignments.MedPad.controllers;

import edu.wgu.assignments.MedPad.Entities.Credentials;
import edu.wgu.assignments.MedPad.Entities.Patient;
import edu.wgu.assignments.MedPad.Entities.Record;
import edu.wgu.assignments.MedPad.Substructure.PtPack;
import edu.wgu.assignments.MedPad.Substructure.ServiceSub;
import edu.wgu.assignments.MedPad.repository.PtRepo;
import edu.wgu.assignments.MedPad.repository.RecRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private ServiceSub serviceSub;
    @Autowired
    private PtRepo ptRepo;
    @Autowired
    private RecRepo recRepo;

    @GetMapping("/home") //incomplete
    public Patient ptindex(@RequestBody Credentials credentials) {
        Patient patient = new Patient();
        return patient;
    }

    @PostMapping("/register") //Incomplete
    public HttpStatus httpStatus(@RequestBody Patient patient, Credentials creds){
        if(serviceSub.newPt(patient, creds)){
            return HttpStatus.CREATED;
        } else {
            return HttpStatus.BAD_REQUEST;
        }
    }

    @GetMapping("/login") //Incomplete
    public HttpStatus httpLogin(@RequestBody Credentials credential){
        return HttpStatus.OK;
    }

    @GetMapping("/dashboard") //incomplete
    public PtPack dashboard(@RequestBody int id) { //Needs to be changed to Request body so we can hide the patient id from the URL
        Patient patient = new Patient();
        Optional<Patient> pt = ptRepo.findById(id);
        patient = pt.get();
        List<Record> rec = new ArrayList<>();
        List<Record> records = recRepo.findAll();
        for(Record r : records){
            if(r.getPtId() == id){
                rec.add(r);
            }
        }
        if(patient.getEmail().isEmpty() || rec.isEmpty()){
            return null;
        } else {
            return new PtPack(patient, rec);
        }

    }


}


