package edu.wgu.assignments.MedPad.Substructure;

import edu.wgu.assignments.MedPad.Entities.Patient;
import edu.wgu.assignments.MedPad.Entities.Record;

import java.util.List;

public class PtPack {

    private Patient patient;

    private List<Record> ptrecords;

    public PtPack(Patient patient, List<Record> ptrecords) {
        this.patient = patient;
        this.ptrecords = ptrecords;
    }
}
