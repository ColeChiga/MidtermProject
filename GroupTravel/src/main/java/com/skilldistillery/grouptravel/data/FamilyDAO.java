package com.skilldistillery.grouptravel.data;

import java.util.List;

import com.skilldistillery.grouptravel.entities.Family;
import com.skilldistillery.grouptravel.entities.User;

public interface FamilyDAO {

	List<Family> findFamilyByUserId(int id);

	Family create(Family family);

	Family update(int familyId, Family family, User user);

	boolean deleteById(int familyId);
	
	public List<Family> findAll();

}
