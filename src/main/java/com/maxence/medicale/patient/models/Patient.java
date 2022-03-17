package com.maxence.medicale.patient.models;

import java.io.Serializable;
import java.util.List;


public class Patient implements Serializable{

    private Integer id;
    private String name;
    private int age;
    private List<Patho> listPatho;

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Patho> getListPatho() {
		return this.listPatho;
	}

	public void setListPatho(List<Patho> listPatho) {
		this.listPatho = listPatho;
	}

    public Patient () {

    }
    public Patient (int id, String name, int age){
        this.name = name;
        this.age =age;
        this.id = id;
    }
}
