/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBook.controller;

import AddressBook.UI.AddressBookView;
import AddressBook.dao.AddressBookDao;
import AddressBook.dao.AddressBookDaoFileException;
import AddressBook.dto.Address;
import java.util.List;

/**
 *
 * @author Kelsey
 */
public class AddressBookController {
    
    AddressBookView view;
    AddressBookDao dao;
    
    public AddressBookController(AddressBookView view, AddressBookDao dao) {
        this.view = view;
        this.dao = dao;
    }
    
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {
                
                menuSelection = getMenuSelection();
                switch (menuSelection) {
                    
                    case 1:
                        addAddress();
                        break;
                    case 2:
                        listAddress();
                        break;
                    case 3:
                        getAddress();
                        break;
                    case 4:
                        editAddress();
                        break;
                    case 5:
                        //io.print("Return count of all Addresses");
                        break;
                    case 6:
                        getAddressByLastName();
                        break;
                    case 7:
                        removeAddress();
                        break;
                    case 8:
                        keepGoing = false;
                        break;
                    
                    default:
                        unknownCommand();
                        break;
                    
                }
                
            }
            exit();
        } catch (AddressBookDaoFileException e) {
            
//            view.displayErrorMessage(e.getMessage());
        }
    }
    
    private int getMenuSelection() throws AddressBookDaoFileException {
        return view.getMenuSelection();
    }
    
    private void addAddress()throws AddressBookDaoFileException {
        view.createAddressBanner();
        Address address = view.addnewAddress();
        dao.addAddress(address.getAddressId(), address);
        view.successBanner();
    }
    
    private void listAddress() throws AddressBookDaoFileException{
        List<Address> addressList = dao.getAllAddress();
        view.listAddress(addressList);
        
    }

    private void getAddress() throws AddressBookDaoFileException{
        String addressId = view.getAddressIdChoice();
        Address address = dao.getAddress(addressId);
        view.getAddress(address);
        
    }
    
    private void getAddressByLastName()throws AddressBookDaoFileException {
        String lastName = view.getLastName();
        Address address = dao.searchAddressByLastName(lastName);
        view.getAddress(address);
        
    }

    private void editAddress() throws AddressBookDaoFileException{
        view.editAddressBanner();
        String address = view.getAddressIdChoice();
        Address newAddress = dao.getAddress(address);
        view.getAddress(newAddress);
        dao.removedAddress(address);
        Address editAddress = view.addnewAddress();
        dao.editAddress(editAddress.getAddressId(), newAddress);
        view.editSuccessBanner();
        
    }

    private void removeAddress()throws AddressBookDaoFileException {
        view.removeAddressBanner();
        String addressId = view.getAddressIdChoice();
        dao.removedAddress(addressId);
        view.removeSuccessBanner();
    }

    private void unknownCommand() {
        view.unKnownCommand();
    }

    private void exit() {
        view.exitMessage();
    }
}
