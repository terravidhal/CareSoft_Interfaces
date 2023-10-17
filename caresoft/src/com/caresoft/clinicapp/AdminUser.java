package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
	// MEMBERS VARIABLES
	private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents;
    
    // TO DO: Implement a constructor that takes an ID and a role
    // CONSTRUCTOR
    public AdminUser(Integer ID, String role) {
    	super(ID);
    	this.role = role; 	
      	this.securityIncidents = new ArrayList<String>();
    }
    
    
    // TO DO: Implement HIPAACompliantUser!
    // method 1
    public boolean assignPin(int pin) {  
    	if(pin < 1e5 ) {  // 1e5 = 1 * (10 ^ 5) => 100000 (6 chiffres)
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
    	//creates an incident report
    	this.authIncident();
    	return false;
    }
    
    // TO DO: Implement HIPAACompliantAdmin!
       // method 1
    public ArrayList<String> reportSecurityIncidents() {
    	return this.securityIncidents;
    }
    
    
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
    
    // TO DO: Setters & Getters
    public Integer getEmployeeID() {
		return this.employeeID;
	}
    public String getRole() {
		return this.role;
	}
    public ArrayList<String> getSecurityIncidents() {
		return this.securityIncidents;
	}
    
	public void setEmployeeID(Integer id) {
		this.employeeID = id;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}
}
