/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBook.dao;

import AddressBook.dto.Address;
import java.util.List;

/**
 *
 * @author Kelsey
 */
public interface AddressBookDao {
    Address addAddress(String addressId, Address address)throws AddressBookDaoFileException;
    List<Address> getAllAddress()throws AddressBookDaoFileException;
    Address getAddress(String addressId)throws AddressBookDaoFileException;
    Address editAddress(String addressId, Address newAddress)throws AddressBookDaoFileException;
    Address searchAddressByLastName(String lastName)throws AddressBookDaoFileException;
    Address removedAddress(String addressId)throws AddressBookDaoFileException;
    
}
