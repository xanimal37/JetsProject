package com.skilldistillery.entities;

public abstract class Jet {

	protected String model;
	protected double speed;
	protected int range;
	protected long price;
	
	//setters
	public void setModel(String model) {
		this.model = model;
	}
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public void setRange(int range) {
		this.range = range;
	}
	
	public void setPrice(long price) {
		this.price = price;
	}
	
	//getters
	public String getModel() {
		return model;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	public int getRange() {
		return range;
	}
	
	//use this to calculate flight time for the jet
	public double getFlightTime() {
		double flightTime = getRange()/getSpeed();
		return flightTime;
	}
	
	
	//this method must be overridden by every jet
	public abstract void fly();
	
	public String toString() {
		return model +" - " + speed + " mph - " + range + " miles - $" + price;
	}
}
