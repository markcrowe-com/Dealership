package com.markcrowe.dealership.repositories;

import com.markcrowe.RepositoryBase;
import com.markcrowe.dealership.Car;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class CarRepository extends RepositoryBase<Car>
{
	//@PersistenceContext(unitName = "Dealership")
	private final EntityManager entityManager;

	public CarRepository()
	{
		super(Car.class);
		entityManager = Persistence.createEntityManagerFactory("Dealership").createEntityManager();
	}

	public Car getCarById(int id)
	{
		return super.getEntityById(id);
	}

	public List<Car> getCarByRegistrationNumber(String registrationNumber)
	{
		return getEntityManager().createNamedQuery("Car.findByRegistrationNumber", Car.class).setParameter("registrationNumber", registrationNumber).getResultList();
	}

	public Car getCarByValue(String registrationNumber)
	{
		return getEntityManager().find(Car.class, registrationNumber);
	}

	public List<Car> getTop10Cars()
	{
		return getEntityManager().createNamedQuery("Car.findOrderByValueDesc", Car.class).setMaxResults(10).getResultList();
	}

	public List<Car> getCars()
	{
		return super.getList();
	}

	public List<Car> getCars(int startPosition, int endPosition)
	{
		return super.getList(startPosition, endPosition);
	}

	@Override
	protected EntityManager getEntityManager()
	{
		return entityManager;
	}
}
