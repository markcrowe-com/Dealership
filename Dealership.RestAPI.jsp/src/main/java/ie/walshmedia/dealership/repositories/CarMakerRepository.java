package ie.walshmedia.dealership.repositories;

import ie.walshmedia.RepositoryBase;
import ie.walshmedia.dealership.CarMaker;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class CarMakerRepository extends RepositoryBase<CarMaker>
{
	//@PersistenceContext(unitName = "Dealership")
	private final EntityManager entityManager;

	public CarMakerRepository()
	{
		super(CarMaker.class);
		entityManager = Persistence.createEntityManagerFactory("Dealership").createEntityManager();
	}

	public CarMaker getCarMakerById(int id)
	{
		return super.getEntityById(id);
	}

	public List<CarMaker> getCarMakers()
	{
		return super.getList();
	}

	public List<CarMaker> getCarMakers(int startPosition, int endPosition)
	{
		return super.getList(startPosition, endPosition);
	}

	@Override
	protected EntityManager getEntityManager()
	{
		return entityManager;
	}
}
