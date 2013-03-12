package org.dreab8.kravmaga.model;

import java.util.Calendar;

import android.net.wifi.SupplicantState;

/**
 * @author drea
 */
public class KravMagaClass {

	public enum DayOfTheWeek {
		MONDAY("Monday"), TUESDAY("Tuesday"), WEDNESDAY("Wednesday"), THURSDAY("Thursday"), FRIDAY("Friday"), SATURDAY(
				"Saturday"), SUNDAY("Sunday");

		String day;

		DayOfTheWeek(String day) {
			this.day = day;
		}

		public String getDay() {
			return day;
		}

		public static DayOfTheWeek getFromCalendarDay(int day) {
			switch ( day ) {
			case Calendar.SUNDAY:
				return SUNDAY;
			case Calendar.MONDAY:
				return MONDAY;
			case Calendar.TUESDAY:
				return TUESDAY;
			case Calendar.WEDNESDAY:
				return WEDNESDAY;
			case Calendar.THURSDAY:
				return THURSDAY;
			case Calendar.FRIDAY:
				return FRIDAY;
			case Calendar.SATURDAY:
				return SATURDAY;
			default:
				return MONDAY;

			}
		}
		
		public static DayOfTheWeek getFromPosition(int day) {
			switch ( day ) {
			case 6:
				return SUNDAY;
			case 0:
				return MONDAY;
			case 1:
				return TUESDAY;
			case 2:
				return WEDNESDAY;
			case 3:
				return THURSDAY;
			case 4:
				return FRIDAY;
			case 5:
				return SATURDAY;
			default:
				return MONDAY;

			}
		}

	}

	public enum Level {
		P1("P1"), P2("P2"), ALL_LEVELS("All Grades"), P3_P4("P3-P4"), P3_G4("P3-G4"), P1_P2("P1-P2"), WOMEN("Women"), ALL_LEVELS_2_STUDIOS(
				"All Grades 2 Studios");

		String level;

		Level(String level) {
			this.level = level;
		}

		public String getLevel() {
			return level;
		}

	};

	private Venue Venue;

	private Level level;

	private DayOfTheWeek dayOfTheWeek;

	private String from;

	private String to;

	public KravMagaClass(Venue venue, Level level, DayOfTheWeek dayOfTheWeek, String from, String to) {
		super();
		Venue = venue;
		this.level = level;
		this.dayOfTheWeek = dayOfTheWeek;
		this.from = from;
		this.to = to;
	}

	public Venue getVenue() {
		return Venue;
	}

	public void setVenue(Venue venue) {
		Venue = venue;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public DayOfTheWeek getDayOfTheWeek() {
		return dayOfTheWeek;
	}

	public void setDayOfTheWeek(DayOfTheWeek dayOfTheWeek) {
		this.dayOfTheWeek = dayOfTheWeek;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getTime() {
		return from + " - " + to;
	}

}
