/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package ie.walshmedia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

public class RepositoryUtilites
{
	public static Query buildListRangeQuery(EntityManager entityManager, CriteriaQuery criteriaQuery, int endPosition, int startPosition)
	{
		int resultSize = endPosition - startPosition + 1;
		Query query = entityManager.createQuery(criteriaQuery);
		query.setMaxResults(resultSize);
		query.setFirstResult(startPosition);
		return query;
	}
	public static <T extends Object> List<T> getList(Class<T> entityClass, EntityManager entityManager)
	{
		CriteriaQuery criteriaQuery = entityManager.getCriteriaBuilder().createQuery();
		criteriaQuery.select(criteriaQuery.from(entityClass));
		return entityManager.createQuery(criteriaQuery).getResultList();
	}
	public static <T extends Object> List<T> getListRange(Class<T> entityClass, EntityManager entityManager, int startPosition, int endPosition)
	{
		CriteriaQuery criteriaQuery = entityManager.getCriteriaBuilder().createQuery();
		criteriaQuery.select(criteriaQuery.from(entityClass));
		Query query = RepositoryUtilites.buildListRangeQuery(entityManager, criteriaQuery, startPosition, endPosition);
		return query.getResultList();
	}
}
