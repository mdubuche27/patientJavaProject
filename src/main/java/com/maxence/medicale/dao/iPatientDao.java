package com.maxence.medicale.dao;

import java.util.List;

import com.maxence.medicale.patient.models.Patient;

public interface iPatientDao {

    List<Patient> getAll();
    Patient getById(int id);

}
