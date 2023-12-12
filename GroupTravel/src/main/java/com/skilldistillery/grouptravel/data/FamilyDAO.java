package com.skilldistillery.grouptravel.data;

import java.util.List;

import com.skilldistillery.grouptravel.entities.Family;

public interface FamilyDAO {

	List<Family> findFamilyByUserId(int id);

	Family create(Family family);

	Family update(int familyId, Family family);

	boolean deleteById(int familyId);

}
