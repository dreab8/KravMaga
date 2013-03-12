package org.dreab8.kravmaga.model;

import java.util.ArrayList;
import java.util.List;

import org.dreab8.kravmaga.dao.KravMagaClasses;
import org.dreab8.kravmaga.model.KravMagaClass.DayOfTheWeek;

public class KravMagaInstitute {

	KravMagaClasses allClasses;

	public KravMagaInstitute() {
		allClasses = new KravMagaClasses();
	}

	public List<KravMagaClass> getKravMagaClasses(DayOfTheWeek dayOfTheWeek) {
		List<KravMagaClass> classesOnDay = allClasses.getClasses( dayOfTheWeek );
		if (classesOnDay == null){
			return new ArrayList<KravMagaClass>();
		}
		return classesOnDay;
	}

}
