package domain;


import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import util.LocalDateAdapter;

public class PersonDomainModel {

    private  StringProperty firstName;
    private  StringProperty lastName;
    private  StringProperty street;
    public Object getPersonID() {
		return PersonID;
	}

	private  StringProperty city;
    private  IntegerProperty postalCode;
    private  ObjectProperty<LocalDate> DOB;
	private Object PersonID;
	private String FirstName;
	private String LastName;
	private String Street;
	private String City;
	private int PostalCode;
	private LocalDate Birthday;

    public PersonDomainModel(String firstName, String lastName, String street, String city, int postalCode, LocalDate localDate) {
		// TODO Auto-generated constructor stub
    	this.PersonID = UUID.randomUUID();
    	this.FirstName = firstName;
    	this.LastName = lastName;
    	this.Street = street;
    	this.City = city;
    	this.PostalCode = postalCode;
    	this.Birthday = localDate;
	}

	/**
     * Default constructor.
     */


    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getStreet() {
        return street.get();
    }

    public void setStreet(String street) {
        this.street.set(street);
    }

    public StringProperty streetProperty() {
        return street;
    }

    public int getPostalCode() {
        return postalCode.get();
    }

    public void setPostalCode(int postalCode) {
        this.postalCode.set(postalCode);
    }

    public IntegerProperty postalCodeProperty() {
        return postalCode;
    }

    public String getCity() {
        return city.get();
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public StringProperty cityProperty() {
        return city;
    }

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getBirthday() {
        return Birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.Birthday = birthday;
    }

    public LocalDate birthdayProperty() {
        return Birthday;
    }
}