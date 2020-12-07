package com.markcrowe;

import java.util.List;
import javax.persistence.EntityManager;

public abstract class RepositoryBase<T>
{
	public RepositoryBase(Class<T> entityClass)
	{
		this.entityClass = entityClass;
	}

	public T getEntityById(int id)
	{
		return getEntityManager().find(entityClass, id);
	}

	public List<T> getList()
	{
		return RepositoryUtilites.getList(entityClass, getEntityManager());
	}

	public List<T> getList(int startPosition, int endPosition)
	{
		return RepositoryUtilites.getListRange(entityClass, getEntityManager(), startPosition, endPosition);
	}

	protected abstract EntityManager getEntityManager();
	private final Class<T> entityClass;
}
