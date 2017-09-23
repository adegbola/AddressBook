/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBook.UI;

import AddressBook.dto.Address;
import java.util.List;

/**
 *
 * @author Kelsey
 */
public class AddressBookView {

    UserIO io;

    public AddressBookView(UserIO io) {
        this.io = io;
    }

    public int getMenuSelection() {
        io.print("Main Menu");
        io.print("1.Add an Address");
        io.print("2.List all Addresses");
        io.print("3.View an Address");
        io.print("4.Edit an Address");
        io.print("5.Return count of all Addresses");
        io.print("6.Find an Address by LastName");
        io.print("7.Remove an Address");
        io.print("8.Exit");
        return io.readInt("Please select your choice", 1, 8);
    }

    public Address addnewAddress() {
        String addressId = io.readString("Enter the Address Number");
        String firstName = io.readString("Enter FirstName");
        String lastName = io.readString("Enter LastName");
        String street = io.readString("Enter street Name");
        String city = io.readString("Enter city");
        String state = io.readString("Enter state");
        String zipCode = io.readString("Enter zipCode");

        Address newAddress = new Address(addressId);
        newAddress.setFirstName(firstName);
        newAddress.setLastName(lastName);
        newAddress.setStreet(street);
        newAddress.setCity(city);
        newAddress.setState(state);
        newAddress.setZipCode(zipCode);
        return newAddress;

    }

    public void listAddress(List<Address> addressList) {
        for (Address address : addressList) {
            io.print(address.getAddressId() + ":"
                    + address.getFirstName() + ""
                    + address.getLastName() + ""
                    + address.getStreet() + ""
                    + address.getCity() + ""
                    + address.getState() + ""
                    + address.getZipCode());

        }
        io.readString("Hit enter to continue");

    }

    public String getAddressIdChoice() {
        return io.readString("Please enter the Student ID.");
    }

    public void getAddress(Address address) {
        if (address != null) {
            io.print(address.getAddressId());
            io.print(address.getFirstName() + " " + address.getLastName());
            io.print(address.getCity());
            io.print(address.getState());
            io.print(address.getZipCode());
        } else {
            io.print("No such Address");
        }
        io.readString("Please hit enter to continue.");

    }

    public void unKnownCommand() {
        io.print("Unknown Command");
    }

    public void exitMessage() {
        io.print("Good Bye");

    }

    public String getLastName() {
        return io.readString("Please enter the lastName to search");

    }

    public void createAddressBanner() {
        io.print("===Create Address===");
    }

    public void successBanner() {
        io.readString("Address successfully created. Hit Enter to continue");

    }

    public void editAddressBanner() {
        io.print("===Edit Address");
    }

    public void editSuccessBanner() {
        io.readString("Address successfully edited. Hit Enter to continue");

    }

    public void removeAddressBanner() {
        io.print("==Remove Address==");
    }

    public void removeSuccessBanner() {
        io.readString("Address remove successfully");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

}
