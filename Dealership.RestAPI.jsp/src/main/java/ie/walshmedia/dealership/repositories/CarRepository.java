package ie.walshmedia.dealership.repositories;

import ie.walshmedia.RepositoryBase;
import ie.walshmedia.dealership.Car;
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
