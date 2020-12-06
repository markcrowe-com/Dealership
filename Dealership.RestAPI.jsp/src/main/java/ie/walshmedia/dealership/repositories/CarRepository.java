/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.walshmedia.dealership.repositories;

import ie.walshmedia.dealership.Car;
import ie.walshmedia.dealership.CarModel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Keith
 */
public class CarRepository
{
	//	@PersistenceContext(unitName = "Dealership")

	private EntityManager entityManager;

	public CarRepository()
	{
		entityManager = Persistence.createEntityManagerFactory("Dealership").createEntityManager();
	}

	public Car getCarById(int id)
	{
		return getEntityManager().find(Car.class, id);
	}

	public List<Car> getCars()
	{
		CriteriaQuery criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery();
		criteriaQuery.select(criteriaQuery.from(Car.class));
		return getEntityManager().createQuery(criteriaQuery).getResultList();
	}

	public List<Car> getCarsRange(int[] range)
	{
		CriteriaQuery criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery();
		criteriaQuery.select(criteriaQuery.from(Car.class));
		javax.persistence.Query q = getEntityManager().createQuery(criteriaQuery);
		q.setMaxResults(range[1] - range[0] + 1);
		q.setFirstResult(range[0]);
		return q.getResultList();
	}

	protected EntityManager getEntityManager()
	{
		return entityManager;
	}
}
