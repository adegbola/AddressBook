/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBook.dao;

import AddressBook.dto.Address;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Kelsey
 */
public class AddressBookDaoFileImpl implements AddressBookDao {

    public static final String AddressBook = "address.txt";
    public static final String Delimeter = "::";

    private void loadAddress() throws AddressBookDaoFileException {
        Scanner scan;
        try {
            scan = new Scanner(new BufferedReader(new FileReader(AddressBook)));
        } catch (FileNotFoundException e) {
            throw new AddressBookDaoFileException(e.getMessage());
        }
        String currentLine;
        String[] currentToken;
        while (scan.hasNext()) {
            currentLine = scan.nextLine();
            currentToken = currentLine.split(Delimeter);
            Address address = new Address(currentToken[0]);
            address.setFirstName(currentToken[1]);
            address.setLastName(currentToken[2]);
            address.setStreet(currentToken[3]);
            address.setCity(currentToken[4]);
            address.setState(currentToken[5]);
            address.setZipCode(currentToken[6]);

            addresses.put(address.getAddressId(), address);

        }
        scan.close();
    }

    private void writeAddress() throws AddressBookDaoFileException {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(AddressBook));
        } catch (IOException e) {
            throw new AddressBookDaoFileException("could not save date to file ", e);
        }

        List<Address> addressList = this.getAllAddress();
        for (Address address : addressList) {
            out.println(address.getAddressId() + Delimeter
                    + address.getFirstName() + Delimeter
                    + address.getLastName() + Delimeter
                    + address.getStreet() + Delimeter
                    + address.getCity() + Delimeter
                    + address.getState() + Delimeter
                    + address.getZipCode());
            out.flush();

        }
        out.close();
    }

    private Map<String, Address> addresses = new HashMap<>();

    @Override
    public Address addAddress(String addressId, Address address) throws AddressBookDaoFileException{
        Address newAddress = addresses.put(addressId, address);
        writeAddress();
        return newAddress;
    }

    @Override
    public List<Address> getAllAddress() throws AddressBookDaoFileException{
        loadAddress();
        return new ArrayList<>(addresses.values());
    }

    @Override
    public Address getAddress(String addressId) throws AddressBookDaoFileException{
        loadAddress();
        return addresses.get(addressId);
    }

    @Override
    public Address editAddress(String addressId, Address newAddress) throws AddressBookDaoFileException{
        Address editAddress = addresses.put(addressId, newAddress);
        writeAddress();
        return editAddress;

    }

    @Override
    public Address searchAddressByLastName(String lastName) throws AddressBookDaoFileException{
        // return addresses.get(lastName);
        if (addresses.containsValue(lastName)) {
            loadAddress();
            return addresses.get(lastName);
        }
        return null;

    }

    @Override
    public Address removedAddress(String addressId) throws AddressBookDaoFileException{
        Address removedAddress = addresses.remove(addressId);
        writeAddress();
        return removedAddress;
    }

}
