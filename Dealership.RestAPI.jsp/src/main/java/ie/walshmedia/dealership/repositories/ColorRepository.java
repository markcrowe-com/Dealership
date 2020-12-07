package ie.walshmedia.dealership.repositories;

import ie.walshmedia.RepositoryBase;
import ie.walshmedia.dealership.Color;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class ColorRepository extends RepositoryBase<Color>
{
	//@PersistenceContext(unitName = "Dealership")
	private final EntityManager entityManager;

	public ColorRepository()
	{
		super(Color.class);
		entityManager = Persistence.createEntityManagerFactory("Dealership").createEntityManager();
	}

	public Color getColorById(int id)
	{
		return super.getEntityById(id);
	}

	public List<Color> getColors()
	{
		return super.getList();
	}

	public List<Color> getColors(int startPosition, int endPosition)
	{
		return super.getList(startPosition, endPosition);

	}

	@Override
	protected EntityManager getEntityManager()
	{
		return entityManager;
	}
}
