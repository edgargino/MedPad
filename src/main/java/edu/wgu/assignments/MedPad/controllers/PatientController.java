package edu.wgu.assignments.MedPad.controllers;

import edu.wgu.assignments.MedPad.Entities.Credentials;
import edu.wgu.assignments.MedPad.Entities.Patient;
import edu.wgu.assignments.MedPad.Substructure.ServiceSub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private ServiceSub serviceSub;

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

    @GetMapping("/dashboard/{id}") //incomplete
    public Patient dashboard(@PathVariable int id) { //Needs to be changed to Request body so we can hide the patient id from the URL
        Patient patient = new Patient();
        return patient;
    }


}


