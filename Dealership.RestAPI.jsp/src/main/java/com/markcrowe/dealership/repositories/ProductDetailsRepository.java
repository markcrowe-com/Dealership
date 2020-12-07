package com.markcrowe.dealership.repositories;

import com.markcrowe.RepositoryBase;
import com.markcrowe.dealership.ProductDetails;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class ProductDetailsRepository extends RepositoryBase<ProductDetails>
{
	//@PersistenceContext(unitName = "Dealership")
	private final EntityManager entityManager;

	public ProductDetailsRepository()
	{
		super(ProductDetails.class);
		entityManager = Persistence.createEntityManagerFactory("Dealership").createEntityManager();
	}

	public ProductDetails getProductDetailsById(int id)
	{
		return super.getEntityById(id);
	}

	public List<ProductDetails> getProductDetailss()
	{
		return super.getList();
	}

	public List<ProductDetails> getProductDetailss(int startPosition, int endPosition)
	{
		return super.getList(startPosition, endPosition);

	}

	@Override
	protected EntityManager getEntityManager()
	{
		return entityManager;
	}
}
