package com.markcrowe.dealership.repositories;

import com.markcrowe.RepositoryBase;
import com.markcrowe.dealership.CarModel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class CarModelRepository extends RepositoryBase<CarModel>
{
	//@PersistenceContext(unitName = "Dealership")
	private final EntityManager entityManager;

	public CarModelRepository()
	{
		super(CarModel.class);
		entityManager = Persistence.createEntityManagerFactory("Dealership").createEntityManager();
	}

	public CarModel getCarModelById(int id)
	{
		return super.getEntityById(id);
	}

	public List<CarModel> getCarModels()
	{
		return super.getList();
	}

	public List<CarModel> getCarModels(int startPosition, int endPosition)
	{
		return super.getList(startPosition, endPosition);

	}

	@Override
	protected EntityManager getEntityManager()
	{
		return entityManager;
	}
}
