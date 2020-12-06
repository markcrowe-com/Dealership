package ie.walshmedia.dealership.repositories;

import ie.walshmedia.dealership.CarModel;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Keith
 */
@Stateless
public class CarModelRepository
{
//	@PersistenceContext(unitName = "Dealership")

	private EntityManager entityManager;

	public CarModelRepository()
	{
		entityManager = Persistence.createEntityManagerFactory("Dealership").createEntityManager();
	}

	public CarModel getCarModelById(int id)
	{
		return getEntityManager().find(CarModel.class, id);
	}

	public List<CarModel> getCarModels()
	{
		CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
		cq.select(cq.from(CarModel.class));
		return getEntityManager().createQuery(cq).getResultList();
	}

	public List<CarModel> getCarModelRange(int[] range)
	{
		javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
		cq.select(cq.from(CarModel.class));
		javax.persistence.Query q = getEntityManager().createQuery(cq);
		q.setMaxResults(range[1] - range[0] + 1);
		q.setFirstResult(range[0]);
		return q.getResultList();
	}

	protected EntityManager getEntityManager()
	{
		return entityManager;
	}
}
