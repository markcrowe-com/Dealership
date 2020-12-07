package ie.walshmedia.dealership.web.restcontrollers;

import ie.walshmedia.dealership.CarMaker;
import ie.walshmedia.dealership.repositories.CarMakerRepository;
import java.util.List;
import javax.ws.rs.Produces;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/carmakers")
public class CarMakerRestController
{
	public CarMakerRestController()
	{
		repository = new CarMakerRepository();
	}

	@GetMapping("/{id}")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public CarMaker getCarMakerById(@PathVariable("id") int id)
	{
		return repository.getCarMakerById(id);
	}

	@GetMapping
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public List<CarMaker> getCarMakers()
	{
		return repository.getCarMakers();
	}

	@GetMapping("/{from}/{to}")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public List<CarMaker> getCarMakerRange(@PathVariable("from") int from, @PathVariable("to") int to)
	{
		return repository.getCarMakers(from, to);
	}

	private final CarMakerRepository repository;
}
