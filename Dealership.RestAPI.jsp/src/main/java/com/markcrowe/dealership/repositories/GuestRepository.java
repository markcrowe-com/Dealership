package com.markcrowe.dealership.repositories;

import com.markcrowe.RepositoryBase;
import com.markcrowe.dealership.Guest;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class GuestRepository extends RepositoryBase<Guest>
{
	//@PersistenceContext(unitName = "Dealership")
	private final EntityManager entityManager;

	public GuestRepository()
	{
		super(Guest.class);
		entityManager = Persistence.createEntityManagerFactory("Dealership").createEntityManager();
	}

	public Guest getGuestById(int id)
	{
		return super.getEntityById(id);
	}

	public List<Guest> getGuests()
	{
		return super.getList();
	}

	public List<Guest> getGuests(int startPosition, int endPosition)
	{
		return super.getList(startPosition, endPosition);

	}

	@Override
	protected EntityManager getEntityManager()
	{
		return entityManager;
	}
}
