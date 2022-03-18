package com.maxence.medicale.patient.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.maxence.medicale.patient.models.Coord;
import com.maxence.medicale.patient.models.Medecin;
import com.maxence.medicale.patient.models.Patient;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


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
        return listPatient;
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

    @PostMapping("/medecin/nearest/{speciality}")
    public Object nearestMedecin(@RequestBody Coord json, @PathVariable String speciality){

        String url1 = "http://localhost:8081/mdubuche27/medecin/nearest/" + speciality;
        RestTemplate restTemplate = new RestTemplate();
        Object obj = restTemplate.postForObject(url1, json, Object.class);
    
		if (Objects.isNull(obj)) {
			return null;
		}

		return obj;
    }

    @PostMapping("/addpatient/{patientId}")
    public Object selectMedecin(@RequestBody Medecin json, @PathVariable int patientId){

        String url1 = "http://localhost:8081/mdubuche27/medecin/addpatient/" + patientId;
        RestTemplate restTemplate = new RestTemplate();
        Object obj = restTemplate.postForObject(url1, json, Object.class);
    
		if (Objects.isNull(obj)) {
			return null;
		}

		return obj;
    }
} 
