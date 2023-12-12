package com.skilldistillery.grouptravel.data;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.grouptravel.entities.Address;
import com.skilldistillery.grouptravel.entities.Destination;
import com.skilldistillery.grouptravel.entities.Address;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class AddressDaoImpl implements AddressDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Destination> findAll() {
		String jpql = "SELECT destination FROM Destination destination";
		return em.createQuery(jpql, Destination.class).getResultList();

	}

	@Override
	public Destination findDestinationById(int destinationId) {
		return em.find(Destination.class, destinationId);
	}

	@Override
	public Address create(Address address) {
		em.persist(address);
		return address;
	}

	@Override
	public Address update(int id, Address address) {
		Address addressFound = em.find(Address.class, id);
		if (addressFound != null) {
			addressFound.setStreet(address.getStreet());
			addressFound.setStreet2(address.getStreet2());
			addressFound.setCity(address.getCity());
			addressFound.setState(address.getState());
			addressFound.setPostalCode(address.getPostalCode());
		}
		return address;
	}

	@Override
	public boolean deleteById(int addressId) {
		Address deletedAddress = em.find(Address.class, addressId);
		boolean successfullDeletedAddress = false;
		if (deletedAddress != null) {
			em.remove(deletedAddress);
			successfullDeletedAddress = !em.contains(deletedAddress);
		}
		return successfullDeletedAddress;
	}

}
