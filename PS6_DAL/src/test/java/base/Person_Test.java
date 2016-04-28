package base;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Person_Test {
	
	private static PersonDomainModel per1;
	private static PersonDomainModel per2;
	private static PersonDomainModel per3;
	private static PersonDomainModel per4;
	private static PersonDomainModel per5;
	
	private static ArrayList<UUID> newID = new ArrayList<UUID>();
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		per1 = new PersonDomainModel("T","A","33 whatever","Here",19810, LocalDate.now());
		per2 = new PersonDomainModel("J","A","33 whatever","Here",19810, LocalDate.now());
		per3 = new PersonDomainModel("Q","A","33 whatever","Here",19810, LocalDate.now());
		per4 = new PersonDomainModel("K","A","33 whatever","Here",19810, LocalDate.now());
		per5 = new PersonDomainModel("A","A","33 whatever","Here",19810, LocalDate.now());
		
		PersonDAL.addPerson(per1);
		PersonDAL.addPerson(per2);
		PersonDAL.addPerson(per3);
		PersonDAL.addPerson(per4);
		PersonDAL.addPerson(per5);
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		
		PersonDomainModel per = PersonDAL.getPerson((UUID) per1.getPersonID());
		PersonDAL.deletePerson((UUID) per1.getPersonID());
		assertNull("DELETE", per);
		
	}

	@Test
	public void addPerson_test() {
		
		PersonDomainModel per;
		
		per = PersonDAL.getPerson((UUID) per1.getPersonID());
		assertNotNull("MISSING", per);
		PersonDAL.addPerson(per1);
		per = PersonDAL.getPerson((UUID) per1.getPersonID());
		assertNotNull("Present", per);	
	}
	
	@Test
	public void updatePerson_test(){
		
		PersonDomainModel per;
		
		per = PersonDAL.getPerson((UUID) per1.getPersonID());
		assertNotNull("MISSING", per);
		PersonDAL.addPerson(per1);
		per = PersonDAL.getPerson((UUID) per1.getPersonID());
		assertNotNull("Present", per);	
		
		per1.setFirstName("Ten");
		PersonDAL.updatePerson(per1);
		per = PersonDAL.getPerson((UUID) per1.getPersonID());
		assertEquals(per1.getFirstName(), "Ten");	
	}
	
	@Test
	public void deletePerson_test(){
		
		PersonDomainModel per;
		
		per = PersonDAL.getPerson((UUID) per1.getPersonID());
		assertNotNull("MISSING", per);
		PersonDAL.addPerson(per1);
		per = PersonDAL.getPerson((UUID) per1.getPersonID());
		assertNotNull("Present", per);
		
		PersonDAL.deletePerson((UUID) per1.getPersonID());
		per = PersonDAL.getPerson((UUID) per1.getPersonID());
		assertNull("MISSING", per);
	}

}
