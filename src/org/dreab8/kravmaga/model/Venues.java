package org.dreab8.kravmaga.model;

import java.util.HashMap;
import java.util.Map;

import org.dreab8.kravmaga.model.Venue.Regions;

public class Venues {

	public enum VenueNames {
		GREATPORTLAND("Great Portland Street"), MONUMENT("Monument"), LIVERPOOLSTREET("Liverpool Street"), BARBICAN(
				"Barbican"), HOLBORN("Holborn"), MOORGATE("Moorgate"), BANK("Bank"), HAMMERSMITH("Hammersmith"), COVENTGARDEN(
				"Covent Garden"), CANARYWARF("Canary Wharf"), MARYLEBONE("Marylebone");

		String name;

		VenueNames(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

	}

	private static Map<VenueNames, Venue> venues = new HashMap<VenueNames, Venue>();

	static {
		Venue greatPortlandStreet = new Venue( VenueNames.GREATPORTLAND, Regions.LONDON,
				"All Souls Clubhouse Sports Hall", "141 Cleveland Street", "W1T 6QG", "London" );
		Venue monument = new Venue( VenueNames.MONUMENT, Regions.LONDON, "Fitness First Health Club",
				"55 Gracechurch Street", "EC3V 0EE", "London" );
		Venue liverpoolStreet = new Venue( VenueNames.LIVERPOOLSTREET, Regions.LONDON, "Fitness First Health Club",
				"9 Devonshire Square", "EC2M 04WY", "London" );
		Venue barbican = new Venue( VenueNames.BARBICAN, Regions.LONDON, "Golden Lane Sport & Fitness", "Fann Street",
				"EC1Y 0SH", "London" );
		Venue holborn = new Venue( VenueNames.HOLBORN, Regions.LONDON, "LA Fitness Health Club",
				"Lacon House 84 Theobalds", "WC1X 8RW", "London" );
		Venue moorgate = new Venue( VenueNames.MOORGATE, Regions.LONDON, "LA Fitness Health Club", "48 London Wall",
				"EC2M 5Q", "London" );
		Venue bank = new Venue( VenueNames.BANK, Regions.LONDON, "Gymbox Health Club", "71 Lombard Street", "EC3V 9AY",
				"London" );
		Venue hammersmith = new Venue( VenueNames.HAMMERSMITH, Regions.LONDON,
				"Hammersmith & Fulham Fitness & Squash Centre", "Chalkhill Road Hammersmith", "W6 8DW", "London" );

		Venue coventGarden = new Venue( VenueNames.COVENTGARDEN, Regions.LONDON, "Gymbox Health Club",
				"42-49 St Martins Lane", "WC2N 4EJ", "London" );

		Venue canaryWarf = new Venue( VenueNames.CANARYWARF, Regions.LONDON, "LA Fitness Health Club",
				"Hertsmere Road West India Quay", "E14 4AN", "London" );

		Venue marylebone = new Venue( VenueNames.MARYLEBONE, Regions.LONDON, "LA Fitness Health Club",
				"7 Balcombe Street", "NW1 6NA", "London" );

		venues.put( VenueNames.GREATPORTLAND, greatPortlandStreet );
		venues.put( VenueNames.MONUMENT, monument );
		venues.put( VenueNames.LIVERPOOLSTREET, liverpoolStreet );
		venues.put( VenueNames.BARBICAN, barbican );
		venues.put( VenueNames.HOLBORN, holborn );
		venues.put( VenueNames.MOORGATE, moorgate );
		venues.put( VenueNames.BANK, bank );
		venues.put( VenueNames.HAMMERSMITH, hammersmith );
		venues.put( VenueNames.COVENTGARDEN, coventGarden );
		venues.put( VenueNames.CANARYWARF, canaryWarf );
		venues.put( VenueNames.MARYLEBONE, marylebone );
	}

	public Venue getVenue(VenueNames venueName) {
		return venues.get( venueName );
	}
}
