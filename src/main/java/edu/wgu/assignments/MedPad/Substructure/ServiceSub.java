package edu.wgu.assignments.MedPad.Substructure;

import edu.wgu.assignments.MedPad.Entities.Credentials;
import edu.wgu.assignments.MedPad.Entities.Patient;
import edu.wgu.assignments.MedPad.repository.CredsRepo;
import edu.wgu.assignments.MedPad.repository.FacRepo;
import edu.wgu.assignments.MedPad.repository.PtRepo;
import edu.wgu.assignments.MedPad.repository.RecRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public PtPack getPt(Long id) {
        Patient patient = ptRepo.findById(id);


        return ptpack;
    }

}
