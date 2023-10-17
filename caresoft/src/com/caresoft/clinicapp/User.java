package com.caresoft.clinicapp;


public class User {
	//MEMBERS VARIABLES
	protected Integer id;
    protected int pin;
    
    // CONSTRUCTOR
    public User() {
    	
    }
    //OVERLOADED CONSTRUCTOR
    public User(int id) {
    	this.id = id;
    }
    
    // SETTERS AND GETTERS
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getPin() {
		return this.pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
}
