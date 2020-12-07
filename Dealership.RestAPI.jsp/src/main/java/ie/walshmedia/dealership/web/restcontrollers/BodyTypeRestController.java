package ie.walshmedia.dealership.web.restcontrollers;

import ie.walshmedia.dealership.BodyType;
import ie.walshmedia.dealership.repositories.BodyTypeRepository;
import java.util.List;
import javax.ws.rs.Produces;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/bodytypes")
public class BodyTypeRestController
{
	public BodyTypeRestController()
	{
		repository = new BodyTypeRepository();
	}

	@GetMapping("/{id}")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public BodyType getBodyTypeById(@PathVariable("id") int id)
	{
		return repository.getBodyTypeById(id);
	}

	@GetMapping
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public List<BodyType> getBodyTypes()
	{
		return repository.getBodyTypes();
	}

	@GetMapping("/{from}/{to}")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public List<BodyType> getBodyTypeRange(@PathVariable("from") int from, @PathVariable("to") int to)
	{
		return repository.getBodyTypes(from, to);
	}

	private final BodyTypeRepository repository;
}
