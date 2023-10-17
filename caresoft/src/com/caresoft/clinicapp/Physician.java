package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
	
	//MEMBERS VARIABLES
	private ArrayList<String> patientNotes;
	
	// TO DO: Constructor that takes an IDcopy
	    // CONSTRUCTOR
	    public Physician() {
	    	super();
	    }
	    // OVERLOADER CONSTRUCTOR
	    public Physician(int id) {
	        super(id);
	    }
	    
    // TO DO: Implement HIPAACompliantUser!
	    // method 1
	    public boolean assignPin(int pin) {  
	    	if(pin < 1e3 || pin > 9999) {  // Pin must be exactly 4 digits (1e3 => 1000(4 digits))
	    		return false;
	    	}
	    	else {
	    		this.setPin(pin);
	    		return true;
	    	}
	    }
	    // method 2
	    public boolean accessAuthorized(Integer id) {
	    	if(this.getId().equals(id)) {
	    		return true;
	    	}
	    	return false;
	    }
	    
	    //==============================================================
	
	public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
	
    // TO DO: Setters & Getters
	public ArrayList<String> getPatientNotes() {
		return this.patientNotes;
	}
	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}
}
