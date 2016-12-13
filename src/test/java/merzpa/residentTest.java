package merzpa;


import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import de.hs_furtwangen.informatik.meldeauskunft.domain.Resident;
import de.hs_furtwangen.informatik.meldeauskunft.repository.ResidentRepository;
import de.hs_furtwangen.informatik.meldeauskunft.repository.ResidentRepositoryStub;
import de.hs_furtwangen.informatik.meldeauskunft.service.BaseResidentService;
import de.hs_furtwangen.informatik.meldeauskunft.service.ResidentServiceException;

public class residentTest {
		
	private ResidentRepository stub = new ResidentRepositoryStub();
	
	@Test
	public void testGetFilteredResidentList1(){
		Resident toTest1 = new Resident();
		toTest1.setGivenName("Ha*");
		
		BaseResidentService service = new BaseResidentService();
		
		service.setResidentRepository(stub);
		List<Resident> liste1 = service.getFilteredResidentsList(toTest1);
		
		assert(liste1.size()==1);
	}
	
	@Test
	public void testGetFilteredResidentList2(){
		Resident toTest1 = new Resident("Klaus", "Maus", "street", "city", new Date());

		
		BaseResidentService service = new BaseResidentService();
		
		service.setResidentRepository(stub);
		List<Resident> liste1 = service.getFilteredResidentsList(toTest1);
		
		assert(liste1.size()==1);
	}
	@Test
	public void testGetFilteredResidentList3(){
		Resident toTest1 = new Resident();
		Resident toTest2 = new Resident();
		toTest1.setGivenName("Ha*");
		toTest2.setGivenName("Kl*");
		
		BaseResidentService service = new BaseResidentService();
		
		service.setResidentRepository(stub);
		List<Resident> liste1 = service.getFilteredResidentsList(toTest1);
		List<Resident> liste2 = service.getFilteredResidentsList(toTest2);
		
		assertEquals(liste1.size(), liste2.size());
	}
	
	@Test
	public void testGetUniqueResident1() throws ResidentServiceException{
		Resident toTest1 = new Resident();
		toTest1.setGivenName("Hans");
		
		BaseResidentService service = new BaseResidentService();
		
		service.setResidentRepository(stub);
		Resident tested= service.getUniqueResident(toTest1);
		
		assertEquals(toTest1.getGivenName(), tested.getGivenName());
		
	}
	@Test
	public void testGetUniqueResident2(){
		Resident toTest1 = new Resident();
		toTest1.setGivenName("Ha*");
		
		BaseResidentService service = new BaseResidentService();
		
		service.setResidentRepository(stub);
		try {
			Resident tested = service.getUniqueResident(toTest1);
			fail("exception nicht geworfen");
		} catch (ResidentServiceException e) {
			// TODO Auto-generated catch block
		}
	}
	@Test
	public void testGetUniqueResident3(){
		Resident toTest1 = new Resident();
		toTest1.setGivenName("ArnoNym");
		
		BaseResidentService service = new BaseResidentService();
		
		service.setResidentRepository(stub);
		try {
			Resident tested = service.getUniqueResident(toTest1);
			fail("exception nicht geworfen");
		} catch (ResidentServiceException e) {
			// TODO Auto-generated catch block
		}
	}
}
