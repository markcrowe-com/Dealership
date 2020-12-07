package ie.walshmedia.dealership.repositories;

import ie.walshmedia.RepositoryBase;
import ie.walshmedia.dealership.BodyType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class BodyTypeRepository extends RepositoryBase<BodyType>
{
	//@PersistenceContext(unitName = "Dealership")
	private final EntityManager entityManager;

	public BodyTypeRepository()
	{
		super(BodyType.class);
		entityManager = Persistence.createEntityManagerFactory("Dealership").createEntityManager();
	}

	public BodyType getBodyTypeById(int id)
	{
		return super.getEntityById(id);
	}

	public List<BodyType> getBodyTypes()
	{
		return super.getList();
	}

	public List<BodyType> getBodyTypes(int startPosition, int endPosition)
	{
		return super.getList(startPosition, endPosition);

	}

	@Override
	protected EntityManager getEntityManager()
	{
		return entityManager;
	}
}
