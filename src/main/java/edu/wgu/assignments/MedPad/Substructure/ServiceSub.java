package edu.wgu.assignments.MedPad.Substructure;

import edu.wgu.assignments.MedPad.Entities.Credentials;
import edu.wgu.assignments.MedPad.Entities.Facility;
import edu.wgu.assignments.MedPad.Entities.Patient;
import edu.wgu.assignments.MedPad.Entities.Record;
import edu.wgu.assignments.MedPad.repository.CredsRepo;
import edu.wgu.assignments.MedPad.repository.FacRepo;
import edu.wgu.assignments.MedPad.repository.PtRepo;
import edu.wgu.assignments.MedPad.repository.RecRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ServiceSub {

    private final PtRepo ptRepo;
    private final CredsRepo credsRepo;
    private final FacRepo facRepo;
    private final RecRepo recRepo;

    @Autowired
    public ServiceSub(PtRepo ptRep, CredsRepo credsRep, FacRepo facRep, RecRepo recRepo) {
        this.ptRepo = ptRep;
        this.credsRepo = credsRep;
        this.facRepo = facRep;
        this.recRepo = recRepo;
    }

    public static void info() {
        Patient patient0 = new Patient();
        patient0.setFirstName("Henry");
        patient0.setLastName("Jones");
        patient0.setGender("Male");
        patient0.setBirthDate("7/8/2008");
        patient0.setEmail("test0@gmail.com");
        patient0.setPhoneNumber("614616834536513");

        Facility facility = new Facility();
        facility.setFacilityName("Colorado Barn");
        facility.setFacilityDescription("Healthcenter");

        Record r0 = new Record();
        r0.setBloodPressure("90/60");
        r0.setDiagnosis("Food poisoning");
        r0.setFacilityId(1);
        r0.setPtId(1);
        r0.setChiefComplaint("Stomach pain");



    }

    //To add a new patient to the database
    public boolean newPt(Patient patient, Credentials credentials) {
        List<Credentials> creds = credsRepo.findAll();
        int count = 0;
        for(Credentials c : creds) {
            if(c.getUsername().equals(credentials.getUsername())) {
                count++;
            }
        }
        if(count>0){
            return false;
        } else {
            ptRepo.saveAndFlush(patient);
            credsRepo.saveAndFlush(credentials);
            return true;
        }

    }

    //To get information for patient account
    public PtPack getCompletePatient(int id) {
        List<Patient> patients = ptRepo.findAll();
        Patient pat = new Patient();
        for(Patient p : patients) {
            if(p.getId() == id) {
                pat = p;
                break;
            }
        }
        List<Record> records = recRepo.findAll();
        List<Record> ptRecords = new ArrayList<>();

        for(Record r : records) {
            if(r.getId()==id) {
                ptRecords.add(r);
            }
        }
        if(ptRecords.isEmpty()){
            return null;
        } else {
            return new PtPack(pat,ptRecords);
        }

    }



}
