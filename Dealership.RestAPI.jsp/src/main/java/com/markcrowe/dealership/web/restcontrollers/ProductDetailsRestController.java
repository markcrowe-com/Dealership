package com.markcrowe.dealership.web.restcontrollers;

import com.markcrowe.dealership.ProductDetails;
import com.markcrowe.dealership.repositories.ProductDetailsRepository;
import java.util.List;
import javax.ws.rs.Produces;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/productdetails")
public class ProductDetailsRestController
{
	public ProductDetailsRestController()
	{
		repository = new ProductDetailsRepository();
	}

	@GetMapping("/{id}")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public ProductDetails getProductDetailsById(@PathVariable("id") int id)
	{
		return repository.getProductDetailsById(id);
	}

	@GetMapping
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public List<ProductDetails> getProductDetailss()
	{
		return repository.getProductDetailss();
	}

	@GetMapping("/{from}/{to}")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public List<ProductDetails> getProductDetailsRange(@PathVariable("from") int from, @PathVariable("to") int to)
	{
		return repository.getProductDetailss(from, to);
	}

	private final ProductDetailsRepository repository;
}
