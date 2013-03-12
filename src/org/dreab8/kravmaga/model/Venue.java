package org.dreab8.kravmaga.model;

import org.dreab8.kravmaga.model.Venues.VenueNames;

/**
 * @author drea
 */
public class Venue {
	
	public enum Regions {LONDON, ESSEX, HERTFORDSHIRE,KENT};
	
	private Regions region;
	
	private VenueNames venueName;

	private String gymName;
	
	private String address;
	
	private String postalCode;
	
	private String city;
	
	public Venue( VenueNames venueName, Regions region, String gymName, String address, String postalCode, String city) {
		super();
		this.region = region;
		this.venueName = venueName;
		this.gymName = gymName;
		this.address = address;
		this.postalCode = postalCode;
		this.city = city;
	}

	public String getGymName() {
		return gymName;
	}

	public void setGymName(String gymName) {
		this.gymName = gymName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Regions getRegion() {
		return region;
	}

	public void setRegion(Regions region) {
		this.region = region;
	}

	public String getVenueName() {
		return venueName.getName();
	}

	public void setVenueName(VenueNames venueName) {
		this.venueName = venueName;
	}
}
