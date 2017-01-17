package de.hs_furtwangen.informatik.meldeauskunft.repository;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import de.hs_furtwangen.informatik.meldeauskunft.domain.Resident;

public class ResidentRepositoryStub implements ResidentRepository {

	List<Resident> list = Arrays.asList(new Resident("Klaus", "Maus", "street", "city", new Date()),
										new Resident("Hans", "Dampf", "gasse", "dorf", new Date()));
	
	
	
	
	public List<Resident> getResidents() {
		
		return list;
	}

}
