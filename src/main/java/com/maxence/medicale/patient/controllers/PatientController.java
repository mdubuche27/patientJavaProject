package com.maxence.medicale.patient.controllers;

import java.util.ArrayList;
import java.util.List;

import com.maxence.medicale.patient.models.Patient;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PatientController {
    
    static List<Patient> listPatient= new ArrayList<Patient>();
    
    static {
        Patient patient1 = new Patient(1, "max", 1);
        Patient patient2 = new Patient(2, "max", 1);
        Patient patient3 = new Patient(3, "max", 1);
        Patient patient4 = new Patient(4, "max", 1);

        listPatient.add(patient1);
        listPatient.add(patient2);
        listPatient.add(patient3);
        listPatient.add(patient4);
    }

    @GetMapping("/patient/{id}")
    public Patient getPatient(@PathVariable int id) {
        
        for(int i = 0 ; i < listPatient.size(); i++){
            if (listPatient.get(i).getId() == id){
                return listPatient.get(i);
            }
        }

        return null;
    }

    @GetMapping("/patients")
    public List<Patient> getPatients(){
        Patient MyPatien = new Patient();
        MyPatien.setId(1);
        MyPatien.setAge(12);
        MyPatien.setName("le gros gégé");
        List<Patient> listPat = new ArrayList<Patient>();
        listPat.add(MyPatien);
        return listPat;
    }   

    @PutMapping("/patient/{id}")
    public Patient putPatient(@PathVariable int id){
        return null;
    }

    @PostMapping("/patient")
    public Boolean postPatient(){
        return null;
    }

    @DeleteMapping("/patient/{id}")
    public Boolean deletePatient(@PathVariable int id){
        return null;
    }
} 
