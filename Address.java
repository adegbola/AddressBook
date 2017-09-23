/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBook.dto;

/**
 *
 * @author Kelsey
 */
public class Address {
    private String addressId;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String zipCode;

    public Address(String addressId, String lastName) {
        this.addressId = addressId;
        
        this.lastName = lastName;
        
    }

    public Address(String addressId) {
        this.addressId = addressId;
        
    }

    public String getAddressId() {
        return addressId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    
    
}
