package com.skilldistillery.grouptravel.data;

import java.util.List;

import com.skilldistillery.grouptravel.entities.Address;
import com.skilldistillery.grouptravel.entities.Destination;

public interface AddressDao {

	public List<Address> findAll();

	public Address findAddressById(int addressId);

	public Address create(Address address);

	Address update(int id, Address address);

	boolean deleteById(int userId);

	Address findAddressByInfo(String street, String city, String state, String postalCode);

}
