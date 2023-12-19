package com.skilldistillery.grouptravel.data;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.grouptravel.entities.Address;
import com.skilldistillery.grouptravel.entities.Destination;
import com.skilldistillery.grouptravel.entities.Address;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class AddressDaoImpl implements AddressDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Address> findAll() {
		String jpql = "SELECT address FROM Address address";
		return em.createQuery(jpql, Address.class).getResultList();
	}
	@Override
	public Address findAddressByInfo(String street, String city, String state, String postalCode) {
		String jpql = "SELECT address FROM Address address WHERE "
				+ "address.street LIKE :street AND "
				+ "address.city LIKE :city AND "
				+ "address.state LIKE :state AND "
				+ "address.postalCode LIKE :postalCode";
		
		try {
			Address address = em.createQuery(jpql, Address.class)
					.setParameter("street", street)
					.setParameter("city", city)
					.setParameter("state", state)
					.setParameter("postalCode", postalCode)
					.getSingleResult();
			
			return address;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Address findAddressById(int addressId) {
		return em.find(Address.class, addressId);
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
