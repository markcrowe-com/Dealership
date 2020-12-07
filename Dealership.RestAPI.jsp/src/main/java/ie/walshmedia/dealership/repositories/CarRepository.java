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

	private final EntityManager entityManager;

	public CarRepository()
	{
		entityManager = Persistence.createEntityManagerFactory("Dealership").createEntityManager();
	}

	public Car getCarById(int id)
	{
		return getEntityManager().find(Car.class, id);
	}

	public Car getCarByRegistrationNumber(String registrationNumber)
	{
		return getEntityManager().createNamedQuery("Car.findByRegistrationNumber", Car.class).setParameter("registrationNumber", registrationNumber).getSingleResult();
	}

	public Car getCarByValue(String registrationNumber)
	{
		return getEntityManager().find(Car.class, registrationNumber);
	}

	public List<Car> getCars()
	{
		CriteriaQuery criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery();
		criteriaQuery.select(criteriaQuery.from(Car.class));
		return getEntityManager().createQuery(criteriaQuery).getResultList();
	}

	@SuppressWarnings("unchecked")
	public void findAllOrderedByName()
	{
	}

	public List<Car> getTop10Cars()
	{
		return getEntityManager().createNamedQuery("Car.findOrderByValueDesc", Car.class).setMaxResults(10).getResultList();
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
