package com.skilldistillery.grouptravel.data;

import java.util.List;

import com.skilldistillery.grouptravel.entities.Address;
import com.skilldistillery.grouptravel.entities.Destination;

public interface AddressDao {

	public List<Destination> findAll() ;

	public Destination findDestinationById(int destinationId) ;

	public Address create(Address address);

}
