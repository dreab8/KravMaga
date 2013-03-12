package org.dreab8.kravmaga.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dreab8.kravmaga.model.KravMagaClass;
import org.dreab8.kravmaga.model.KravMagaClass.DayOfTheWeek;
import org.dreab8.kravmaga.model.KravMagaClass.Level;
import org.dreab8.kravmaga.model.Venues;
import org.dreab8.kravmaga.model.Venues.VenueNames;

public class KravMagaClasses {

	private final Map<DayOfTheWeek, List<KravMagaClass>> allClasses = new HashMap<KravMagaClass.DayOfTheWeek, List<KravMagaClass>>();
	private Venues venue = new Venues();

	public KravMagaClasses() {
		if ( allClasses.isEmpty() ) {
			initClasses();
		}
	}

	private void initClasses() {
		allClasses.put( DayOfTheWeek.MONDAY, getMondayClasses() );
		allClasses.put( DayOfTheWeek.TUESDAY, getTuesdayClasses() );
		allClasses.put( DayOfTheWeek.WEDNESDAY, getWednesdayClasses() );
		allClasses.put( DayOfTheWeek.THURSDAY, getThursdayClasses() );
		allClasses.put( DayOfTheWeek.FRIDAY, getFridayClasses() );
		allClasses.put( DayOfTheWeek.SATURDAY, getSaturdayClasses() );
	}

	public List<KravMagaClass> getClasses(DayOfTheWeek dayOfTheWeek) {
		return allClasses.get( dayOfTheWeek );
	}

	private List<KravMagaClass> getMondayClasses() {
		List<KravMagaClass> mondayClasses = new ArrayList<KravMagaClass>();
		KravMagaClass greatPortlandClass = new KravMagaClass( venue.getVenue( VenueNames.GREATPORTLAND ),
				Level.ALL_LEVELS, DayOfTheWeek.MONDAY, "7.15 pm", "8.45 pm" );
		mondayClasses.add( greatPortlandClass );

		KravMagaClass monument = new KravMagaClass( venue.getVenue( VenueNames.MONUMENT ), Level.P1,
				DayOfTheWeek.MONDAY, "7.00 pm", "8.30 pm" );
		mondayClasses.add( monument );

		KravMagaClass liverpoolStreet = new KravMagaClass( venue.getVenue( VenueNames.LIVERPOOLSTREET ), Level.P3_P4,
				DayOfTheWeek.MONDAY, "7.00 pm", "8.30 pm" );
		mondayClasses.add( liverpoolStreet );

		return mondayClasses;
	}

	private List<KravMagaClass> getTuesdayClasses() {

		List<KravMagaClass> tuesdayClasses = new ArrayList<KravMagaClass>();

		KravMagaClass barbican = new KravMagaClass( venue.getVenue( VenueNames.BARBICAN ), Level.ALL_LEVELS,
				DayOfTheWeek.TUESDAY, "7.15 am", "8.15 am" );
		tuesdayClasses.add( barbican );

		KravMagaClass holborn = new KravMagaClass( venue.getVenue( VenueNames.HOLBORN ), Level.P3_G4,
				DayOfTheWeek.TUESDAY, "7.30 pm", "9.00 pm" );
		tuesdayClasses.add( holborn );

		KravMagaClass moorgate = new KravMagaClass( venue.getVenue( VenueNames.MOORGATE ), Level.P1,
				DayOfTheWeek.TUESDAY, "7.30 pm", "9.00 pm" );
		tuesdayClasses.add( moorgate );

		KravMagaClass liverpooStreet = new KravMagaClass( venue.getVenue( VenueNames.LIVERPOOLSTREET ), Level.P1_P2,
				DayOfTheWeek.TUESDAY, "7.00 pm", "8.30 pm" );
		tuesdayClasses.add( liverpooStreet );

		return tuesdayClasses;
	}

	private List<KravMagaClass> getWednesdayClasses() {
		List<KravMagaClass> wednesdayClasses = new ArrayList<KravMagaClass>();
		KravMagaClass bank = new KravMagaClass( venue.getVenue( VenueNames.BANK ), Level.ALL_LEVELS_2_STUDIOS,
				DayOfTheWeek.WEDNESDAY, "7.30 pm", "9.00 pm" );
		wednesdayClasses.add( bank );

		KravMagaClass hammersmith = new KravMagaClass( venue.getVenue( VenueNames.HAMMERSMITH ), Level.ALL_LEVELS,
				DayOfTheWeek.WEDNESDAY, "7.30 pm", "9.00 pm" );
		wednesdayClasses.add( hammersmith );
		return wednesdayClasses;
	}

	private List<KravMagaClass> getThursdayClasses() {
		List<KravMagaClass> thursdayClasses = new ArrayList<KravMagaClass>();
		KravMagaClass barbican = new KravMagaClass( venue.getVenue( VenueNames.BARBICAN ), Level.ALL_LEVELS,
				DayOfTheWeek.THURSDAY, "7.15 am", "8.15 am" );
		thursdayClasses.add( barbican );

		KravMagaClass monument = new KravMagaClass( venue.getVenue( VenueNames.MONUMENT ), Level.P1_P2,
				DayOfTheWeek.THURSDAY, "7.00 pm", "8.30 pm" );
		thursdayClasses.add( monument );

		KravMagaClass coventGarden = new KravMagaClass( venue.getVenue( VenueNames.COVENTGARDEN ), Level.P3_P4,
				DayOfTheWeek.THURSDAY, "7.30 pm", "9.00 pm" );
		thursdayClasses.add( coventGarden );

		KravMagaClass greatPortlandStreet = new KravMagaClass( venue.getVenue( VenueNames.GREATPORTLAND ),
				Level.ALL_LEVELS, DayOfTheWeek.THURSDAY, "7.15 pm", "8.45 pm" );
		thursdayClasses.add( greatPortlandStreet );

		return thursdayClasses;
	}

	private List<KravMagaClass> getFridayClasses() {
		List<KravMagaClass> fridayClasses = new ArrayList<KravMagaClass>();
		KravMagaClass canaryWarf = new KravMagaClass( venue.getVenue( VenueNames.CANARYWARF ), Level.ALL_LEVELS,
				DayOfTheWeek.THURSDAY, "6.30 pm", "7.45 pm" );
		fridayClasses.add( canaryWarf );

		KravMagaClass holborn = new KravMagaClass( venue.getVenue( VenueNames.HOLBORN ), Level.ALL_LEVELS_2_STUDIOS,
				DayOfTheWeek.THURSDAY, "6.45 pm", "8.15 pm" );
		fridayClasses.add( holborn );

		return fridayClasses;
	}

	private List<KravMagaClass> getSaturdayClasses() {
		List<KravMagaClass> saturdayClasses = new ArrayList<KravMagaClass>();
		KravMagaClass canaryWarf = new KravMagaClass( venue.getVenue( VenueNames.MARYLEBONE ), Level.P1_P2,
				DayOfTheWeek.SATURDAY, "11.30 pm", "1.00 pm" );
		saturdayClasses.add( canaryWarf );

		KravMagaClass canaryWarf2 = new KravMagaClass( venue.getVenue( VenueNames.MARYLEBONE ), Level.P3_G4,
				DayOfTheWeek.SATURDAY, "1.00 pm", "2.30 pm" );
		saturdayClasses.add( canaryWarf2 );

		return saturdayClasses;
	}

}
