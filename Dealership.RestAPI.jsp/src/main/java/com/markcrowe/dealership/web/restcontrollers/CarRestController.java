package com.markcrowe.dealership.web.restcontrollers;

import com.markcrowe.dealership.Car;
import com.markcrowe.dealership.repositories.CarRepository;
import java.util.List;
import javax.ws.rs.Produces;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cars")
public class CarRestController
{

	public CarRestController()
	{
		repository = new CarRepository();
	}

	@GetMapping("/{id}")
	public Car getCarById(@PathVariable("id") int id)
	{
		return repository.getCarById(id);
	}

	@GetMapping
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public List<Car> getCars()
	{
		return repository.getCars();
	}

	@GetMapping("/{from}/{to}")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public List<Car> getCarsRange(@PathVariable("from") int from, @PathVariable("to") int to)
	{
		return repository.getCars(from, to);

	}

	private final CarRepository repository;

}
